package com.company;

import java.util.Scanner;

public class Exercicio1 {

    public static void main(String[] args) {
        System.out.println("Qual seu nome? ");
        String nome = new Scanner(System.in).nextLine();

        System.out.println("Quantos anos você tem? ");
        int idade = new Scanner(System.in).nextInt();

        System.out.println("Qual sua cidade? ");
        String cidade = new Scanner(System.in).next();

        System.out.println("Qual seu estado ?");
        String estado = new Scanner(System.in).nextLine();

        System.out.println("Olá seu nome é " + nome + " você tem " +idade+
                " anos, " + "é da cidade de "+cidade+" situada no estado " + estado);

    }
}
