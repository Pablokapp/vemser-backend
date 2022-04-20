package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EmailDTO;
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

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailProducerService {

    private final KafkaTemplate<String,String> kafkaTemplate;
    private final ObjectMapper objectMapper;


    @Value(value = "${kafka.topic}")
    private String topic;


    public void sendEmail(String destinatario, String assunto, String texto) throws JsonProcessingException {
        EmailDTO emailDTO = EmailDTO.builder()
                .destinatario(destinatario)
                .assunto(assunto)
                .texto(texto)
                .build();

        String payload = objectMapper.writeValueAsString(emailDTO);
        Message<String> message = MessageBuilder.withPayload(payload)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString())
                .build();

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(message);

        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult result) {
                log.info(" Log enviado ", payload);
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error(" Erro ao enviar {}", payload, ex);
            }
        });
    }

}
