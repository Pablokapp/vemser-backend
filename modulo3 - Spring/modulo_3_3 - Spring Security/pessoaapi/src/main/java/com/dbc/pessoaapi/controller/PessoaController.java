package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.*;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.dbc.pessoaapi.service.PessoaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
@Validated
@Slf4j
@RequiredArgsConstructor
public class PessoaController {
    private final PessoaService pessoaService;

    private final PessoaRepository pessoaRepository;

    @Value("${spring.application.name}")
    private String name;

    @GetMapping("/listar")
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }

    @GetMapping("/pessoa-entre-datas-nascimento")
    public List<PessoaEntity> pessoasPorNascimentoEntreDatas(@PathVariable("dataInicial")LocalDate dataInicial,
                                                             @PathVariable("dataFinal") LocalDate dataFinal){
        return pessoaRepository.findByDataNascimentoBetween(dataInicial, dataFinal);
    }

//    @GetMapping("/pessoas-que-possuem-endereco")
//    public List<PessoaEntity> pessoasQuePossuemEndereco(){
//        return pessoaRepository.pessoasQuePossuemEndereco();
//    }

    @GetMapping("/pessoas-com-e-endereco-contato")
    public List<PessoaDTOCompleto> pessoaDTOCompletos (@RequestParam(required = false)Integer idPessoa) throws RegraDeNegocioException {
        return pessoaService.listaPessoas(idPessoa);
    }


    @ApiOperation(value = "Cria uma pessoas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "cria uma pessoa"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping("/create")
    public ResponseEntity<PessoaDTO> create(@RequestBody @Valid PessoaCreateDTO pessoa) throws Exception {
        log.info("criando pessoa");
        PessoaDTO pessoaCriado = pessoaService.create(pessoa);
        return new ResponseEntity<>(pessoaCriado, HttpStatus.CREATED);
    }

    @GetMapping("/listar-com-contatos")
    public List<PessoaDTOComContatos> listarComContatos(@RequestParam(required = false) Integer idPessoa) throws RegraDeNegocioException {
        return pessoaService.listarComContatos(idPessoa);
    }

    @GetMapping("/findEndereco-by-idPessoa")
    public List<PessoaDTOComEnderecos> findEnderecoByIdPessoa(@RequestParam(required = false) Integer idPessoa){
        return pessoaService.listarComEnderecos(idPessoa);
    }

    @ApiOperation(value = "Retorna uma lista de pessoas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de pessoas"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/byname")
    public List<PessoaDTO> listByName(@RequestParam("nome") @NotEmpty(message = "nome da pessoa não informado") String nome) {
//        return pessoaService.listByName(nome);
        return pessoaService.listByName(nome);
    }

    @GetMapping("/bycpf")
    public List<PessoaDTO> listByCpf(@RequestParam("cpf") @NotEmpty(message = "cpf da pessoa não informado") String cpf) {
//        return pessoaService.listByName(nome);
        return pessoaService.listByCpf(cpf);
    }

    @GetMapping("/byname-containing-ignorecase")
    public List<PessoaDTO> listByNameContainingIgnoreCase(@RequestParam("nome") @NotEmpty(message = "nome da pessoa") String nome){
        return pessoaService.listByNameContainingIgnoreCase(nome);
    }

    @ApiOperation(value = "Atualiza uma pessoas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pessoa atualizada"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })

    @GetMapping("/data-nascimento")
    public List<PessoaDTO> listByNameOrDataNascimento(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate dataNascimentoInicial,
                                                      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate dataNascimentoFinal){
        return pessoaService.findByDataNascimento(dataNascimentoInicial, dataNascimentoFinal);
    }

    @PutMapping("/{idPessoa}")
    public PessoaDTO update(@PathVariable("idPessoa") Integer id,
                         @RequestBody @Valid PessoaCreateDTO pessoaAtualizar) throws Exception {
        return pessoaService.update(id, pessoaAtualizar);
    }

    @ApiOperation(value = "Delete uma pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Deleta uma pessoa"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }














}
