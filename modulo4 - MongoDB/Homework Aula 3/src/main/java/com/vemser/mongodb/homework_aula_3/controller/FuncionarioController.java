package com.vemser.mongodb.homework_aula_3.controller;

import com.vemser.mongodb.homework_aula_3.model.Funcionario;
import com.vemser.mongodb.homework_aula_3.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;


    @GetMapping
    public List<Funcionario> obterTodos() {
        return this.funcionarioService.obterTodos();
    }

    @GetMapping("/{codigo}")
    public Funcionario obterPorCodigo(@PathVariable String codigo) {
        return this.funcionarioService.obterPorCodigo(codigo);
    }

    @PostMapping
    public Funcionario criar(@RequestBody Funcionario funcionario) {
        return this.funcionarioService.criar(funcionario);
    }

    @PutMapping
    public Funcionario atualizar(@RequestBody Funcionario funcionario) {
        return this.funcionarioService.atualizar(funcionario);
    }

    @DeleteMapping("/{codigo}")
    public void remover(@PathVariable String codigo) {
        this.funcionarioService.remover(codigo);
    }
}




