package com.company;

public class Pessoa {
    private String nome;
    private String sobreNome;
    private int idade;
    private String Whatsapp;


    public Pessoa(){

    }

    public Pessoa(String nome, String sobreNome){
        this.nome = nome;
        this.sobreNome = sobreNome;
    }
    public java.lang.String getNome() {
        return nome;
    }

    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }

    public java.lang.String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(java.lang.String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public java.lang.String getWhatsapp() {
        return Whatsapp;
    }

    public void setWhatsapp(java.lang.String whatsapp) {
        Whatsapp = whatsapp;
    }








    public void imprimirNome(){
        System.out.println(nome);
    }

    public int retornarIdade(){
        return idade;
    }

    public void conversar(String menssagem, Pessoa pessoaQueRecebeu){
        System.out.println("Pessoa "+nome+" enviou " +menssagem+ " para "+ pessoaQueRecebeu.nome);
    }


    public int diferencaIdade(Pessoa pessoa){
        return idade - pessoa.idade;
    }


    public void mandarWhatsapp (Pessoa pessoa, String mensagem){
        System.out.println("telefone " + getWhatsapp() + " Recebeu "+ mensagem + "de" + this);
    }



    @Override
    public String toString(){
        return nome;
    }

}
