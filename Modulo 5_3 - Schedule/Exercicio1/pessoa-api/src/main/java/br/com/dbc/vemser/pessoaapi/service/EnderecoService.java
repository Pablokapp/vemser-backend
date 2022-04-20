package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.endereco.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.endereco.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
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
    private PessoaService pessoaService;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private EmailService emailService;

    public List<EnderecoDTO> list() {
        return enderecoRepository.list().stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO getById(Integer id) throws Exception {
        return objectMapper.convertValue(list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereco não encontrado.")), EnderecoDTO.class);
    }

    public List<EnderecoDTO> getByPessoa(Integer id) throws Exception {
        return list().stream()
                .filter(e -> e.getIdPessoa().equals(id))
                .map(e -> objectMapper.convertValue(e, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO create(Integer id, EnderecoCreateDTO endereco) throws Exception {
        endereco.setIdPessoa(id);
        Endereco e = enderecoRepository.create(objectMapper.convertValue(endereco, Endereco.class));
        if (e != null){
            emailService.sendEmail(pessoaService.getPessoaById(id), "Novo endereco adicionado!", "email-template-cria-endereco.ftl");
        }
        return objectMapper.convertValue(e, EnderecoDTO.class);
    }

    public EnderecoDTO update(Integer id, EnderecoCreateDTO endereco) throws Exception {
        Endereco e = enderecoRepository.update(id, objectMapper.convertValue(endereco, Endereco.class));
        if (e != null){
            emailService.sendEmail(pessoaService.getPessoaById(endereco.getIdPessoa()), "Endereco atualizado!", "email-template-atualiza-endereco.ftl");
        }
        return objectMapper.convertValue(e, EnderecoDTO.class);
    }

    public EnderecoDTO delete(Integer id) throws Exception {
        Endereco e = enderecoRepository.delete(id);
        if (e != null){
            emailService.sendEmail(pessoaService.getPessoaById(e.getIdPessoa()), "Endereco Removido!", "email-template-remove-endereco.ftl");
        }
        return objectMapper.convertValue(e, EnderecoDTO.class);    }

}
