package Exercicio5;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Map<String, String> mapa = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String nome = "";
        String cpf = "";


        System.out.println("Digite um nome ou para sair digite 'sair'");
        System.out.println();
        System.out.println("nome: ");
        nome = scanner.nextLine();

        while(!nome.equalsIgnoreCase("sair")){
            System.out.println("cpf: ");
            cpf = scanner.nextLine();

            mapa.put(cpf,nome);
            System.out.println("nome: ");
            nome = scanner.nextLine();
        }
        System.out.println("consulte um cpf: ");
        cpf = scanner.nextLine();
        if(mapa.containsKey(cpf)){
            System.out.println("cpf e nome: " +nome +" "+cpf);
            mapa.remove(cpf);
            System.out.println("Lista de nomes e cpf: " + mapa);

        }else if(!mapa.containsKey(cpf)){
            System.out.println("\ncpf não existe");

        }
        System.out.println(mapa);
    }
}