package com.company;

public class ContaPoupanca extends Conta implements Impressao{
    private static final double JUROS_MENSAL = 1.01;

    //Construtores
    public ContaPoupanca(String nome, String cpf, String telefone, String descricao, int tipo, String numeroConta, String agencia, double saldo,
                         int tipoEndereco, String logradouro, int numero, String complemento, String cep, String cidade, String estado, String pais){
        Cliente cliente = new Cliente(nome, cpf, telefone, descricao, tipo, tipoEndereco, logradouro, numero, complemento, cep, cidade, estado, pais);
        super.setCliente(cliente);
        super.setNumeroConta(numeroConta);
        super.setAgencia(agencia);
        super.setSaldo(saldo);
    }

    //métodos
    public void creditarTaxa(){
        super.setSaldo(getSaldo()*JUROS_MENSAL);
    }
    @Override
    public void imprimir() {
        System.out.println(
                "--- Conta Poupança ---"+
                "\nNome: " + this.getCliente().getNome() +
                        "\nCPF: " + this.getCliente().getCpf() +
                        "\nConta: " + this.getNumeroConta() + " Agência: " + this.getAgencia() +
                        "\nSaldo total: " + this.getSaldo()+
                "\n---------------------------------");

    }

}
