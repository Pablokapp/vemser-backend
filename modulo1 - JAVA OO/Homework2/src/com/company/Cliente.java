package com.company;
import java.util.Arrays;

public class Cliente {
   private String nome;
    private String cpf;
    private Contato contatos[] = new Contato[2];
    private Endereco enderecos[] = new Endereco[2];

    //Construtores
    public Cliente(String nome, String cpf, String telefone, String descricao, int tipo, int tipoEndereco, String logradouro, int numero, String complemento, String cep, String cidade, String estado, String pais) {
        this.nome = nome;
        this.cpf = cpf;
        Contato contato = new Contato(descricao,telefone,tipo);
        contatos[0] = contato;
        Endereco endereco = new Endereco(tipoEndereco, logradouro, numero,complemento,cep,cidade,estado,pais);
        enderecos[0] = endereco;
    }
    public Cliente(String nome, String cpf, String telefone, String descricao, int tipo, int tipoEndereco, String logradouro, int numero, String complemento, String cep, String cidade, String estado, String pais,
                    String telefone2, String descricao2, int tipo2, int tipoEndereco2, String logradouro2, int numero2, String complemento2, String cep2, String cidade2, String estado2, String pais2) {
        this.nome = nome;
        this.cpf = cpf;
        Contato contato = new Contato(descricao,telefone,tipo);
        contatos[0] = contato;
        Endereco endereco = new Endereco(tipoEndereco, logradouro, numero,complemento,cep,cidade,estado,pais);
        enderecos[0] = endereco;
        Contato contato2 = new Contato(descricao2,telefone2,tipo2);
        contatos[1] = contato;
        Endereco endereco2 = new Endereco(tipoEndereco2, logradouro2, numero2,complemento2,cep2,cidade2,estado2,pais2);
        enderecos[1] = endereco;
    }

    //métodos
    public void imprimirContatos() {
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i] != null) {
                contatos[i].imprimirContato();
            }
        }
    }
    public void imprimirEnderecos() {
        for (int i = 0; i < enderecos.length; i++) {
            if (enderecos[i] != null) {
                enderecos[i].imprimirEndereco();
            }
        }
    }
    public void imprimirCliente(){
    System.out.println("nome: "+this.nome+ "cpf: "+this.cpf+"\n");
    this.imprimirContatos();
    System.out.println("\n");
    imprimirEnderecos();
}
    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", contatos=" + Arrays.toString(contatos) +
                ", enderecos=" + Arrays.toString(enderecos) +
                '}';
    }

    //setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setContatos(Contato[] contatos) {
        this.contatos = contatos;
    }
    public void setEnderecos(Endereco[] enderecos) {
        this.enderecos = enderecos;
    }
    //getters
    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public Contato getContatos() {
        imprimirContatos();
        return null;
    }
    public Endereco[] getEnderecos() {
        return enderecos;
    }

}
