package com.company;

import org.testng.annotations.Test;
import

public class ContaCorrenteTest {
    @Test
    public void deveTestarSaqueComSucesso(){
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.saldo = 1000;
        contaCorrente.chequeEspecial = 1500;

        boolean conseguiuSacar = ContaCorrente.sacar(1400);

        assertTrue(conseguiuSacar);
        assertEqual()


    }
}
