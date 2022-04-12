package com.dbc.pessoaapi.controller;


import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.TipoContato;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.service.ContatoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {
    @Autowired
    private ContatoService contatoService;

    @Autowired
    private ContatoRepository contatoRepository;



    @ApiOperation(value = "Apaga um contato")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "O contato foi apagado!"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        contatoService.delete(id);
    }

    @GetMapping("/listarContatoPorTipo")
    public List<ContatoEntity> listarContatoPorTipo(@RequestParam("tipo") TipoContato tipo){
        return contatoRepository.findContatoPorTipoContato(tipo);
    }

    @ApiOperation(value = "Cria um contato")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "contato criado! "),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping("/{idPessoa}")
    public ContatoDTO create(@PathVariable("idPessoa") Integer idPessoa,
                             @RequestBody ContatoCreateDTO contato) throws Exception {
        return contatoService.create(idPessoa, contato);
    }


    @ApiOperation(value = "Atualiza um contato")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "pessoa atualizada"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PutMapping("/{id}")
    public ContatoDTO update(@PathVariable("id") Integer id,
                                @RequestBody ContatoCreateDTO contato) throws Exception {
        return contatoService.update(id, contato);
    }

    @ApiOperation(value = "Lista todos os contatos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "retorna uma lista com os contatos"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/listar")
    public List<ContatoDTO> list() {
        return contatoService.list();
    }

//    // {{url}}/contato/1/pessoa
//    @GetMapping("/{idPessoa}/pessoa")
//    public List<ContatoDTO> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
//        return contatoService.listByIdPessoa(idPessoa);
//    }


    @ApiOperation(value = "Retorna um contato por id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna um contato por id"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/{idContato}/contato")
    public ContatoDTO listByIdContato(@PathVariable("idContato") Integer idContato) throws Exception {
        return contatoService.encontrarContatoPorId(idContato);
    }



    @ApiOperation(value = "Lista os contatos de uma pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna um contato por id"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/list-by-pessoas")
    public List<ContatoDTO> listByIdPessoa (@RequestParam("idPessoa") Integer id) {
        return contatoService.listContatoByIdPessoa(id);
    }
}