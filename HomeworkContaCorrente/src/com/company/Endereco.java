package com.company;
public class Endereco {
    int tipo; //1 - residencial 2 - Comercial
    String logradouro;
    int numero;
    String complemento;
    String cep;
    String cidade;
    String estado;
    String pais;
    public Endereco(int tipo, String logradouro, int numero, String complemento, String cep, String cidade, String estado, String pais) {
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }
    public void imprimirEndereco(Endereco endereco){
        if(tipo==1){
            System.out.println("Enrereço residencial: "+ endereco.logradouro + endereco.numero+endereco.complemento+endereco.cep + endereco.cidade+endereco.estado+endereco.pais);
        }else if(tipo==2){
            System.out.println("Comercial: "+ endereco.logradouro + endereco.numero+endereco.complemento+endereco.cep + endereco.cidade+endereco.estado+endereco.pais);
        }

    }
}
