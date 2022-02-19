package com.company;

import java.util.Scanner;

public class Exercicio3semmatriz {
    public static void main(String[] args) {
        String nome;
        int altura;
        int idade;
        double peso;
        int jogadoresCadastrados = 0;
        int alturaDoMaiorJogador = 0;
        String nomeDoJogadorMaisVelho ="";
        String nomeDoJogadorMaisPesado ="";
        int jogadorMaisVelho = 0;
        double jogadorMaisPesado = 0.0;
        int alturaDosJogadores = 0;


        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite o nome: ");
            nome = scanner.nextLine();
            if (nome.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.println("Digite a altura: ");
            altura = scanner.nextInt();
            alturaDosJogadores += altura;
            System.out.println("Digite a idade: ");
            idade = scanner.nextInt();
            System.out.println("Digite o peso: ");
            peso = scanner.nextDouble();

            if (altura > alturaDoMaiorJogador) {
                alturaDoMaiorJogador = altura;
            }

            if (idade > jogadorMaisVelho) {
                jogadorMaisVelho = idade;
                nomeDoJogadorMaisVelho = nome;
            }
            if (peso > jogadorMaisPesado) {
                jogadorMaisPesado = peso;
                nomeDoJogadorMaisPesado = nome;

            }
            jogadoresCadastrados += 1;

            } while (!nome.equalsIgnoreCase("sair"));

        System.out.println("Quantidade de jogadores cadastrados: "+jogadoresCadastrados);
        System.out.println("Altura do maior jogador: "+alturaDoMaiorJogador);
        System.out.println("Jogador mais velho: "+nomeDoJogadorMaisVelho + "tem "+jogadorMaisVelho+" anos");
        System.out.println("Jogador mais pesado: "+nomeDoJogadorMaisPesado + " pesa "+jogadorMaisPesado+"kg");
        System.out.println("média das alturas dos jogadores: "+(alturaDosJogadores/jogadoresCadastrados));

        }
        }


