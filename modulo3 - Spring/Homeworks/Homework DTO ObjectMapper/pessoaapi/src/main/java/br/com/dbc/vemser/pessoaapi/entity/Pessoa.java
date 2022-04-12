package br.com.dbc.vemser.pessoaapi.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    private Integer idPessoa;

    @NotBlank
    private String nome;

    @NotNull
    private LocalDate dataNascimento;

    @CPF(message = "CPF Inválido")
    private String cpf;
}
