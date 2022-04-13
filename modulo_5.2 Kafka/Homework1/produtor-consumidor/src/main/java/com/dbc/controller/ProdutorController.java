package com.dbc.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dbc.service.ProdutorService;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {
    private final ProdutorService produtorService;


    @PostMapping("/Enviar Produtor 1")
    private void enviar(String mensagem) {
        produtorService.enviarMensagem(mensagem);


    }
}