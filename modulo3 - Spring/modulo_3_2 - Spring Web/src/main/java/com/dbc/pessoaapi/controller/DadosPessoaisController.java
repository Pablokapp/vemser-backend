package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.client.DadosPessoaisClient;
import com.dbc.pessoaapi.dto.DadosPessoaisDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dados-pessoais")
@RequiredArgsConstructor
public class DadosPessoaisController {
    private final DadosPessoaisClient client;

    @GetMapping("/listar")
    public List<DadosPessoaisDTO> listDadosPessoais() {
        return client.getAll();
    }

    @PostMapping("/create")
    public DadosPessoaisDTO create(
            @RequestBody DadosPessoaisDTO dadosPessoaisDTO) throws Exception {
        return client.post(dadosPessoaisDTO);
    }

    @PutMapping("/{cpf}")
    public DadosPessoaisDTO update(@PathVariable("cpf") String cpf,
                          @RequestBody DadosPessoaisDTO dto) throws Exception {
        return client.put(cpf, dto);
    }

    @GetMapping("/{cpf}")
    public DadosPessoaisDTO getByCpf(@PathVariable("cpf") String cpf){
        return client.get(cpf);
    }

    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable("cpf") String cpf){
        client.delete(cpf);
    }
}
