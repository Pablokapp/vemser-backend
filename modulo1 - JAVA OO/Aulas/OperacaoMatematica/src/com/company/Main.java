package com.company;

public class Main {

    public static void main(String[] args) {
        Multiplicacao multiplica = new Multiplicacao();
        Divisao divide = new Divisao();
        Soma soma = new Soma();
        Subtracao subtrai = new Subtracao();

        System.out.println(multiplica.Calcula(10,2));
        System.out.println(divide.Calcula(1000,20));
        System.out.println(soma.Calcula(734,78));
        System.out.println(subtrai.Calcula(678,435));

    }
}
