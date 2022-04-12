package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaCreateDTO {

    @ApiModelProperty(value = "Nome da pessoa")
    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    @Past
    private LocalDate dataNascimento;

    @CPF
    private String cpf;

    @Email
    private String email;
}
