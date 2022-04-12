package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa

@Log
public class PessoaController {


    private PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
//        pessoaService = new PessoaService();
    }

    @GetMapping("/hello") // localhost:8080/pessoa/hello
    public String hello() {
        log.info("chamou o hello");
        return "Hello world!";
    }


    @PostMapping // localhost:8080/pessoa
    @Validated
    public PessoaDTO create(@Valid @RequestBody PessoaCreateDTO pessoa){

        log.info("Método create pessoa controller");
        return pessoaService.create(pessoa);
    }

    @GetMapping // localhost:8080/pessoa
    public List<PessoaDTO> list() {
        log.info("método listar pessoa controller");
        return pessoaService.list();
    }

    @GetMapping("/byname") // localhost:8080/pessoa/byname?nome=Rafa
    public List<PessoaDTO> listByName(@RequestParam("nome") String nome) {
        log.info("Método listar por nome controller");
        return pessoaService.listByName(nome);
    }

    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    @Validated
    public PessoaDTO update(@Valid @PathVariable("idPessoa") Integer id,
                         @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception {
        log.info("Método update pessoa controller");
        return pessoaService.update(id, pessoaAtualizar);
    }

    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public void delete(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        log.info("método delete pessoa controller");
        pessoaService.delete(id);
    }


}
