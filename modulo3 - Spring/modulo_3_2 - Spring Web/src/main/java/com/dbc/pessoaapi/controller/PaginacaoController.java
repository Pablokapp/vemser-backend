package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/paginacao")
@RequiredArgsConstructor
public class PaginacaoController {


    private final PessoaRepository pessoaRepository;
    private final ContatoRepository contatoRepository;
    private final EnderecoRepository enderecoRepository;

    @GetMapping("/find-all-paginado")
    public Page<PessoaEntity> findAllPaginado(Integer paginaSolicitada, Integer tamanhoDaPagina){
        Pageable pageable = PageRequest.of(paginaSolicitada, tamanhoDaPagina);
        Page<PessoaEntity> all = pessoaRepository.findAll(pageable);
        return all;
    }

    @GetMapping("/find-by-name-paginado")
    public Page<PessoaEntity> findByNamePaginado(Integer paginaSolicitada, Integer tamanhoDaPagina, String nome){
        Pageable pageable = PageRequest.of(paginaSolicitada, tamanhoDaPagina);
        Page<PessoaEntity> all = pessoaRepository.findByNamePaged(nome.toUpperCase(Locale.ROOT), pageable);
        return all;
    }


    @GetMapping("/contatos-por-descricao")
    public Page<ContatoEntity> contatosPorDescricao (Integer paginaSolicitada, Integer tamanhoDaPagina){
        Pageable pageable = PageRequest.of(paginaSolicitada, tamanhoDaPagina);
        Page<ContatoEntity> all = contatoRepository.contatoPorDescricao(pageable);
        return all;
    }


    @GetMapping("/endereco-por-cep")
    public Page<EnderecoEntity> enderecoPorCep(Integer paginaSolicitada, Integer tamanhoDaPagina){
        Pageable pageable = PageRequest.of(paginaSolicitada, tamanhoDaPagina, Sort.by("cep").ascending());
        Page <EnderecoEntity> all = enderecoRepository.enderecoPorCep(pageable);
        return all;
    }

    @GetMapping("/endereco-por-pais")
    public Page<EnderecoEntity> enderecoPorPais(Integer paginaSolicitada, Integer tamanhoDaPagina, String pais){
        Pageable pageable = PageRequest.of(paginaSolicitada, tamanhoDaPagina, Sort.by("pais"));
        Page <EnderecoEntity> all = enderecoRepository.enderecoPorPais(pageable, pais);
        return all;
    }




}
