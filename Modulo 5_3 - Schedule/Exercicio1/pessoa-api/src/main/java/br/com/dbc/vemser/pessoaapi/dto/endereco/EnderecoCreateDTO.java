package br.com.dbc.vemser.pessoaapi.dto.endereco;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnderecoCreateDTO {

    @ApiModelProperty(value = "ID da Pessoa")
    private Integer idPessoa;
    @ApiModelProperty(value = "Tipo de endereco (RESIDENCIAL || COMERCIAL)")
    @NotNull
    private String tipo;
    @ApiModelProperty(value = "rua || avenida || adress")
    @NotEmpty
    @Size(min = 1, max = 250)
    private String logradouro;
    @ApiModelProperty(value = "Numerod do endereco")
    @NotNull
    private Integer numero;
    @ApiModelProperty(value = "Cidade/Municipio")
    @NotEmpty
    @NotNull
    @Size(min = 1, max = 250)
    private String cidade;
    @ApiModelProperty(value = "Codigo Postal")
    @NotEmpty
    @NotNull
    @Size(min = 8, max = 8)
    private String cep;
    @ApiModelProperty(value = "Estado")
    @NotNull
    private String estado;
    @ApiModelProperty(value = "Pais")
    @NotNull
    private String pais;
}
