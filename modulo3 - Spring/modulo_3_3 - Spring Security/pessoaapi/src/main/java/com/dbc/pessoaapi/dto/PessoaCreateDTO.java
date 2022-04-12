package com.dbc.pessoaapi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class PessoaCreateDTO {
    @NotEmpty
    @NotBlank
    @ApiModelProperty(value = "Nome da Pessoa")
    private String nome;

    @NotNull
    @ApiModelProperty(value = "Data de Nascimento")
    private LocalDate dataNascimento;

    @Size(max = 11, min = 11, message = "cpf deve conter 11 caracteres")
    @NotNull
    @ApiModelProperty(value = "CPF")
    private String cpf;


    private String email;

}