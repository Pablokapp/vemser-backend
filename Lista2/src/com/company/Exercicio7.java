package com.company;

import java.util.Random;

public class Exercicio7 {
    public static void main(String[] args){

        int[][] vetor = new int[4][4];
        int maiorQueDez =0;

        for(int i = 0; i<4;i++){
            int x = new Random().nextInt(1, 15);
            int y = new Random().nextInt(1, 15);
            vetor[i][0] = x;
            vetor[0][i] = y;

            if(vetor[i][0] > 10){
                maiorQueDez = maiorQueDez + 1 ;
                System.out.println(vetor[i][0]);
            }else if(vetor[0][i] > 10){
                maiorQueDez = maiorQueDez + 1 ;
                System.out.println(vetor[0][i]);
            }
        }

        System.out.println("total "+maiorQueDez);
    }
}
