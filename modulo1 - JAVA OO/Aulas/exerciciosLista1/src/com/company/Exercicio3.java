package com.company;

import java.util.Scanner;

public class Exercicio3 {
   public static void main(String[] args){
        System.out.println("Digite o valor total consumido: ");
       float totalConsumido = new Scanner(System.in).nextFloat();
        System.out.println("Digite o valor pago: ");
        float valorPago = new Scanner(System.in).nextFloat();

        if(totalConsumido>valorPago){
            System.out.println("o valor pago deve ser maior ou igual ao valor consumido");
        }else if(valorPago>totalConsumido){
            System.out.println("O troco é R$"+ (valorPago-totalConsumido));

        }
    }
}
