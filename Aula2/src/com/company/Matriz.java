package com.company;
public class Matriz {
    public static void main(String[] args){
//        int[][] matriz = new int[2][2];
//        matriz[0][0] = 15;
//        matriz[0][1] = 25;
//        matriz[1][0] = 35;
//        matriz[1][1] = 45;
//        System.out.println(matriz[0][1]);
//
        int[][] matrizUm ={{15,25},{35,45}};
        System.out.println("Soma de Todos os Valores: "+ (matrizUm[0][0]+matrizUm[0][1]) +(matrizUm[1][0]+matrizUm[1][0]) + "\n" +
                 "Soma dos Valores da Primeira Linha: " + (matrizUm[0][0]+matrizUm[0][1])+"\n"+
                    "Soma dos Valores da Segunda Linha: "+(matrizUm[1][0]+matrizUm[1][0])+"\n"+
                    "valor da primeira linha - valor da segunda linha: " + ((matrizUm[0][0]+matrizUm[0][1])-(matrizUm[1][0]+matrizUm[1][0])));
    }
}
