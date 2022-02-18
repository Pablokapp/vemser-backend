package com.company;
import java.util.Scanner;
public class Exercicio3 {
    public static void main(String[] args){
        System.out.println("Digita a quantidade de elementos desejada");
        Scanner scanner = new Scanner(System.in);
        int[] valores = new int[scanner.nextInt()];
        int soma = 0;
        for(int i=0;i< valores.length;i++){
            System.out.println("digite o valor do vetor "+i+": ");
            valores[i] = scanner.nextInt();
           soma += valores[i];
            }
        System.out.println("Média: "+ soma/valores.length);
    }
}
