package com.company;

public class Main {

    public static void main(String[] args) {
        Pessoa pablo = new Pessoa();
        pablo.idade = 30;
        pablo.nome = "Pablo Kapp";
        pablo.telefone = new Telefone();
        pablo.telefone.descricao = "whatsapp";
        pablo.telefone.tipo = "2";
        pablo.telefone.numero = "1424234234";


        Pessoa pablo2 = new Pessoa();
        pablo2.idade = 90;
        pablo2.nome = "Pablo Soares";
        pablo2.telefone = new Telefone();
        pablo2.telefone.descricao = "whatsapp";
        pablo2.telefone.tipo = "2";
        pablo2.telefone.numero = "1424234234";








        pablo.imprimirNome();

        pablo.conversar("mensagem", pablo);

        System.out.println(pablo.diferencaIdade(pablo2));
    }
}
