package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.contato.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.contato.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import com.fasterxml.jackson.databind.ObjectMapper;
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
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;
    @Autowired
    private ObjectMapper objectMapper;

//    public ContatoController () {
//        contatoService = new ContatoService();
//    }

    @ApiOperation(value = "Retorna todos os Contatos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna todos os contatos"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping
    public List<ContatoDTO> list() {
        log.info("Listar Contato");
        return contatoService.list();
    }

    @ApiOperation(value = "Retorna todos os Contatos de uma Pessoa especifica (ID da Pessoa)")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna todos os contatos da Pessoa"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/{idPessoa}")
    public List<ContatoDTO> listByPessoaId (@Valid @PathVariable("idPessoa") Integer id) {
        log.info("Listar Contatos por Pessoa");
        return contatoService.listByPessoaId(id);
    }

    @ApiOperation(value = "Inseri e Retorna o Contato Inserido")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o contato Inserido"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping("/{idPessoa}")
    public ContatoDTO create(@Valid @PathVariable("idPessoa") Integer idPessoa, @RequestBody ContatoCreateDTO contato) {
        contato.setIdPessoa(idPessoa);
        log.info("Inserir Contato");
        return contatoService.create(contato);
    }

    @ApiOperation(value = "Altera e Retorna o Contato Alterado")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o Contato Alterado"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PutMapping("/{idContato}")
    public ContatoDTO update(@Valid @PathVariable("idContato") Integer id,
                          @Valid @RequestBody ContatoCreateDTO contatoUpdate) throws Exception {
        log.info("Atualizar Contato");
        return contatoService.update(id, contatoUpdate);
    }

    @ApiOperation(value = "Remove e Retorna o Contato Removido")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o Contato Removido"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping("/{idContato}")
    public ContatoDTO delete(@Valid @PathVariable("idContato") Integer id) throws Exception {
        log.info("Remover Contato");
        return contatoService.delete(id);
    }
}
