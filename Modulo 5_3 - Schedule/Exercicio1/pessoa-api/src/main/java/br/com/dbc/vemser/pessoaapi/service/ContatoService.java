package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.contato.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.contato.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
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
    private ObjectMapper objectMapper;

//    public ContatoService () {
//        contatoRepository = new ContatoRepository();
//    }

    public ContatoDTO create (ContatoCreateDTO contato) {
        return objectMapper.convertValue(contatoRepository.create(objectMapper.convertValue(contato, Contato.class)), ContatoDTO.class);
    }

    public List<ContatoDTO> list() {
        return contatoRepository.list().stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public ContatoDTO update (Integer id, ContatoCreateDTO contato) throws Exception {
        return objectMapper.convertValue(contatoRepository.update(id, objectMapper.convertValue(contato, Contato.class)), ContatoDTO.class);
    }

    public ContatoDTO delete (Integer id) throws Exception {
        return objectMapper.convertValue(contatoRepository.delete(id), ContatoDTO.class);
    }

    public List<ContatoDTO> listByPessoaId(Integer id) {
        return contatoRepository.listByPessoaId(id).stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }

}
