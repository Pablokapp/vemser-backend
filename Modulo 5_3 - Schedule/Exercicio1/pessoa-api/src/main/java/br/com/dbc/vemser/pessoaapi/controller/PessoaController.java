package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.pessoa.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.pessoa.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.service.EmailService;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
//import br.com.dbc.vemser.pessoaapi.service.PropertieReader;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@Log
@RequestMapping("/pessoa") // localhost:8080/pessoa
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;



    @Autowired
    private EmailService emailService;

//    public PessoaController() {
//        pessoaService = new PessoaService();
//    }

    @ApiOperation(value = "Hello World!")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a mensagem 'Hello world!'")
    })
    @GetMapping("/hello") // localhost:8080/pessoa/hello
    public String hello() {
        return "Hello world!";
    }

    @ApiOperation(value = "Insere e retorna a pessoa inserida")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a pessoa inserida"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping // localhost:8080/pessoa
    public PessoaDTO create(@Valid @RequestBody PessoaCreateDTO pessoa) {
        log.info("Pessoa Inserida");
        return pessoaService.create(pessoa);
    }

    @ApiOperation(value = "Retorna uma lista de pessoas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de pessoas"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping // localhost:8080/pessoa
    public List<PessoaDTO> list() {
        log.info("Request de pessoas");
        return pessoaService.list();
    }

    @ApiOperation(value = "Retorna a pessoa com este nome (Ex.: ENTRADA: 'pereira' | SAIDA: [DADOS DE] 'Charles Pereira Lima')")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a pessoa encontrada"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/byname") // localhost:8080/pessoa/byname?nome=Rafa
    public List<PessoaDTO> listByName(@Valid @RequestParam("nome") String nome) {
        log.info("Request de pessoa por nome");
        return pessoaService.listByName(nome);
    }

    @ApiOperation(value = "Altera e retorna a pessoa alterada")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a pessoa alterada"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    public PessoaDTO update(@Valid @PathVariable("idPessoa") Integer id,
                         @Valid @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception {
        log.info("Pessoa Atualizada");
        return pessoaService.update(id, pessoaAtualizar);
    }

    @ApiOperation(value = "Remove e retorna a pessoa removida")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a pessoa removida"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public void delete(@Valid @PathVariable("idPessoa") Integer id) throws Exception {
        log.info("Pessoa Removida");
        pessoaService.delete(id);
    }

//    @GetMapping("/ambiente")
//    public String getAmbiente () {
//        return propertieReader.getAmbiente();
//    }
}
