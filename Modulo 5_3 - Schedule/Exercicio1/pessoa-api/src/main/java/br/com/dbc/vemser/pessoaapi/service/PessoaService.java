package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.pessoa.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.pessoa.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PessoaService pessoaService;

//    public PessoaService(){
//        pessoaRepository = new PessoaRepository();
//    }

    public PessoaDTO create(PessoaCreateDTO pessoaCreateDTO){

        Pessoa p = objectMapper.convertValue(pessoaCreateDTO, Pessoa.class);
        p = pessoaRepository.create(p);
        if (p != null){
            emailService.sendEmail(objectMapper.convertValue(p, PessoaDTO.class), "Novo Cadastro","email-template-cria-pessoa.ftl");
        }
        return objectMapper.convertValue(p, PessoaDTO.class);
    }

    public List<PessoaDTO> list(){
        return pessoaRepository.list().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizar) throws Exception {
        Pessoa p = pessoaRepository.update(id, objectMapper.convertValue(pessoaAtualizar, Pessoa.class));
        return objectMapper.convertValue(p, PessoaDTO.class);
    }

    public PessoaDTO delete(Integer id) throws Exception {
        return objectMapper.convertValue(pessoaRepository.delete(id), PessoaDTO.class);
    }

    public List<PessoaDTO> listByName(String nome) {
        return pessoaRepository.listByName(nome).stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO getPessoaById (Integer id) throws Exception {
       return pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .orElseThrow(() -> new RegraDeNegocioException("Pessa nao encontrada"));
    }

    //===========================================//
    // Exercicio 1
    @Scheduled(cron = "0 0 8,20 * * *")
    public void envioDeEmailParaQuemNaoPossuiEndereco(){

        pessoaService.list().stream().forEach(
                pessoa -> {
                    if (pessoa.getEndereco() == null) {
                        emailService.sendSimpleMessage(pessoa);
                        log.info("Enviando email para " + pessoa.getNome());
                    }
                }
        );
    }
//===========================================//

    // Exercicio 2
    @Scheduled(cron = "0 0 0 1 * *")
    public void envioDeEmailUmaVezAoMes(){
        pessoaRepository.list()
                .stream()
                .forEach(pessoa -> {
                    PessoaDTO pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTO.class);
                    emailService.sendSimpleMessageTodos(pessoaDTO);
                });
    }

    //================================ //

// Homework - Pessoa API
    @Scheduled(cron = "0 0 8 * * *")
    public void envioDeEmailAosAniversariantes() {
        LocalDate dataAtual = LocalDate.now();
        pessoaRepository.list().stream()
                .forEach(pessoa -> {
                        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTO.class);
                        Integer anoNascimento = pessoaDTO.getDataNascimento().getYear();
                        Integer anoAtual = dataAtual.getYear();
                        Integer idade = anoAtual - anoNascimento;
                        emailService.sendSimpleMessageAniversariante(pessoaDTO, idade);
                });
    }
    //================================ //

}

