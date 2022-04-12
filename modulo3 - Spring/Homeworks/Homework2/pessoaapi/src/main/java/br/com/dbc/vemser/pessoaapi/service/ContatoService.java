package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log
public class ContatoService {

    private ContatoRepository contatoRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    public ContatoService(ContatoRepository contatoRepository){

        this.contatoRepository = contatoRepository;
//        contatoRepository = new ContatoRepository();
    }

    public ContatoDTO create(ContatoCreateDTO contato) throws RegraDeNegocioException{
        log.info("ContatoService create");
        Contato contatoSemId = objectMapper.convertValue(contato, Contato.class);
        validatePersonExists(contatoSemId);
        Contato contatoComId = contatoRepository.create(contatoSemId);
        return objectMapper.convertValue(contatoComId, ContatoDTO.class);
    }

    public List<ContatoDTO> list(){
        log.info("list ContatoService");
        return convertListDTO(contatoRepository.list());
    }

    public ContatoDTO update(Integer id, ContatoCreateDTO contatoAtualizar) throws RegraDeNegocioException{
        log.info("ContatoService update");
        Contato contatoNovoDado = objectMapper.convertValue(contatoAtualizar, Contato.class);
        validatePersonExists(contatoNovoDado);
        Contato contatoAtualizado = contatoRepository.update(id, contatoNovoDado);
        return objectMapper.convertValue(contatoAtualizado, ContatoDTO.class);
    }


    public void delete (Integer id) throws RegraDeNegocioException{
        log.info("delete ContatoService");
            contatoRepository.delete(id);
    }

    public List<ContatoDTO> listContactsPerson(Integer id){
        log.info("listContactsPerson ContatoService");
        return convertListDTO(contatoRepository.listarContatosPessoa(id));
    }

    public List<ContatoDTO> findByType (String tipo){
        log.info("findByType ContatoService");
        return convertListDTO(contatoRepository.findByType(tipo));
    }


    public void validatePersonExists (Contato contato) throws RegraDeNegocioException {
        log.info("validatePersonExists ContatoService");
        contatoRepository.list().stream()
                .filter(c -> c.getIdPessoa().equals(contato.getIdPessoa()))
                .findFirst()
                .orElseThrow(()-> new RegraDeNegocioException("Pessoa não existe!"));
    }

    private List<ContatoDTO> convertListDTO(List<Contato> contatos){
        return  contatos
                .stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .collect(Collectors.toList());
    }
}
