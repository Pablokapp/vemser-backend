package br.com.dbc.vemser.pessoaapi.controller;
import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
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

//        contatoService = new ContatoService();
    }


    @PostMapping("/create")
    public ContatoDTO create(@RequestBody ContatoCreateDTO contato) throws RegraDeNegocioException{
        log.info("create contatoController");
        return contatoService.create(contato);
    }

    @GetMapping
    public List<ContatoDTO> list(){
        log.info("list contatoController");
        return contatoService.list();
    }


    @PutMapping("/{id}")
    public ContatoDTO update (@PathVariable("id") Integer id,@RequestBody ContatoCreateDTO contato) throws RegraDeNegocioException {
        log.info("update contatoController");
        return contatoService.update(id, contato);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable("id")Integer id) throws RegraDeNegocioException{
        log.info("delete contatoController");
        contatoService.delete(id);
    }

    @GetMapping("/{id}")
    public List<ContatoDTO> listContactsPerson (@PathVariable("id") Integer idPessoa){
        log.info("list contatoController");
        return contatoService.listContactsPerson(idPessoa);
    }

    @GetMapping("/tipo")
    public List<ContatoDTO> findByType (@RequestParam("tipo") String tipo){
        log.info("findByType contatoController");
        return contatoService.findByType(tipo);
    }

}
