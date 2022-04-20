package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Contato {

    private Integer idContato;

    private Integer idPessoa;
    @NotNull
    private String tipo;
    @NotEmpty @Min(9) @Max(13)
    private String numeroTelefone;

//    public Contato(){}
//
//    public Contato(Integer id, Integer idPessoa, String tipo, String numeroTelefone) {
//        this.setId(id);
//        this.setIdPessoa(idPessoa);
//        this.setTipo(tipo);
//        this.setNumeroTelefone(numeroTelefone);
//    }

//    public String getTipo() {
//        return tipo;
//    }
//
//    public void setTipo(String tipo) {
//        this.tipo = tipo;
//    }
//
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
//    public String getNumeroTelefone() {
//        return numeroTelefone;
//    }
//
//    public void setNumeroTelefone(String numeroTelefone) {
//        this.numeroTelefone = numeroTelefone;
//    }
}