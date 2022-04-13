package com.dbc.veiculoprodutorconsumidor.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroCreateDTO {


    private Double velocidade;
    private Integer rotacao;
    private boolean sensorFrenagem;
}