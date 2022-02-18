package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args){
        System.out.println("Digite a palavra para traduzir: ");
         String palavra = new Scanner(System.in).next().toLowerCase(Locale.ROOT);

         switch (palavra){

             case "cachorro" , "dog":
                 System.out.println("Dog = Cachorro");
                 break;
             case "tempo" , "time":
                 System.out.println("Time = Tempo");
                 break;
             case "amor"," love":
                 System.out.println("Love = Amor");
                 break;
             case "cidade", "city":
                 System.out.println("City = Cidade");
                 break;
             case "feliz", "happy":
                 System.out.println("Happy = Feliz");
                 break;
             default:
                 System.out.println("Essa palavra não é válida.");
         }
    }
}
