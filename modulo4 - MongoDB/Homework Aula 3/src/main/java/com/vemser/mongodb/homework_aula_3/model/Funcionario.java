package com.vemser.mongodb.homework_aula_3.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
@Data

public class Funcionario {

    @Id
    private String codigo;
    private String nome;
    private Integer idade;
    private BigDecimal salario;
    private String cargo;
}
