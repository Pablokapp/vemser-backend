package com.company;

public class Pessoa {
    String nome;
    int idade;
    Telefone telefone;


    public void imprimirNome(){
        System.out.println(nome);
    }

    public int retornarIdade(){
        return idade;
    }

    public void conversar(String menssagem, Pessoa pessoaQueRecebeu){
        System.out.println("Pessoa "+nome+" enviou " +menssagem+ " para "+ pessoaQueRecebeu.nome);
    }


    public int diferencaIdade(Pessoa pessoa){
        return idade - pessoa.idade;
    }


    public void mandarWhatsapp (String mensagem, Telefone telefone){
        System.out.println("telefone " + telefone + " Recebeu "+ mensagem + "de" + this.telefone);
    }



    @Override
    public String toString(){
        return nome;
    }

}
