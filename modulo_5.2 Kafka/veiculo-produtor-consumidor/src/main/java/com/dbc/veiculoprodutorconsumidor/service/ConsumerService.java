package com.dbc.veiculoprodutorconsumidor.service;
import com.dbc.veiculoprodutorconsumidor.dtos.RegistroCreateDTO;
import com.dbc.veiculoprodutorconsumidor.dtos.RegistroDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {
    private final ObjectMapper objectMapper;
    private final RegistroService registroService;


    @KafkaListener(
            topics = "${kafka.topic}",
            groupId = "group1",
            containerFactory = "listenerContainerFactory")
    public void consume(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {

        RegistroCreateDTO registroCreateDTO = objectMapper.readValue(message, RegistroCreateDTO.class);
        registroService.salvar(registroCreateDTO);
        log.info("#### offset -> '{}' key -> '{}' -> Consumed Object message -> '{}'  ", offset, key, message);
    }
}
