package com.company;

import java.util.Random;
import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int[] vetor = new int[10];
        for(int i = 0; i<10;i++){
            int numero = new Random().nextInt(1, 10);
            vetor[i] = numero;
        }

        System.out.println("Digite um número: ");
        int numero = scanner.nextInt();

        for(int i = 0;i<10;i++ ){
            if(numero == vetor[i]){
                System.out.println("O número digitado foi encontrado ");
            }else{
                System.out.println("O número digitado não foi encontrado ");

            }
        }

    }
}
