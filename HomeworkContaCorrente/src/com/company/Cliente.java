package com.company;

import java.util.Arrays;

public class Cliente {
    String nome;
    String cpf;
    Contato contatos[] = new Contato[2];
    Endereco enderecos[] = new Endereco[2];

    public Cliente(String nome, String cpf, String descricaoContato1, String telefoneContato1, int tipoContato1,
                   String descricaoContato2, String telefoneContato2, int tipoContato2) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
        this.enderecos = enderecos;
        this.contatos[0] = new Contato(descricaoContato1,telefoneContato1,tipoContato1);
        this.contatos[1] = new Contato(descricaoContato2,telefoneContato2,tipoContato2);
    }


    public void imprimirContatos(){
        System.out.println("Contato 1: "+(contatos[0].descricao+" "+contatos[0].telefone+" " +contatos[0].tipo+"\n"+
                "Contato 1: "+(contatos[1].descricao+" "+contatos[1].telefone+" " +contatos[1].tipo)));


    }







}
