package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;

import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import freemarker.template.TemplateException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
@Log
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;



//    @Value("${ambiente}")
//    private String ambiente;
//
//    @Value("${spring.mail.user}")
//    private String mailUser;
//
//    @Value("${spring.mail.password}")
//    private String mailPass;


    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
//        pessoaService = new PessoaService();
    }



    @GetMapping("/hello") // localhost:8080/pessoa/hello
    public String hello() {
        log.info("chamou o hello");

       // emailService.sendSimpleMessage();
        return "Hello world!";
    }

    @ApiOperation(value = "Cria e adiciona uma pessoa a lista")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pessoa criada"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping // localhost:8080/pessoa
    @Validated
    public PessoaDTO create(@Valid @RequestBody PessoaCreateDTO pessoa) throws TemplateException, IOException {
        log.info("Método create pessoa controller");
        return pessoaService.create(pessoa);
    }

    @ApiOperation(value = "Lista todos os registros")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/all") // localhost:8080/pessoa
    public List<PessoaDTO> list() {
        log.info("método listar pessoa controller");
        return pessoaService.list();
    }

    @ApiOperation(value = "Listar pessoas por nome")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista de pessoas"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/byname") // localhost:8080/pessoa/byname?nome=Rafa
    public List<PessoaDTO> listByName(@RequestParam("nome") String nome) {
        log.info("Método listar por nome controller");
        return pessoaService.listByName(nome);
    }

    @ApiOperation(value = "Atualiza informações pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Atualização concluída"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    @Validated
    public PessoaDTO update(@Valid @PathVariable("idPessoa") Integer id,
                         @RequestBody PessoaCreateDTO pessoaAtualizar) throws Exception {
        log.info("Método update pessoa controller");
        return pessoaService.update(id, pessoaAtualizar);
    }
    @ApiOperation(value = "Exclui pessoa por id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "A pessoa foi excluída"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public void delete(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException, TemplateException, IOException {
        log.info("método delete pessoa controller");
        pessoaService.delete(id);
    }
}
