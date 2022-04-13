package com.dbc.veiculoprodutorconsumidor.controller;


import com.dbc.veiculoprodutorconsumidor.dtos.RegistroDTO;
import com.dbc.veiculoprodutorconsumidor.service.ProdutorService;
import com.dbc.veiculoprodutorconsumidor.service.RegistroService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class Controller {
    private final ProdutorService produtorService;
    private final RegistroService registroService;


    @PostMapping("/registro")
    private void enviar(RegistroDTO registroDTO) throws JsonProcessingException {
        produtorService.enviarRegistro(registroDTO);
    }

    @GetMapping("/listar")
    private List<RegistroDTO> receber() throws JsonProcessingException {
       return registroService.listar();
    }

    @GetMapping("/media-velocidade")
    private Double mediaVelocidade() throws JsonProcessingException {
        return registroService.velocidadeMedia();
    }

    @GetMapping("/media-rotacao")
    private Double mediaRotacao() throws JsonProcessingException {
        return registroService.mediaRotacao();
    }

    @GetMapping("/qtd-leituras")
    private Long qtdRegistros() throws JsonProcessingException {
        return registroService.qtdLeituras();
    }

}