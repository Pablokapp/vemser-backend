package com.company;

import java.util.Scanner;

public class Exercicio5 {
    public static void main (String[] args){
        float valorHora;
        float horasTrabalhadas;
        float horasExtras50;
        float horasExtras100;
        float salario;

        System.out.println("Informe o valor da hora: ");
        valorHora = new Scanner(System.in).nextFloat();

        System.out.println("Informe o número de horas trabalhadas");
        horasTrabalhadas = new Scanner(System.in).nextFloat();

        System.out.println("Horas extra 50%: ");
        horasExtras50 = new Scanner(System.in).nextFloat();
        System.out.println("Horas extra 100%: ");
        horasExtras100 = new Scanner(System.in).nextFloat();

        salario = ((horasTrabalhadas*valorHora)+(horasExtras50*valorHora*1.5f)+(horasExtras100*valorHora*2));
        System.out.println("O seu salário é: R$"+salario);


    }
}
