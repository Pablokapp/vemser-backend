package br.com.dbc.vemser.pessoaapi.dto.contato;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContatoCreateDTO {

    @ApiModelProperty(value = "ID pessoa")
    private Integer idPessoa;
    @ApiModelProperty(value = "Tipo de Contato")
    @NotNull
    private String tipo;
    @ApiModelProperty(value = "Numero para contato")
    @NotEmpty @Max(13)
    private String numeroTelefone;
}
