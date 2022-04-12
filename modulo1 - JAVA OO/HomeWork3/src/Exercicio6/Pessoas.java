package Exercicio6;

public class Pessoas {
    private String nome;
    private int idade;

    public Pessoas(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return "Pessoas{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }
}
