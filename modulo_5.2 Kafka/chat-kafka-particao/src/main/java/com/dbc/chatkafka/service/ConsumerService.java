package com.dbc.chatkafka.service;

import com.dbc.chatkafka.dto.ProdutorDTO;
import com.dbc.chatkafka.enums.Topicos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {

    private final ObjectMapper objectMapper;
    private final ProducerService producerService;


    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @KafkaListener(
            topicPartitions = @TopicPartition(topic = "chat-marcar-churrasco", partitions = {"0"}),
            groupId = "${kafka.group-id}",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "geral")
    public void consumeChatGeral(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partitionId,
                        @Header(KafkaHeaders.RECEIVED_TOPIC) String topic
    ) throws JsonProcessingException {

        ProdutorDTO produtorDTO = objectMapper.readValue(message, ProdutorDTO.class);
        String data = produtorDTO.getDataCriacao().format(formatter);
        System.out.println(data + " [" + produtorDTO.getUsuario() + "] "  + produtorDTO.getMensagem());
        log.info("#### offset -> '{}' key -> '{}' -> Consumed Object message -> '{}'  ", offset, key, message);
    }

    @KafkaListener(
            topicPartitions = @TopicPartition(topic = "chat-marcar-churrasco", partitions = {"13"}),
            groupId = "${kafka.group-id}",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "private")
    public void consumeMyChat(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset,
                              @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partitionId,
                              @Header(KafkaHeaders.RECEIVED_TOPIC) String topic
    ) throws JsonProcessingException {
        ProdutorDTO produtorDTO = objectMapper.readValue(message, ProdutorDTO.class);
        String data = produtorDTO.getDataCriacao().format(formatter);


        if (!produtorDTO.getUsuario().equals("${kafka.client-id}")) {
            producerService.sendReturn(produtorDTO.getUsuario(), Topicos.returnOrdinal(produtorDTO.getUsuario()));
        }


        System.out.println(data + " [" + produtorDTO.getUsuario() + "] (privada): "  + produtorDTO.getMensagem());
        log.info("#### offset -> '{}' key -> '{}' -> Consumed Object message -> '{}'  ", offset, key, message);
    }
}
