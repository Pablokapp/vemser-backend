package com.company;
public class Main {
    public static void main(String[] args) {

        //Conta Corrente
        ContaCorrente conta1 = new ContaCorrente("Pablo","013123120","19199394294","whatsapp", 1,
                500,"123","0001",2000,1,"rua a",12,"casa","123123","Porto Alegre",
                "RS","Brasil");
        ContaPoupanca conta2 = new ContaPoupanca("Pedro","1203102","5197944587","casa",2,"1234","0002",1000,
                2,"Rua B",13,"ap 1","123355","Porto Alegre","RS","Brasil");

        //teste métodos
//        conta1.imprimir();
//        conta1.sacar(100);
//        conta1.depositar(300);
//        conta1.imprimir();
//        conta2.imprimir();
//        conta1.transferir(conta2, 500);
//        conta1.imprimir();
//        conta2.imprimir();
//        conta2.creditarTaxa();
//        conta2.imprimir();
//        conta1.retornarSaldoComChequeEspecial();
//        conta1.depositar(200);


//        conta1.transferir(conta2,30000);
        conta1.imprimir();


//

    }
}
