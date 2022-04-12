package br.com.dbc.vemser.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContatoCreateDTO {
    private Integer idPessoa;

    @NotNull
    private String tipoContato;

    @NotNull
    @NotEmpty
    @Size(max = 13)
    private String numero;

    @NotNull
    @NotEmpty
    private String descricao;
}
