package com.company;
public class Cliente {
    String nome;
    String cpf;
    Contato contatos[] = new Contato[2];
    Endereco enderecos[] = new Endereco[2];

    public Cliente(String nome, String cpf, String descricaoContato1, String telefoneContato1, int tipoContato1,
                   String descricaoContato2, String telefoneContato2, int tipoContato2,
                   int tipoEndereco1, String logradouroEnd1, int numEnd1, String complementoEnd1, String cepEnd1,
                   String cidadeEnd1, String estadoEnd1, String paisEnd1,
                   int tipoEndereco2, String logradouroEnd2, int numEnd2, String complementoEnd2, String cepEnd2,
                   String cidadeEnd2, String estadoEnd2, String paisEnd2) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos[0] = new Contato(descricaoContato1, telefoneContato1, tipoContato1);
        this.contatos[1] = new Contato(descricaoContato2, telefoneContato2, tipoContato2);
        this.enderecos[0] = new Endereco(tipoEndereco1, logradouroEnd1, numEnd1, complementoEnd1, cepEnd1,
                cidadeEnd1, estadoEnd1, paisEnd1);
        this.enderecos[1] = new Endereco(tipoEndereco2, logradouroEnd2, numEnd2, complementoEnd2, cepEnd2,
                cidadeEnd2, estadoEnd2, paisEnd2);
    }
    public void imprimirContatos() {
        System.out.println("Contato 1: " + (contatos[0].descricao + " " + contatos[0].telefone + " " + contatos[0].tipo + "\n" +
                "Contato 1: " + (contatos[1].descricao + " " + contatos[1].telefone + " " + contatos[1].tipo)));
    }
    public void imprimirEnderecos() {
        if()


    }
    public void imprimirCliente() {
        System.out.println("nome: " + this.nome + "cpf: " + this.cpf);
        this.imprimirContatos();
        this.imprimirEnderecos();
    }
}
