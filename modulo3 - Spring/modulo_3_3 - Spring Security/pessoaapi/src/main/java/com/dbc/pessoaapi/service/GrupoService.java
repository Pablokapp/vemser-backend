package com.dbc.pessoaapi.service;


import com.dbc.pessoaapi.entity.GrupoEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.GrupoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GrupoService {

    private final GrupoRepository groupRepository;

    public GrupoEntity getById(Integer id) throws RegraDeNegocioException {
        return groupRepository.findById(id).orElseThrow(() -> new RegraDeNegocioException("Grupo não encontrado"));
    }
}