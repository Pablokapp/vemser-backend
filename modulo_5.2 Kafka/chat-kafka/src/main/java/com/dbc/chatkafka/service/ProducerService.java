package com.dbc.chatkafka.service;

import com.dbc.chatkafka.dto.ProdutorDTO;
import com.dbc.chatkafka.enums.Topicos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProducerService {

    private final KafkaTemplate<String,String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Value(value = "${kafka.client-id}")
    private String clientId;

    public void sendMessage(String mensagem, List<Topicos> chats) throws JsonProcessingException {
        ProdutorDTO produtorDTO = ProdutorDTO.builder()
                .mensagem(mensagem)
                .dataCriacao(LocalDateTime.now())
                .usuario(clientId)
                .build();
        String payload = objectMapper.writeValueAsString(produtorDTO);
        for (Topicos chat : chats) {
            send(payload, chat.getChatName());
        }

    }

    public void sendReturn(String usuario) throws JsonProcessingException {
        String mensagem = "Mensagem enviada recebida pelo usuário Pablo";

        ProdutorDTO produtorDTO = ProdutorDTO.builder()
                .mensagem(mensagem)
                .dataCriacao(LocalDateTime.now())
                .usuario(clientId)
                .build();

        String payload = objectMapper.writeValueAsString(produtorDTO);

        send(payload, "chat-"+usuario);

    }





    private void send(String mensagem, String chat)  {
            Message<String> message = MessageBuilder.withPayload(mensagem)
                    .setHeader(KafkaHeaders.TOPIC, chat)
                    .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString())
                    .build();

            ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(message);

            future.addCallback(new ListenableFutureCallback<>() {
                @Override
                public void onSuccess(SendResult result) {
                    log.info(" Log enviado para o kafka com o texto: {} , e para o tópico: {}", mensagem, chat);
                }

                @Override
                public void onFailure(Throwable ex) {
                    log.error(" Erro ao publicar duvida no kafka com a mensagem: {}", mensagem, ex);
                }
            });
    }

}
