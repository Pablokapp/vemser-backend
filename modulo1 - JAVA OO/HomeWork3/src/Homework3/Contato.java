package Homework3;

public class Contato {

   private String descricao;
    private String telefone;
    private int tipo; //1 - resedencial 2- comercial

    //Construtores
    public Contato(String descricao, String telefone, int tipo){
        setDescricao(descricao);
        setTelefone(telefone);
        setTipo(tipo);
    }

    //métodos
    public void imprimirContato() {
        System.out.println("Contato{" +
                "descricao='" + descricao + '\'' +
                ", telefone='" + telefone + '\'' +
                ", tipo=" + tipo +
                '}');
    }
    @Override
    public String toString() {
        return "Contato{" +
                "descricao='" + descricao + '\'' +
                ", telefone='" + telefone + '\'' +
                ", tipo=" + tipo +
                '}';
    }

    //setters
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    //getters
    public String getDescricao() {
        return descricao;
    }
    public String getTelefone() {
        return telefone;
    }
    public int getTipo() {
        return tipo;
    }


}

