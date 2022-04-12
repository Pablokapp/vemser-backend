package com.company;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o tipo de comida");
        String tipo = scanner.nextLine().toUpperCase().replace(" ", "_");

        System.out.println(TipoComida.valueOf(tipo).getDescricao());

//        TipoComida.valueOf(())
//
//        switch (tipoComida) {
//            case JAPONESA -> System.out.println("");
//            case FAST_FOOD -> System.out.println(tipoComida.getDescricao());
//            case TRADICIONAL -> System.out.println();
//        }
    }
}