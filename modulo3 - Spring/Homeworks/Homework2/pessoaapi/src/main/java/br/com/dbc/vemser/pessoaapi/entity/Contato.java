package br.com.dbc.vemser.pessoaapi.entity;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contato {
    private Integer idContato;
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
