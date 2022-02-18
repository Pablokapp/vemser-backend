package com.company;

import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args){
        int[] i = new int[20];
        int x = 1;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Digita o número "+x+":");
            i[x] = scanner.nextInt();
            x += 1;
        }while (x<20);

        for(int y = i.length;y>=0;y--){
            System.out.println(i[y]);

        }
//        while(x>i.length){
//            System.out.println(i[x]);
//            x--;
//        }



    }
}
