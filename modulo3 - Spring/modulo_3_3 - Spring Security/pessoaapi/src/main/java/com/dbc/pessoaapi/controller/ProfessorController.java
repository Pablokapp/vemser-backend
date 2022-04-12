package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.ProfessorEntity;
import com.dbc.pessoaapi.entity.pk.ProfessorPK;
import com.dbc.pessoaapi.repository.ProfessorRepository;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
@RequiredArgsConstructor
public class ProfessorController {
    private final ProfessorRepository professorRepository;

    @PostMapping
    public ProfessorEntity save(@RequestBody ProfessorEntity professorEntity){
        return professorRepository.save(professorEntity);
    }

    @GetMapping
    public List<ProfessorEntity> list() {
        return professorRepository.findAll();
    }



}
