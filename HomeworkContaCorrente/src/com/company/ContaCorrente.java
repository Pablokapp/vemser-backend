package com.company;

public class ContaCorrente {
    Cliente cliente;
    String numeroConta;
    int agencia;
    double saldo = 0.0;
    double chequeEspecial = 0.0;

    public ContaCorrente(Cliente cliente, String numeroConta, int agencia, double saldo, double chequeEspecial) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.chequeEspecial = chequeEspecial;
    }
    public void imprimirContaCorrente() {
        System.out.println("o número da conta corrente é: " + this.numeroConta);
    }
    public boolean sacar(double valor) {
       if(valor > 0){
           if (valor < retornarSaldoComChequeEspecial()) {
               if(valor < saldo){
                   saldo -= valor;
                   System.out.println("Saque autorizado");
               } double valorMenosSaldo = valor-saldo;
               chequeEspecial -= valorMenosSaldo;
               System.out.println("você retirou seu saldo e "+valorMenosSaldo + " do cheque especial");
               return true;
           }
       }else{
           System.out.println("não é permitido sacar valor nulo ou negativo");
       }

        return false;
    }

    public boolean depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("deposito concluído");
            return true;
        } else {
            System.out.println("é preciso informar um valor válido");
        }
        return false;
    }

    public double retornarSaldoComChequeEspecial() {
        return saldo + chequeEspecial;
    }

    public boolean transferir(ContaCorrente contaCorrente, double valor) {
            if(this.saldo > valor){
                sacar(valor);
                contaCorrente.depositar(valor);
                System.out.println("transferência concluída");
                return true;
            }
        System.out.println("saldo insuficiente");
        return false;
    }

}






