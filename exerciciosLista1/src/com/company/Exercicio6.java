package com.company;

import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args){
        System.out.println("Digite a palavra para traduzir: ");
         String palavra = new Scanner(System.in).next();

         switch (palavra){

             case "Cachorro":
                 System.out.println("Dog");
                 break;
             case "Tempo":
                 System.out.println("Time");
                 break;
             case "Amor":
                 System.out.println("Love");
                 break;
             case "Cidade":
                 System.out.println("City");
                 break;
             case "Feliz":
                 System.out.println("Happy");
                 break;
             default:
                 System.out.println("Essa palavra não é válida.");
         }
    }
}
