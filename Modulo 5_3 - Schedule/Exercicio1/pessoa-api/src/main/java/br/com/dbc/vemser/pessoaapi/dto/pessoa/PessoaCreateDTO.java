package br.com.dbc.vemser.pessoaapi.dto.pessoa;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PessoaCreateDTO {

    @ApiModelProperty(value = "Nome da Pessoa")
    @NotEmpty
    private String nome;
    @ApiModelProperty(value = "Data de nascimento da Pessoa")
    @Past
    private LocalDate dataNascimento;
    @ApiModelProperty(value = "Email da Pessoa")
    @Email
    private String email;
    @ApiModelProperty(value = "CPF da Pessoa")
    @CPF
    private String cpf;

    private Endereco endereco;
}
