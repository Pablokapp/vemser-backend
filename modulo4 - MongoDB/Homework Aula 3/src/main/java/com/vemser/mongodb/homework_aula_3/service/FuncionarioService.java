package com.vemser.mongodb.homework_aula_3.service;

import com.vemser.mongodb.homework_aula_3.model.Funcionario;
import com.vemser.mongodb.homework_aula_3.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;


    public List<Funcionario> obterTodos() {
        return this.funcionarioRepository.findAll();
    }


    public Funcionario obterPorCodigo(String codigo) {
        return this.funcionarioRepository
                .findById(codigo)
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado"));
    }

    public Funcionario criar(Funcionario funcionario) {
        return this.funcionarioRepository.save(funcionario);
    }


    public void remover(String codigo) {
        this.funcionarioRepository.deleteById(codigo);
    }

    public Funcionario atualizar(Funcionario funcionario) {
        return this.funcionarioRepository.save(funcionario);
    }
}

