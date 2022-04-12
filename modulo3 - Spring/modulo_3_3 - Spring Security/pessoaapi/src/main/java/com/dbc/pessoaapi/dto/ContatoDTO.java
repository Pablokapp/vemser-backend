package com.dbc.pessoaapi.dto;

import com.dbc.pessoaapi.entity.TipoContato;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ContatoDTO extends ContatoCreateDTO{
    private Integer idContato;
    private Integer idPessoa;
}
