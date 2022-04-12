package com.company;

import jdk.swing.interop.SwingInterOpUtils;
import org.w3c.dom.ls.LSOutput;

import java.util.Random;
import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean numeroEncontrado = false;

        int[] vetor = new int[10];

        for(int i = 0; i<10;i++){
            int numero = random.nextInt(1, 10);
            vetor[i] = numero;
        }

        System.out.println("Digite um número: ");
        int numero = scanner.nextInt();

        for(int i = 0;i<10;i++ ){
            if(numero == vetor[i]){
                numeroEncontrado = true;
            }

            }
        if(numeroEncontrado == true){
            System.out.println("o número foi encontrado");
        }else{
            System.out.println("o número não foi encontrado");
        }

        }

    }

