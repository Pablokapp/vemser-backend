package com.dbc.pessoaapi.dto;

import com.dbc.pessoaapi.entity.TipoEndereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnderecoCreateDTO {


    @NotNull
    private TipoEndereco tipoEndereco;
    @NotEmpty
    @Size(max = 250)
    private String logradouro;
    @NotNull
    private Integer numero;
    @NotNull
    @NotEmpty
    @Size( max = 8)
    private String cep;

    @NotNull
    @NotEmpty
    @Size( max = 250)
    private String cidade;
    @NotNull
    private String estado;
    @NotNull
    private String pais;
}
