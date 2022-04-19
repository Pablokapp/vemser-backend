package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.*;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private EmailService emailService;

    @Autowired
    private ObjectMapper objectMapper;

    public PessoaDTO create(PessoaCreateDTO pessoa) throws Exception {
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoa, PessoaEntity.class);
        pessoaRepository.save(pessoaEntity);
        emailService.sendEmail();
        return objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
    }

    public List<PessoaDTO> list() {
        return pessoaRepository.findAll()
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO update(Integer id,
                            PessoaCreateDTO pessoaAtualizar) throws Exception {
        PessoaEntity pessoaEncontrada = pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada! "));
        pessoaEncontrada.setCpf(pessoaAtualizar.getCpf());
        pessoaEncontrada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        pessoaEncontrada.setEmail(pessoaAtualizar.getEmail());
        pessoaEncontrada.setNome(pessoaAtualizar.getNome());
        PessoaEntity update = pessoaRepository.save(pessoaEncontrada);
        PessoaDTO pessoaDTO = objectMapper.convertValue(update, PessoaDTO.class);
        return pessoaDTO;

    }


    public void delete(Integer id) throws Exception {
        pessoaRepository.deleteById(id);
    }

    public List<PessoaDTO> listByName(String nome) {
        return pessoaRepository.findByNomeContainingIgnoreCase(nome).stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public List<PessoaDTO> listByCpf(String cpf) {
        return pessoaRepository.findByCpf(cpf).stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public List<PessoaDTO> listByNameContainingIgnoreCase(String nome) {
        return pessoaRepository.findByNomeContainingIgnoreCase(nome).stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public List<PessoaDTO> findByDataNascimento(LocalDate dataNascimentoInicial, LocalDate dataNascimentoFinal) {
        return (pessoaRepository.findByDataNascimentoBetween(dataNascimentoInicial, dataNascimentoFinal)).stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public List<PessoaDTOComContatos> listarComContatos(Integer idPessoa) throws RegraDeNegocioException {
        List<PessoaDTOComContatos> pessoaDTOList = new ArrayList<>();
        if (idPessoa == null) {
            pessoaDTOList.addAll(pessoaRepository.findAll().stream()
                    .map(pessoa -> {
                        PessoaDTOComContatos pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTOComContatos.class);
                        pessoaDTO.setContatos(pessoa.getContatos().stream()
                                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                                .collect(Collectors.toList())
                        );
                        return pessoaDTO;
                    }).collect(Collectors.toList())
            );
        } else {
            PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa)
                    .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada "));
            PessoaDTOComContatos pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTOComContatos.class);
            pessoaDTO.setContatos(pessoaEntity.getContatos().stream()
                    .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                    .collect(Collectors.toList())
            );
            pessoaDTOList.add(pessoaDTO);
        }
        return pessoaDTOList;
    }

    public List<PessoaDTOComEnderecos> listarComEnderecos(Integer idPessoa) {
        List<PessoaDTOComEnderecos> pessoaDTOList = new ArrayList<>();
        if (idPessoa != null) {
            pessoaDTOList.addAll(pessoaRepository.findById(idPessoa).stream()
                    .map(pessoa -> {
                        PessoaDTOComEnderecos pessoaDTOComEnderecos = objectMapper.convertValue(pessoa, PessoaDTOComEnderecos.class);
                        pessoaDTOComEnderecos.setEnderecos(pessoa.getEnderecos().stream()
                                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                                .collect(Collectors.toList()));
                        return pessoaDTOComEnderecos;
                    }).collect(Collectors.toList()));
        } else {

            pessoaDTOList.addAll(pessoaRepository.findAll().stream().map(pessoa -> {

                        PessoaDTOComEnderecos pessoaDTOComEnderecos = objectMapper.convertValue(pessoa, PessoaDTOComEnderecos.class);
                        pessoaDTOComEnderecos.setEnderecos(pessoa.getEnderecos().stream()
                                .map(enderecoComId -> objectMapper.convertValue(enderecoComId, EnderecoDTO.class))
                                .collect(Collectors.toList()));
                        pessoaDTOList.add(pessoaDTOComEnderecos);
                        return pessoaDTOComEnderecos;
                    }
            ).collect(Collectors.toList()));
        }

        return pessoaDTOList;
    }


    public List<PessoaDTOCompleto> listaPessoas(Integer idPessoa) throws RegraDeNegocioException {
        List<PessoaDTOCompleto> pessoaDTOCompleto = new ArrayList<>();
        if (idPessoa == null) {
            pessoaDTOCompleto.addAll(pessoaRepository.findAll().stream()
                    .map(pessoa -> {
                        PessoaDTOCompleto pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTOCompleto.class);
                        pessoaDTO.setContatos(pessoa.getContatos().stream()
                                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                                .collect(Collectors.toList()));
                        pessoaDTO.setEnderecos(pessoa.getEnderecos().stream()
                                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                                .collect(Collectors.toList()));
                        return pessoaDTO;
                    }).collect(Collectors.toList())
            );

        } else {
            PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa)
                    .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada "));
            PessoaDTOCompleto pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTOCompleto.class);
            pessoaDTO.setContatos(pessoaEntity.getContatos().stream()
                    .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                    .collect(Collectors.toList()));
            pessoaDTO.setEnderecos(pessoaEntity.getEnderecos().stream()
                    .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                    .collect(Collectors.toList())
            );
            pessoaDTOCompleto.add(pessoaDTO);
        }
        return pessoaDTOCompleto;
    }
}







