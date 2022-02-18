package com.company;

public class Loops {
    public static void main (String[] main){

        for(int i =0; i<3;i++){

        }

        int[] valores = {2,3,5,7,11,13};
        for(int i=0;i<valores.length;i++){
            System.out.println("posição= "+i+"| valor ="+valores[i]);
        }

        for(int valor:valores){
            System.out.println(valor);
        }

    }
}
