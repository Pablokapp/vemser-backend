package com.company;

import java.util.Random;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero = new Random().nextInt(1, 10);
        System.out.println("Tente advinhar o número de 1 a 10: ");
        int tentativa = scanner.nextInt();
        if (tentativa == numero) {
            System.out.println("Você acertou o número");
        } else if (tentativa < numero) {
            System.out.println("O número a ser encontrado é maior do que você digitou ");
        } else if (tentativa > numero) {
            System.out.println("O número a ser encontrado é menor do que você digitou ");
        }
    }
}

