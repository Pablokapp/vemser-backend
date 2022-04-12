package br.com.dbc.vemser.pessoaapi.controller;
import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/contato")
@Log
public class ContatoController {

    private final ContatoService contatoService;

    @Autowired
    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }


    @ApiOperation(value = "Cria um novo contato")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping("/create")
    public ContatoDTO create(@RequestBody ContatoCreateDTO contato) throws RegraDeNegocioException{
        log.info("create contatoController");
        return contatoService.create(contato);
    }

    @ApiOperation(value = "lista todos os contatos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping
    public List<ContatoDTO> list(){
        log.info("list contatoController");
        return contatoService.list();
    }

    @ApiOperation(value = "Atualiza um contato por id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PutMapping("/{id}")
    public ContatoDTO update (@PathVariable("id") Integer id,@RequestBody ContatoCreateDTO contato) throws RegraDeNegocioException {
        log.info("update contatoController");
        return contatoService.update(id, contato);
    }

    @ApiOperation(value = "Exclui contato por id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping("/{id}")
    public void delete (@PathVariable("id")Integer id) throws RegraDeNegocioException{
        log.info("delete contatoController");
        contatoService.delete(id);
    }

    @ApiOperation(value = "lista todos os contatos de uma pessoa por id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/pessoa/{id}")
    public List<ContatoDTO> listContactsPerson (@PathVariable("id") Integer idPessoa){
        log.info("list contatoController");
        return contatoService.listContactsPerson(idPessoa);
    }


    @ApiOperation(value = "Lista contatos por tipo")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna uma lista"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/tipo")
    public List<ContatoDTO> findByType (@RequestParam("tipo") String tipo){
        log.info("findByType contatoController");
        return contatoService.findByType(tipo);
    }

}
