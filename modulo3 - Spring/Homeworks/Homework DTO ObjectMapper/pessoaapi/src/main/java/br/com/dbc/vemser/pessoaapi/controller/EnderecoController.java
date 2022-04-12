package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
@Log
public class EnderecoController {


    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/")
    public List<EnderecoDTO> getEnderecos (){
        log.info("getEnderecos EnderecoController");
        return enderecoService.list();
    }

    @GetMapping("/{id}")
    public EnderecoDTO findById (@PathVariable("id") Integer idEndereco)throws RegraDeNegocioException {
        log.info("findById EnderecoController");
        return enderecoService.findById(idEndereco);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<EnderecoDTO> findByPerson (@PathVariable("idPessoa")Integer idPessoa){
        log.info("findByPerson EnderecoController");
        return enderecoService.findByPerson(idPessoa);
    }

    @PostMapping("/{idPessoa}")
    public EnderecoDTO create (@PathVariable("idPessoa") Integer idPessoa,@RequestBody EnderecoCreateDTO endereco)throws RegraDeNegocioException{
        log.info("create EnderecoController");
        return enderecoService.create(endereco,idPessoa);
    }

    @PutMapping("/{id}")
    public EnderecoDTO update (@PathVariable ("id")Integer id,@RequestBody EnderecoCreateDTO endereco)throws RegraDeNegocioException{
        log.info("update EnderecoController");
        return enderecoService.update(id, endereco);
    }

    @DeleteMapping("/{id}")
    public void delete ( @PathVariable("id")Integer id)throws RegraDeNegocioException{
        log.info("delete EnderecoController");
        enderecoService.delete(id);
    }

}
