package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import lombok.extern.java.Log;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log
public class PessoaService {


    private final PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
//        pessoaRepository = new PessoaRepository();
    }

    public PessoaDTO create(PessoaCreateDTO pessoaCreate){
        Pessoa pessoa = objectMapper.convertValue(pessoaCreate, Pessoa.class);
        Pessoa pessoaCriada = pessoaRepository.create(pessoa);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaCriada, PessoaDTO.class);

        log.info("create pessoaService");
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
        return pessoaDTO;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        log.info("delete pessoaService");
        pessoaRepository.delete(id);
    }

    public List<PessoaDTO> listByName(String nome) {
        log.info("listByName pessoaService");
        return conversorListaPessoaParaPessoaDTO(pessoaRepository.listByName(nome));
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

}


