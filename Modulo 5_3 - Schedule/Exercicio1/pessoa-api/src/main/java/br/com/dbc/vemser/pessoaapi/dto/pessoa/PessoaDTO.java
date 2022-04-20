package br.com.dbc.vemser.pessoaapi.dto.pessoa;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PessoaDTO extends PessoaCreateDTO{
    @ApiModelProperty(value = "ID da pessoa")
    private Integer idPessoa;
}
