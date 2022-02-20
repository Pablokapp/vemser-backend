package com.company;
public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Anderson", "4545667", "telefone 1", "113123", 1,
                "contato2", "12312313213", 2, 1,
                "Júlio de Castilhos", 596, "ap 1", "90030-10", "Porto Alegre", "RS",
                "Brasil", 2, "rua 1", 200, "casa", "91845-57", "Alvorada",
                "RS", "Brasil");

        Cliente cliente2 = new Cliente("Anderson", "4545667", "telefone 1", "113123", 1,
                "contato2", "12312313213", 2, 1,
                "Júlio de Castilhos", 596, "ap 1", "90030-10", "Porto Alegre", "RS",
                "Brasil", 2, "rua 1", 200, "casa", "91845-57", "Alvorada",
                "RS", "Brasil");

        ContaCorrente contaCorrente1 = new ContaCorrente(cliente1, "1", 1,1000,2000);
        ContaCorrente contaCorrente2 = new ContaCorrente(cliente2, "2", 1,1000,2000);

        contaCorrente1.imprimirContaCorrente();
        contaCorrente1.sacar(3000);
        contaCorrente1.depositar(500);
        contaCorrente1.retornarSaldoComChequeEspecial();
        contaCorrente1.transferir(contaCorrente2, 500);
        cliente1.imprimirEnderecos();
    }
}
