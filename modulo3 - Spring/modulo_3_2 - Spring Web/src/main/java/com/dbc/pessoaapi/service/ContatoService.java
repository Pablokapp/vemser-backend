package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public void delete(Integer id) throws Exception {
        contatoRepository.deleteById(id);
    }

    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contato) throws Exception {
        ContatoEntity contatoEntity = objectMapper.convertValue(contato, ContatoEntity.class);
        contatoEntity.setIdPessoa(idPessoa);
        contatoRepository.save(contatoEntity);
        return objectMapper.convertValue(contato, ContatoDTO.class);
    }

    public ContatoDTO update(Integer id, ContatoCreateDTO contatoAtualizar) throws Exception {

        ContatoEntity contatoEcontrado = contatoRepository.findById(id)
                .orElseThrow(()->new RegraDeNegocioException("Contato não encontrado! "));
        contatoEcontrado.setTipoContato(contatoAtualizar.getTipoContato());
        contatoEcontrado.setDescricao(contatoAtualizar.getDescricao());
        contatoEcontrado.setNumero(contatoAtualizar.getNumero());
        contatoRepository.save(contatoEcontrado);
        return objectMapper.convertValue(contatoEcontrado, ContatoDTO.class);
    }


    public List<ContatoDTO> list() {
        return contatoRepository.findAll()
                .stream()
                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public List<ContatoDTO> listContatoByIdPessoa(Integer idPessoa) {
        List<ContatoEntity> contatos = contatoRepository.findAll().stream()
                .filter(c -> c.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
        return contatos.stream().map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class)).collect(Collectors.toList());
    }

    public List<ContatoEntity> findById(Integer idPessoa) {
        return contatoRepository.findContatoPorId(idPessoa);
    }




    public ContatoDTO encontrarContatoPorId(Integer idContato) throws Exception {
        return objectMapper.convertValue((contatoRepository.findById(idContato)), ContatoDTO.class);
    }
}
