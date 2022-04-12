package com.dbc.veiculoprodutorconsumidor.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "registros")
@Getter
@Setter
public class Registro {

    @Id
    private String id;

    private LocalDateTime dataLeitura;
    private Double velocidade;
    private Integer rotacao;
    private boolean sensorFrenagem;



}
