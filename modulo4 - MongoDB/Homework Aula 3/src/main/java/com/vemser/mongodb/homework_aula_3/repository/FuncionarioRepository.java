package com.vemser.mongodb.homework_aula_3.repository;

import com.vemser.mongodb.homework_aula_3.model.Funcionario;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FuncionarioRepository extends MongoRepository<Funcionario, String> {
}

