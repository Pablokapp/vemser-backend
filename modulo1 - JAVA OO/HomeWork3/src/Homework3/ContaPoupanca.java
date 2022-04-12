package Homework3;

public class ContaPoupanca extends Conta implements Impressao{
    private static final double JUROS_MENSAL = 1.01;

    //Construtores
    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, double saldo){
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
