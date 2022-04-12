package com.company;

public class Main {

    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setIdade(30);
        pessoa1.setNome("Pablo Kapp");
        pessoa1.setWhatsapp("234234");

        Pessoa pessoa2 = new Pessoa("Pablo", "kapp");
        pessoa2.setIdade(30);

        pessoa2.setWhatsapp("234234");

        pessoa1.imprimirNome();
        pessoa2.imprimirNome();

        pessoa1.conversar("mensagem", pessoa2);

        pessoa1.mandarWhatsapp(pessoa2,"oi");
        System.out.println(pessoa1.diferencaIdade(pessoa2));




    }
}
