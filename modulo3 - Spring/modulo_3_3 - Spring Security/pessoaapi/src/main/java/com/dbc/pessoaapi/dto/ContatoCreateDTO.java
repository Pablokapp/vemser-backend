package com.dbc.pessoaapi.dto;

import com.dbc.pessoaapi.entity.TipoContato;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContatoCreateDTO {

//    private Integer idPessoa;

    @NotNull
    private TipoContato tipoContato;

    @NotNull
    @NotEmpty
    @Size(max = 13)
    private String numero;

    @NotNull
    @NotEmpty
    private String descricao;
}
