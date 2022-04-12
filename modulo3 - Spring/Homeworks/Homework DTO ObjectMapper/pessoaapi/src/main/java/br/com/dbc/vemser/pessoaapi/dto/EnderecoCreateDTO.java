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
public class EnderecoCreateDTO {
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
    @Size( max = 8)
    private String cep;
    private String bairro;
    @NotNull
    @NotEmpty
    @Size( max = 250)
    private String cidade;
    @NotNull
    private String estado;
    @NotNull
    private String pais;
}
