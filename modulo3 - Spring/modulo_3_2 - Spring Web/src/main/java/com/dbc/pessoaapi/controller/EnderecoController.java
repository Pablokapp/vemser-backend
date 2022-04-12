package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.EnderecoCreateDTO;
import com.dbc.pessoaapi.dto.EnderecoDTO;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.dbc.pessoaapi.service.EnderecoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private EnderecoRepository enderecoRepository;


    @ApiOperation(value = "Apaga um endereço")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Apaga um endereço"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        enderecoService.delete(id);
    }

    @ApiOperation(value = "Cria um endereço")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cria um endereço"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping("/{idPessoa}")
    public EnderecoDTO create(@PathVariable("idPessoa") Integer idPessoa,
                              @RequestBody EnderecoCreateDTO endereco) throws Exception {
        return enderecoService.create(idPessoa, endereco);
    }

    @ApiOperation(value = "Atualiza um endereço")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Atualiza um endereço"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PutMapping("/{id}")
    public EnderecoDTO update(@PathVariable("id") Integer id,
                                 @RequestBody EnderecoEntity endereco) throws Exception {
        return enderecoService.update(id, endereco);
    }

    @ApiOperation(value = "Retorna lista de endereços")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna lista de endereços"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/listar")
    public List<EnderecoDTO> list() {
        return enderecoService.list();
    }

//    @GetMapping("/{idPessoa}/pessoa")
//    public List<EnderecoDTO> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
//        return enderecoService.listEnderecoByIdPessoa(idPessoa);
//    }

    @ApiOperation(value = "Encontra um endereço por id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Encontra um endereço por id"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/{idEndereco}")
    public List<EnderecoDTO> findById(@PathVariable("idEndereco") Integer id) throws Exception {
        return enderecoService.encontrarPorId(id);
    }

    @GetMapping("/endereco-por-pais")
    public List<EnderecoEntity> enderecoPorPais(@RequestParam("pais") String pais){
        return enderecoRepository.findEnderecoPorPais(pais);
    }

    @GetMapping("/endereco-por-id-pessoa")
    public List<EnderecoDTO> enderecoPorIdPessoa(@RequestParam("idPessoa") Integer idPessoa) throws Exception {
        return enderecoService.encontrarPorId(idPessoa);
    }


    @GetMapping("/endereco-sem-complemento")
    public List<EnderecoDTO> enderecoSemComplemento(){
        return enderecoService.enderecosSemComplemento();
    }

public List<EnderecoEntity> enderecoPorCidade(@RequestParam("cidade") String cidade){
        return enderecoRepository.findEnderecoPorCidade(cidade);
}


}
