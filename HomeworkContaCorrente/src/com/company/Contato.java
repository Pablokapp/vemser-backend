package com.company;
public class Contato {
    String descricao;
    String telefone;
    int tipo; //1 - resedencial 2- comercial
    public Contato(String descricao, String telefone, int tipo){
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipo = tipo;
    }
    public void imprimirContato(Contato contato){
        System.out.println(contato.descricao+"  "+contato.telefone+" "+contato.tipo);
    }
}
