package br.com.dbc.vemser.pessoaapi.controller;


import br.com.dbc.vemser.pessoaapi.service.EmailProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailProducerService emailProducerService;

    @PostMapping("/send")
    public void sendEmail(@RequestParam String destinatario, @RequestParam String assunto, @RequestBody String mensagem) throws JsonProcessingException {
        emailProducerService.sendEmail(destinatario, assunto, mensagem);
    }
}
