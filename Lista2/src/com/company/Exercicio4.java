package com.company;
import java.util.Scanner;
public class Exercicio4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int x = 0;
        int[] numeros = new int[3];
//        for(int i = 0; i < 3; i++){
//            System.out.println("Informe um número: ");
//            int numero = scanner.nextInt();
//            numeros[i] = numero;
//            }
        do{
            System.out.println("Informe um número: ");
            int numero = scanner.nextInt();
            numeros[x] = numero;
            x = x + 1;

        }while(x<3);
        int menor = 0;
        for (int i = 1;i<numeros.length;i++ ){
            if(numeros[i]<numeros[i-1]){
                menor = numeros[i];
            }
        }
        System.out.println("o menor número é: "+menor);
    }
}
