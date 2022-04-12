package Homework3;

public class ContaPagamento extends Conta implements Impressao {
    private static double TAXA_SAQUE = 4.25;


    public ContaPagamento(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super.setCliente(cliente);
        super.setNumeroConta(numeroConta);
        super.setAgencia(agencia);
        super.setSaldo(saldo);
    }

    @Override
    public void imprimir() {
        System.out.println(

                "--- Conta Pagamento ---" +
                        "\nNome: " + this.getCliente().getNome() +
                        "\nCPF: " + this.getCliente().getCpf() +
                        "\nConta: " + this.getNumeroConta() + " Agência: " + this.getAgencia() +
                        "\nSaldo total: " + this.getSaldo() +
                        "\n---------------------------------"


        );
    }


    @Override
    public boolean sacar(double valor) {
        if (valor > 0) {
            super.sacar(valor+TAXA_SAQUE);
            return true;
        }
//            if ((valor + TAXA_SAQUE) < getSaldo()) {
//                setSaldo((getSaldo() - valor) - TAXA_SAQUE);
//                System.out.println("Saque autorizado" + "\n" + "Seu saldo atual é: " + this.getSaldo() + "\n");
//                return true;
//
//            } else if (valor + TAXA_SAQUE > getSaldo()) {
//                System.out.println("Valor maior que o saldo disponível " + "\n");
//
//            } else if (valor <= 0) {
//                System.out.println("não é permitido sacar valor nulo ou negativo " + "\n");
//            }
//        }
        return false;
    }



    @Override
    public String toString() {
        return super.toString();
    }
}
