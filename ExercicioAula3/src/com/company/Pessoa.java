package com.company;

public class Pessoa {
    String nome;
    String sobrenome;
    int idade;
    String Whatsapp;

    public void conversar(Pessoa pessoa, String mensagem){
        System.out.println(this.nome +" conversou com "+ pessoa.nome+" disse "+mensagem);
        }

    public String retornarNomeCompleto(){
        return this.nome + this.sobrenome;
        }

public boolean ehMaiorDeIdade(){
        if(this.idade>=18){
            return (true);
        }
    return false;
}

    public void mandarWhatsapp (Pessoa pessoa, String mensagem){

        System.out.println(this.nome+ " enviou: "+ mensagem +" para " +pessoa.nome);
    }
}
