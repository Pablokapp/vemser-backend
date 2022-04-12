package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    EmailService emailService;

    @Autowired
    PessoaService pessoaService;

    @Autowired
    private ObjectMapper objectMapper;

    public EnderecoDTO create (EnderecoCreateDTO endereco, Integer id) throws RegraDeNegocioException, TemplateException, IOException {
        log.info("enderecoService create");
//        validatePersonExists(id);
        PessoaDTO pessoaDTO = pessoaService.findById(id);
        emailService.sendEmailService(pessoaDTO, "Novo endereço adicionado");
        Endereco enderecoSemId = objectMapper.convertValue(endereco, Endereco.class);
        Endereco enderecoComId = enderecoRepository.create(enderecoSemId, id);
        return objectMapper.convertValue(enderecoComId, EnderecoDTO.class);
    }

    public List<EnderecoDTO> list(){
        log.info("list EnderecoService");
        return convertListDTO(enderecoRepository.list());
    }

    public EnderecoDTO findById (Integer id) throws RegraDeNegocioException{
        log.info("findById EnderecoService");
            return objectMapper.convertValue(enderecoRepository.findById(id), EnderecoDTO.class);
    }

    public List<EnderecoDTO> findByPerson (Integer idPessoa){
        log.info("findByPerson EnderecoService");
        return convertListDTO(enderecoRepository.findByPerson(idPessoa));
    }

    public EnderecoDTO update (Integer id, EnderecoCreateDTO endereco) throws RegraDeNegocioException, TemplateException, IOException {
        log.info("update EnderecoService");
        validatePersonExists(endereco.getIdPessoa());
        Endereco enderecoNovo = objectMapper.convertValue(endereco, Endereco.class);
        Endereco enderecoAtualizado = enderecoRepository.update(id,enderecoNovo);
        PessoaDTO pessoaDTO = pessoaService.findById(id);
        emailService.sendEmailService(pessoaDTO, "Endereço atualizado");
        return objectMapper.convertValue(enderecoAtualizado, EnderecoDTO.class);
    }

    public void delete (Integer id) throws RegraDeNegocioException, TemplateException, IOException {
        log.info("Delete EnderecoService");
        PessoaDTO pessoaDTO = pessoaService.findById(id);
        emailService.sendEmailService(pessoaDTO, "Endereço excluido");
        enderecoRepository.delete(id);
    }


    public void validatePersonExists (Integer idPessoa) throws RegraDeNegocioException {
        log.info("validatePersonExists EnderecoService");
        enderecoRepository.list().stream()
                .filter(e -> e.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(()-> new RegraDeNegocioException("Pessoa não existe!"));
    }

    private List<EnderecoDTO> convertListDTO (List<Endereco> enderecos){
        return enderecos.stream()
                .map(end -> objectMapper.convertValue(end, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

}
