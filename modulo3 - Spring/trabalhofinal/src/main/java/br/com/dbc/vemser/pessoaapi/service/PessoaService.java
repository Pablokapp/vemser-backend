package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import lombok.extern.java.Log;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log
public class PessoaService {


    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;


    @Autowired
    EmailService emailService;
//
    @Autowired
    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;

    }

    public PessoaDTO create(PessoaCreateDTO pessoaCreate) throws TemplateException, IOException {
        log.info("create pessoaService");
        Pessoa pessoa = objectMapper.convertValue(pessoaCreate, Pessoa.class);
        Pessoa pessoaCriada = pessoaRepository.create(pessoa);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaCriada, PessoaDTO.class);
        sendEmail(pessoaDTO, "Estamos felizes em ter você em nosso sistema :)\n" +
                "Seu cadastro foi realizado com sucesso, seu identificador é ${id}.\n" +
                "\n" +
                "Qualquer dúvida é só contatar o suporte pelo e-mail ${spring.mail.username}.");
        emailService.sendEmail(pessoaDTO, "Estamos felizes em ter você em nosso sistema :)\n" +
                "Seu cadastro foi realizado com sucesso, seu identificador é ${id}.\n" +
                "\n" +
                "Qualquer dúvida é só contatar o suporte pelo e-mail ${spring.mail.username}.");
        return pessoaDTO;
    }

    public List<PessoaDTO> list(){
        log.info("listar PessoService");
        return pessoaRepository.list()
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id,
                            PessoaCreateDTO pessoaAtualizar) throws Exception {

        Pessoa pessoa = objectMapper.convertValue(pessoaAtualizar, Pessoa.class);
        Pessoa pessoaAtualizada = pessoaRepository.update(id, pessoa);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaAtualizada, PessoaDTO.class);
        log.info("update pessoaService");
        emailService.sendEmail(pessoaDTO, "Estamos felizes em ter você em nosso sistema :)\n" +
                "Seu cadastro foi atualizado com sucesso, seu identificador é ${id}.\n" +
                "\n" +
                "Qualquer dúvida é só contatar o suporte pelo e-mail ${spring.mail.username}.");
        return pessoaDTO;
    }

    public void delete(Integer id) throws RegraDeNegocioException, TemplateException, IOException {
        log.info("delete pessoaService");
        PessoaDTO pessoaDTO = findById(id)  ;
        emailService.sendEmail(pessoaDTO, "Você perdeu o acesso ao nosso sistema.\n" +
                "Cadastro Removido com sucesso, identificador ${id}.\n" +
                "\n" +
                "Qualquer dúvida é só contatar o suporte pelo e-mail ${spring.mail.username}.");

        pessoaRepository.delete(id);
    }

    public List<PessoaDTO> listByName(String nome) {
        log.info("listByName pessoaService");
        return conversorListaPessoaParaPessoaDTO(pessoaRepository.listByName(nome));
    }

    public PessoaDTO findById(Integer id) throws RegraDeNegocioException {
        Pessoa p = pessoaRepository.findById(id);
        PessoaDTO pessoaDTO = objectMapper.convertValue(p, PessoaDTO.class);
        return pessoaDTO;

    }

private List<PessoaDTO> conversorListaPessoaParaPessoaDTO(List<Pessoa> pessoas){
        return pessoas.stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
}

    private boolean validatePerson (Pessoa pessoa){
        boolean name = StringUtils.isBlank(pessoa.getNome());
        boolean data = ObjectUtils.isEmpty(pessoa.getDataNascimento());
        boolean cpf = StringUtils.isBlank(pessoa.getCpf());
        return name || data || cpf;
    }

    public void sendEmail(PessoaDTO pessoaDTO, String mensagem) throws TemplateException, IOException {
            emailService.sendEmailService(pessoaDTO, mensagem);
    }

}


