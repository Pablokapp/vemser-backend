package com.company;

import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        System.out.println("Escolha um estado: " + "\n" + "1: Rio Grande do Sul" + "\n" + "2: Rio de Janeiro" + "\n" + "3: são Paulo");
        int estadoEscolhido = new Scanner(System.in).nextInt();
        int cidadeEscolhida;
        switch (estadoEscolhido) {
            case 1:
                System.out.println("Escolha uma cidade: " + "\n" + "1: Porto Alegre " + "\n" + "2: Gravatai ");
                cidadeEscolhida = new Scanner(System.in).nextInt();
                switch (cidadeEscolhida) {
                    case 1:
                        System.out.println("A população de Porto Alegre é de 1.492.530 pessoas." + "\n" + "A principal festa é a Semana Farroupilha" + "\n" + "o IDH de Porto Alegre é: 0,805");
                    case 2:
                        System.out.println("A população de Gravatai é de 285.564 pessoas." + "\n" + "A principal festa é a Nossa Senhora dos Anjos" + "\n" + "o IDH de Gravatai é: 0,862");
                }
                break;

            case 2:
                System.out.println("Escolha uma cidade: " + "\n" + "1: São Gonçalo " + "\n" + "2: Duque de Caxias ");
                cidadeEscolhida = new Scanner(System.in).nextInt();
                switch (cidadeEscolhida) {
                    case 1:
                        System.out.println("A população de São Gonçalo é de 1.098.357 pessoas." + "\n" + "A principal festa é o aniversário da emancipação do município, que é comemorado no dia 22 de setembro" + "\n" + "o IDH de São Gonçalo é: 0,739");
                    case 2:
                        System.out.println("A população de Duque de Caxias é de 929.449 pessoas." + "\n" + "A principal festa é o Dia da emancipação do município de Duque de Caxias " + "\n" + "o IDH de Gravatai é: 0,711");

                }
                break;
            case 3:
                System.out.println("Escolha uma cidade: " + "\n" + "1: Guarulhos" + "\n" + "2: Campinas ");
                cidadeEscolhida = new Scanner(System.in).nextInt();
                switch (cidadeEscolhida) {
                    case 1:
                        System.out.println("A população de São Guarulhos é de 1.404.694  pessoas." + "\n" + "A principal festa é o Aniversário de Guarulhos, que é comemorado no dia 08 de dezembro" + "\n" + "o IDH de São Gonçalo é: 0,739");
                    case 2:
                        System.out.println("A população de Campinas é de 1.223.237 pessoas." + "\n" + "A principal festa é o dia de Nossa Senhora da Conceição, padroeira municipal, comemorado em 8 de dezembro" + "\n" + "o IDH de Campinas é: 0,805");

                }
                break;
        }
    }
}
