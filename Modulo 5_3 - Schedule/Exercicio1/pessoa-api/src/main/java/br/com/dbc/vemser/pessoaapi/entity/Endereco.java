package br.com.dbc.vemser.pessoaapi.entity;

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
public class Endereco {

    private Integer idEndereco;
    private Integer idPessoa;
    @NotNull
    private String tipo;
    @NotEmpty
    @Max(250)
    private String logradouro;
    @NotEmpty
    @NotNull
    private Integer numero;
    @NotEmpty
    @NotNull
    @Max(250)
    private String cidade;
    @NotEmpty
    @NotNull
    @Max(8)
    private String cep;
    @NotNull
    private String estado;
    @NotNull
    private String pais;

//    public Endereco(){}
//
//    public Endereco(Integer id, Integer idPessoa, String tipo, String endereco, Integer numero, String cidade) {
//        this.id = id;
//        this.idPessoa = idPessoa;
//        this.tipo = tipo;
//        this.endereco = endereco;
//        this.cidade = cidade;
//        this.numero = numero;
//    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Integer getIdPessoa() {
//        return idPessoa;
//    }
//
//    public void setIdPessoa(Integer idPessoa) {
//        this.idPessoa = idPessoa;
//    }
//
//    public String getEndereco() {
//        return endereco;
//    }
//
//    public void setEndereco(String endereco) {
//        this.endereco = endereco;
//    }
//
//    public String getCidade() {
//        return cidade;
//    }
//
//    public void setCidade(String cidade) {
//        this.cidade = cidade;
//    }
//
//    public Integer getNumero() {
//        return numero;
//    }
//
//    public void setNumero(Integer numero) {
//        this.numero = numero;
//    }
}
