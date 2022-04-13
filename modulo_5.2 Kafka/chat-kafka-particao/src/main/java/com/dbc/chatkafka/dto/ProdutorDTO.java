package com.dbc.chatkafka.dto;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutorDTO {

    private String usuario;
    private String mensagem;
    private LocalDateTime dataCriacao;

}


