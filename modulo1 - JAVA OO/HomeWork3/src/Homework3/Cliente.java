package Homework3;
import java.util.ArrayList;

public class Cliente {
   private String nome;
    private String cpf;
    ArrayList<Contato> contatos = new ArrayList<>();
    ArrayList<Endereco> enderecos = new ArrayList<>();

    //Construtores


    public Cliente (String nome, String cpf, Contato contato,Endereco endereco){
        this.nome = nome;
        this.cpf = cpf;
        contatos.add(contato);
        enderecos.add(endereco);

    }



    //métodos
    public void imprimirContatos() {
        System.out.println(contatos);
    }
    public void imprimirCliente(){
    System.out.println("nome: "+this.nome+ "cpf: "+this.cpf+"\n");
    this.imprimirContatos();
    System.out.println("\n");
//    imprimirEnderecos();
}

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", contatos=" + contatos +
                '}';
    }

    //setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public void setContatos(Contato contato) {
          contatos.add(contato);
    }
    public void setEnderecos(Endereco endereco) {
        enderecos.add(endereco);
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
    public Endereco getEnderecos() {
        return enderecos;
    }

}
