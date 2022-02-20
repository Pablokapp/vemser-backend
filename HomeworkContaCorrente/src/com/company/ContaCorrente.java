package com.company;

import org.w3c.dom.ls.LSOutput;

public class ContaCorrente {
    Cliente cliente[] = new Cliente[1];
    String numeroConta;
    int agencia;
    double saldo = 0.0;
    double chequeEspecial = 0.0;

    public ContaCorrente (Cliente cliente, String numeroConta, int agencia){
        this.cliente[0] = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;

    }


    public void imprimirContaCorrente() {
        System.out.println("o número da conta corrente é: "+ this.numeroConta);
    }

    public boolean sacar(double valor) {
        if (saldo < valor) {
            return false;
        } else if (saldo > valor)
            return true;

    }

    public boolean depositar(double valor){



        saldo += valor;


        return true;
    }

    public double retornarSaldoComChequeEspecial(){
        return saldo+chequeEspecial;
    }

    public boolean transferir(ContaCorrente contaCorrente, double valor){

        return false;

    }


}






