package com.company;

import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args){
        int[] i = new int[20];
        int x = 0;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Digite o número "+(x+1)+":");
            i[x] = scanner.nextInt();
            x += 1;
        }while (x<20);

        for(int y = i.length-1;y>=0;y--){
            int numero = i[y];
            System.out.println(numero);

        }
//        while(x>i.length){
//            System.out.println(i[x]);
//            x--;
//        }



    }
}
