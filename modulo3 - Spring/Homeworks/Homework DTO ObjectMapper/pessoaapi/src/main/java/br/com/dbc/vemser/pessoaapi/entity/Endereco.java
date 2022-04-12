package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Endereco {

    private Integer idEndereco;
    private Integer idPessoa;

    @NotNull
    private String tipoEndereco;

    @NotEmpty
    @Size(max = 250)
    private String logradouro;

    @NotNull
    private Integer numero;

    @NotNull
    @NotEmpty
    @Size(max = 8)
    private String cep;

    private String bairro;

    @NotNull
    @NotEmpty
    @Size(max = 250)
    private String cidade;

    @NotNull
    private String estado;

    @NotNull
    private String pais;

}
