package com.dbc.pessoaapi.dto;


import lombok.Data;

import java.util.List;

@Data
public class PessoaDTOComEnderecos extends PessoaDTO {
    private List<EnderecoDTO> enderecos;

}
