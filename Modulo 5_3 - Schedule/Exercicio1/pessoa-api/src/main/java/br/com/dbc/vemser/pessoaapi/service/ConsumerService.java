package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EmailDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {

    private final ObjectMapper objectMapper;

    private final EmailService emailService;

    private List<EmailDTO> emails = new ArrayList<>();

    @Scheduled(fixedDelay = 300000)
    public void sendEmail(){
        if(!emails.isEmpty()){
            emailService.sendSimpleEmail(emails.get(0));
            emails.remove(0);
        }else {
            log.info("emails is empty");
        }
    }

    @KafkaListener(
            topics = "${kafka.topic}",
            groupId = "${kafka.client-id}",
            containerFactory = "listenerContainerFactory")
    public void consume(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {

        EmailDTO emailDTO = objectMapper.readValue(message, EmailDTO.class);
        emails.add(emailDTO);
        log.info("#### offset -> '{}' key -> '{}' -> Consumed Object message -> '{}'  ", offset, key, message);


    }
}