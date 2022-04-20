package br.com.dbc.vemser.pessoaapi.dto.endereco;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnderecoDTO extends EnderecoCreateDTO {
    @ApiModelProperty(value = "ID do endereco")
    private Integer idEndereco;
}
