package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercício2 {
    public static void main(String[] args) {
        ArrayList<String> nomes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String nome="";
//        do {
//            System.out.println("Digite um nome: ");
//            nome = scanner.nextLine();
//            if (!nome.equalsIgnoreCase("sair")) {
//                nomes.add(nome);
//            }
//
//        } while (!nome.equalsIgnoreCase("sair"));
//        System.out.println(nomes);
//        System.out.println(nomes.get(nomes.size() - 2));
//        System.out.println(nomes.get(0));
//        System.out.println(nomes.remove(nomes.size() - 1));
//        System.out.println(nomes);
//        System.out.println(nomes.size());


        while (!nome.equalsIgnoreCase("sair")) {
            System.out.println("Digite um nome: ");
            nome = scanner.nextLine();
            if(!nome.equalsIgnoreCase("sair")){
                nomes.add(nome);
            }

        }
        System.out.println(nomes);


    }
}

