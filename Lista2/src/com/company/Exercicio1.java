package com.company;
import java.util.Scanner;
public class Exercicio1 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
            System.out.println("Digite o nome do produto: ");
            String produto = scanner.nextLine();
            System.out.println("Digite o valor: ");
            double valor = scanner.nextDouble();
        System.out.println("Produto: "+produto+"\n"+
                "Preço R$: "+valor+"\n"+
                "Promoção: "+produto);

                double desconto = 0.05;

                    for(int i = 1;i<10;i++){
                double produtoComDesconto = valor - (valor*desconto);

                System.out.printf("%n%d x "+ produto + " R$ %.2f = R$ %.2f", i, produtoComDesconto, produtoComDesconto * i);
                desconto+=0.05;
        }
    }
}
