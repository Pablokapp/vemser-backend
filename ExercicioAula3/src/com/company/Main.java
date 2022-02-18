package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Pessoa pablo = new Pessoa();
        Pessoa jose = new Pessoa();

        pablo.nome = "Pablo";
        jose.nome ="Jose";
        jose.sobrenome = "silva";


        pablo.conversar(pablo, "oi");
        jose.conversar(pablo,"tchau");


        pablo.mandarWhatsapp(jose, " oi ");
        pablo.ehMaiorDeIdade();

        System.out.println(jose.retornarNomeCompleto());




    }
}
