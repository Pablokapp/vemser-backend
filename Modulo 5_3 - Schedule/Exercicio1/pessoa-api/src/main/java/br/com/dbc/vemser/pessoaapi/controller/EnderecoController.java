package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.endereco.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.endereco.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@Log
@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @ApiOperation(value = "Retorna todos os enderecos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna todos os enderecos encontrados"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping
    public List<EnderecoDTO> get() {
        return enderecoService.list();
    }

    @ApiOperation(value = "Retorna o endereco do respectivo ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o endereco encontrado"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/{idEndereco}")
    public EnderecoDTO getById(@Valid @PathVariable("idEndereco") Integer idEndereco) throws Exception {
        return enderecoService.getById(idEndereco);
    }

    @ApiOperation(value = "Retorna todos os Enderecos de uma Pessoa (busca por ID da Pessoa)")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna os enderecos da pessoa"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/{idPessoa}/pessoa")
    public List<EnderecoDTO> getByPessoa(@Valid @PathVariable("idPessoa") Integer idPessoa) throws Exception {
        return enderecoService.getByPessoa(idPessoa);
    }

    @ApiOperation(value = "Inseri e Retorna um novo Endereco vinculando a uma Pessoa (ID pessoa)")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o endereco Inserido"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping("/{idPessoa}")
    public EnderecoDTO create(@Valid @PathVariable("idPessoa") Integer idPessoa,
                           @Valid @RequestBody EnderecoCreateDTO endereco) throws Exception {
        log.info("Endereco Inserido!");
        return enderecoService.create(idPessoa, endereco);
    }

    @ApiOperation(value = "Altera e Retorna o Endereco Alterado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o endereco alterado"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PutMapping("/{idEndereco}")
    public EnderecoDTO update(@Valid @PathVariable("idEndereco") Integer idEndereco,
                           @Valid @RequestBody EnderecoCreateDTO endereco) throws Exception {
        log.info("Endereco Atualizado!");
        return enderecoService.update(idEndereco, endereco);
    }

    @ApiOperation(value = "Remove e Retorna o Endereco Removido")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o endereco removido"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping("/{idEndereco}")
    public EnderecoDTO delete(@Valid @PathVariable("idEndereco") Integer id) throws Exception {
        log.info("Endereco Removido!");
        return enderecoService.delete(id);
    }
}
