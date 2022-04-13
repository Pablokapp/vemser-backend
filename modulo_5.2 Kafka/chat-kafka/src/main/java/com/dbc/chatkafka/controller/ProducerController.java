package com.dbc.chatkafka.controller;

import com.dbc.chatkafka.enums.Topicos;
import com.dbc.chatkafka.service.ProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProducerController {
    private final ProducerService producerService;
    @PostMapping("/enviar")
    public void enviarMensagem(@RequestParam String mensagem, @RequestParam List<Topicos> topico) throws JsonProcessingException {
        producerService.sendMessage(mensagem, topico);
    }

}
