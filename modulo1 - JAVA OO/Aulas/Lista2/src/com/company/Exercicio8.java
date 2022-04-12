package com.company;

import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        double notaFinal = 0.0;
        double[][] matriz = new double[5][4];
        double maiorNotaFinal = 0.0;
        double mediaNotasFinais = 0.0;


        for(int i = 0;i<5; i++){
            System.out.println("número da matrícula: ");
            matriz[i][0] = scanner.nextDouble();
            System.out.println("médio das provas: ");
            matriz[i][1] = scanner.nextDouble();
            System.out.println("médio dos trabalhos: ");
            matriz[i][2] = scanner.nextDouble();

        }
        for(int i = 0;i<5; i++){
            System.out.println("\n"+"número da matrícula: " + matriz[i][0]);
            System.out.println("médio das provas: "+matriz[i][1]);
            System.out.println("médio dos trabalhos: "+matriz[i][2]);
            notaFinal = matriz[i][1]*0.6+matriz[i][2]*0.4;
            System.out.printf("Nota final: %.2f" , notaFinal);
            System.out.println();
            mediaNotasFinais += notaFinal;
            if(notaFinal==0){
                maiorNotaFinal = matriz[i][0];
            }else if(maiorNotaFinal<notaFinal){
                maiorNotaFinal = matriz[i][0];
            }
        }
        System.out.println("\nmatricula com maior nota final "+ maiorNotaFinal);
        System.out.println("média das notas finais "+mediaNotasFinais/5);

    }
}
