package com.company;

import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        String nome;
        int altura;
        int idade;
        double peso;
        int jogadoresCadastrados = 0;
        String jogadores[][][][] = new String[10][10][10][10];

        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite o nome: ");
            nome = scanner.nextLine();
            if(nome.equalsIgnoreCase("sair")){
                break;
            }

            System.out.println("Digite a altura: ");
            altura = scanner.nextInt();
            System.out.println("Digite a idade: ");
            idade = scanner.nextInt();
            System.out.println("Digite o peso: ");
            peso = scanner.nextDouble();

            jogadores[jogadoresCadastrados][0][0][0] = nome;
            jogadores[jogadoresCadastrados][1][0][0] = String.valueOf(altura);
            jogadores[jogadoresCadastrados][0][1][0] = String.valueOf(idade);
            jogadores[jogadoresCadastrados][0][0][1] = String.valueOf(peso);


            jogadoresCadastrados += 1;


        } while (!nome.equalsIgnoreCase("sair"));
        System.out.println("Quantidade de Jogadores Cadastrados: " + jogadoresCadastrados + "\n");

        for (int i = 0; i <jogadoresCadastrados;i++) {
            System.out.println(jogadores[i][0][0][0]);
            System.out.println(jogadores[i][1][0][0]);
            System.out.println(jogadores[i][0][1][0]);
            System.out.println(jogadores[i][0][0][1]);
        }
    }




    }
