package br.com.dbc.vemser.pessoaapi.dto.contato;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContatoDTO extends ContatoCreateDTO{
    @ApiModelProperty(value = "ID de contato")
    private Integer idContato;
}
