package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.EnderecoCreateDTO;
import com.dbc.pessoaapi.dto.EnderecoDTO;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public void delete(Integer id) throws Exception {
        enderecoRepository.deleteById(id);
    }

    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO endereco) throws Exception {
        PessoaEntity pessoaEntity = pessoaRepository.findAll().stream()
                        .filter(x -> x.getIdPessoa().equals(idPessoa))
                                .findFirst().orElseThrow(() -> new Exception("Pessoa não encontrada"));
        EnderecoEntity enderecoEntity = objectMapper.convertValue(endereco, EnderecoEntity.class);
        enderecoRepository.save(enderecoEntity);
        return objectMapper.convertValue(endereco, EnderecoDTO.class);
    }

    public EnderecoDTO update(Integer id, EnderecoEntity enderecoAtualizar) throws Exception {
        EnderecoEntity enderecoEcontrado = enderecoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Endereco não encontrado"));
        enderecoEcontrado.setCep(enderecoAtualizar.getCep());
        enderecoEcontrado.setCidade(enderecoAtualizar.getCidade());
        enderecoEcontrado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoEcontrado.setEstado(enderecoAtualizar.getEstado());
        enderecoEcontrado.setPais(enderecoAtualizar.getPais());
        enderecoEcontrado.setTipoEndereco(enderecoAtualizar.getTipoEndereco());
        enderecoRepository.save(enderecoEcontrado);
        return objectMapper.convertValue(enderecoEcontrado, EnderecoDTO.class);
    }


    public List<EnderecoDTO> list() {
        return enderecoRepository.findAll()
                .stream()
                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

//    public List<EnderecoDTO> listEnderecoByIdPessoa(Integer idPessoa) {
//        List<EnderecoEntity> enderecos = enderecoRepository.findAll()
//                .stream()
//                .filter(e -> e.getIdPessoa().equals(idPessoa))
//                .collect(Collectors.toList());
//        return enderecos.stream().map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class)).collect(Collectors.toList());
//    }

    public List<EnderecoDTO> encontrarPorId(Integer idEndereco) throws Exception {
        return enderecoRepository.findEnderecoPorIdPessoa(idEndereco).stream().map(
                enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                .collect(Collectors.toList());
    }


    public List<EnderecoDTO> enderecosSemComplemento(){
       return enderecoRepository.findEnderecosSemComplemento()
               .stream().map( enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
               .collect(Collectors.toList());
    }
}
