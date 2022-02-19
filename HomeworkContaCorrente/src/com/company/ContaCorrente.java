package com.company;

public class ContaCorrente {
    Cliente cliente[] = new Cliente[1];
    String numeroConta;
    int agencia = 0;
    double saldo = 0.0;
    double chequeEspecial = 0.0;


    public void imprimirContaCorrente() {
        System.out.println("o número da conta corrente é: "+ numeroConta);
    }

    public boolean sacar(double valor) {
        if (saldo < valor) {
            return false;
        } else if (saldo > valor)
            return true;

    }s

    public double depositar(){
        return 0.0;
    }

    public double retornarSaldoComChequeEspecial(){
        return 0.0;
    }

    public boolean transferir(ContaCorrente, valor){
        return true;
    }

}






