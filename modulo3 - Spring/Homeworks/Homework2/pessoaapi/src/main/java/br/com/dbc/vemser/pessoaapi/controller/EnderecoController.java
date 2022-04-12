package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.EmailService;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import freemarker.template.TemplateException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/endereco")
@Log
public class EnderecoController {


    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private EmailService emailService;
    @Autowired
    PessoaService pessoaService;

    @ApiOperation(value = "Lista todos os endereços")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/")
    public List<EnderecoDTO> getEnderecos (){
        log.info("getEnderecos EnderecoController");
        return enderecoService.list();
    }
    @ApiOperation(value = "Lista todos os endereços por id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/{id}")
    public EnderecoDTO findById (@PathVariable("id") Integer idEndereco)throws RegraDeNegocioException {
        log.info("findById EnderecoController");
        return enderecoService.findById(idEndereco);
    }

    @ApiOperation(value = "Lista todos os endereços por pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/{idPessoa}/pessoa")
    public List<EnderecoDTO> findByPerson (@PathVariable("idPessoa")Integer idPessoa){
        log.info("findByPerson EnderecoController");
        return enderecoService.findByPerson(idPessoa);
    }

    @ApiOperation(value = "Cria um novo endereço")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping("/{idPessoa}")
    public EnderecoDTO create (@PathVariable("idPessoa") Integer idPessoa,@RequestBody EnderecoCreateDTO endereco) throws RegraDeNegocioException, TemplateException, IOException {
        log.info("create EnderecoController");
        return enderecoService.create(endereco,idPessoa);
    }

    @ApiOperation(value = "Atualiza um endereço por id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PutMapping("/{id}")
    public EnderecoDTO update (@PathVariable ("id")Integer id,@RequestBody EnderecoCreateDTO endereco) throws RegraDeNegocioException, TemplateException, IOException {
        log.info("update EnderecoController");
        return enderecoService.update(id, endereco);
    }


    @ApiOperation(value = "Deleta um endeeço por id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping("/{id}")
    public void delete ( @PathVariable("id")Integer id) throws RegraDeNegocioException, TemplateException, IOException {
        log.info("delete EnderecoController");
        enderecoService.delete(id);
    }

}
