package com.company;

import java.util.Scanner;

public class Exercicio1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual seu nome? ");
        String nome = scanner.nextLine();

        System.out.println("Quantos anos você tem? ");
        int idade = scanner.nextInt();

        System.out.println("Qual sua cidade? ");
        String cidade = scanner.nextLine();

        System.out.println("Qual seu estado ?");
        String estado = scanner.nextLine();

        System.out.println("Olá seu nome é " + nome + " você tem " +idade+
                " anos, " + "é da cidade de "+cidade+" situada no estado " + estado);

        scanner.close();
    }
}
