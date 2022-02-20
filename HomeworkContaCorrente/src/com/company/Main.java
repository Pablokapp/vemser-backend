package com.company;

public class Main {

    public static void main(String[] args) {


        Cliente anderson = new Cliente("Anderson", "4545667", "telefone 1", "113123", 1,
                "contato2", "12312313213", 2, 1,
                "Júlio de Castilhos", 596, "ap 1", "90030-10", "Porto Alegre", "RS",
                "Brasil", 2, "rua 1", 200, "casa", "91845-57", "Alvorada",
                "RS", "Brasil");



//        Cliente william = new Cliente("Anderson", "4545667", "telefone 1", "113123", 1,
//                "contato2", "12312313213", 2, 1,
//                "Júlio de Castilhos", 596, "ap 1", "90030-10", "Porto Alegre", "RS",
//                "Brasil", 2, "rua 1", 200, "casa", "91845-57", "Alvorada",
//                "RS", "Brasil");
////        anderson.imprimirContatos();
////        System.out.println("\n");
//
        ContaCorrente teste = new ContaCorrente(anderson, "123134", 1,1000,2000);
        ContaCorrente test2 = new ContaCorrente(anderson, "123134", 1,1000,2000);



//        anderson.imprimirEndereco();
//        teste.transferir(teste, 100);
//        anderson.imprimirCliente();
//        teste.imprimirContaCorrente();

//        teste.sacar(500);
        teste.transferir(test2, 500);

    }
}
