package Homework3;

public class ContaCorrente extends Conta implements Impressao{
   private double chequeEspecial = 0.0;

    @Override
    public void imprimir() {
        System.out.println(
                "--- Conta Corrente ---"+
                "\nNome: " + this.getCliente().getNome() +
                        "\nCPF: " + this.getCliente().getCpf() +
                        "\nConta: " + this.getNumeroConta() + " Agência: " + this.getAgencia() +
                        "\n"+"Seu saldo é: "+getSaldo()+
                        "\n"+"Saldo do cheque especial: "+getChequeEspecial()+
                        "\nSaldo total: " + this.retornarSaldoComChequeEspecial()+
                    "\n---------------------------------" +"\n");
    }

    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, double saldo, double chequeEspecial) {
        super();
        super.setCliente(cliente);
        super.setNumeroConta(numeroConta);
        super.setAgencia(agencia);
        super.setSaldo(saldo);
        this.chequeEspecial = chequeEspecial;
    }
    @Override
    public boolean sacar(double valor) {
       if(valor > 0){
           if (valor < retornarSaldoComChequeEspecial()) {
               if(valor < getSaldo()){
                   setSaldo(getSaldo()-valor);
                   System.out.println("Saque autorizado"+"\n"+"Seu saldo atual é: "+this.getSaldo());

                 return true;
               } double valorMenosSaldo = valor-getSaldo();
               this.chequeEspecial -= valorMenosSaldo;
               System.out.println("você retirou seu saldo e "+valorMenosSaldo + " do cheque especial");

               return true;
           }
       }else{
           System.out.println("não é permitido sacar valor nulo ou negativo");
       }

        return false;
    }



    public double retornarSaldoComChequeEspecial() {
        return getSaldo() + chequeEspecial;
    }



    public double getChequeEspecial() {
        return chequeEspecial;
    }


    @Override
    public String toString() {
        return "ContaCorrente{" +
                "chequeEspecial=" + chequeEspecial +
                '}';
    }
}






