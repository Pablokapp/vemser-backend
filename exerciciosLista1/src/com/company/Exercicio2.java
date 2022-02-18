package com.company;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a primeira nota: ");
        float nota1 = scanner.nextFloat();

        System.out.println("Digite a segunda nota: ");
        float nota2 = scanner.nextFloat();

        System.out.println("Digite a terceira nota: ");
        float nota3 = scanner.nextFloat();

        System.out.println("Digite a quarta nota: ");
        float nota4 = scanner.nextFloat();


        float media = ((nota1+nota2+nota3+nota4)/4);
        String status = "";
        if(media <= 5){
            status = "reprovado";
        }else if(media >=5.1 && media <= 6.9){
            status = "em exame";
        }else if(media >= 7){
            status = "aprovado";
        }

        System.out.println("A média do aluno é: "+ (String.format("%.2f",media))+ " e está "+status);





    }

    }

