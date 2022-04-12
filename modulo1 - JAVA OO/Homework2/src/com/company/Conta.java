package com.company;

public abstract class Conta implements Movimentacao{

    private Cliente cliente;
    private String numeroConta;
    private String agencia;
    private double saldo;

    //construtores
    public Conta(Cliente cliente, String numeroConta, String agencia, double saldo){
    this.setCliente(cliente);
    this.setNumeroConta(numeroConta);
    this.setAgencia(agencia);
    this.setSaldo(saldo);
}
    public Conta() {
    }

    //métodos
    @Override
    public boolean sacar(double valor) {
        if(valor > 0){
            if (valor < getSaldo()) {
                setSaldo(getSaldo()-valor);
                System.out.println("Saque autorizado"+"\n"+"Seu saldo atual é: "+this.getSaldo());
                return true;
            }
            System.out.println("não é permitido sacar valor nulo ou negativo");
        }

        return false;
    }
    @Override
    public boolean depositar(double valor) {
        if(valor >0){
            this.setSaldo(getSaldo()+valor);
            System.out.println("Depósito de: "+valor+" realizado");
            return true;
        }

        return false;
    }
    @Override
    public boolean transferir(Conta conta, double valor) {
        if (valor < this.getSaldo()) {
            if (sacar(valor)) {
                conta.depositar(valor);
                System.out.println("transferência concluída");
                return true;
            }

        }
        else if (valor > this.getSaldo()) {
                System.out.println("\n" + "Saldo insuficiente para transferir");
                return false;
            }

        return false;
    }

    //setters
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    //getters
    public Cliente getCliente() {
        return cliente;
    }
    public String getNumeroConta() {
        return numeroConta;
    }
    public String getAgencia() {
        return agencia;
    }
    public double getSaldo() {
        return this.saldo;
    }



}
