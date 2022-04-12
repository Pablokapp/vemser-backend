package com.dbc.produtor.controller;


import com.dbc.produtor.service.Produtor2Service;
import com.dbc.produtor.service.ProdutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {
    private final ProdutorService produtorService;
    private final Produtor2Service produtor2Service;

    @PostMapping("/Enviar Produtor 1")
    private void enviar(String mensagem) {
        produtorService.enviarMensagem(mensagem);
    }

    @PostMapping("/Enviar Produtor 2")
    private void enviar2(String mensagem) {
        produtor2Service.enviarMensagem(mensagem);
    }
}

