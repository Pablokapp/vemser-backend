package com.company;

import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {

        System.out.println("Digite o primeiro valor: ");
        Scanner scanner = new Scanner(System.in);
        int valorUm =  scanner.nextInt();

        System.out.println("Digite a operação + - / ou * ");
        String operacao = scanner.next();

        System.out.println("Digite o segundo valor: ");
        int valorDois = scanner.nextInt();

        switch (operacao){

            case "+":
                System.out.println(valorUm+valorDois);
                break;
            case "-":
                System.out.println(valorUm-valorDois);
                break;

            case "*":
                System.out.println(valorUm*valorDois);
                break;
            case "/":
                System.out.println(valorUm/valorDois);
                break;
        }
    }
}
