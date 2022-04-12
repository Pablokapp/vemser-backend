package br.com.dbc.vemser.pessoaapi.controller;


import br.com.dbc.vemser.pessoaapi.client.DadosPessoaisClient;
import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/dados-pessoais")
@RequiredArgsConstructor
public class DadosPessoaisController {

    @Autowired
    private DadosPessoaisClient dadosPessoaisClient;

    @GetMapping
    public List<DadosPessoaisDTO> listDadosPessoais() {
        return dadosPessoaisClient.getAll();
    }

    @PostMapping
    public DadosPessoaisDTO create(
            @RequestBody DadosPessoaisDTO dadosPessoaisDTO) throws Exception {
        return dadosPessoaisClient.post(dadosPessoaisDTO);
    }

    @PutMapping("/{cpf}")
    public DadosPessoaisDTO update(@PathVariable("cpf") String cpf,
                          @RequestBody DadosPessoaisDTO dto) throws Exception {
        return dadosPessoaisClient.put(cpf, dto);
    }

    @GetMapping("/{cpf}")
    public DadosPessoaisDTO getByCpf(@PathVariable("cpf") String cpf)
    {
        return dadosPessoaisClient.get(cpf);
    }

    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable("cpf") String cpf){

        dadosPessoaisClient.delete(cpf);
    }
}
