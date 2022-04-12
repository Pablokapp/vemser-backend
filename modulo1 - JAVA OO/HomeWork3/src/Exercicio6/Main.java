package Exercicio6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Pessoas> pessoas = new ArrayList<>();
        pessoas.add(new Pessoas("joao",98));
        pessoas.add(new Pessoas("jose",35));
        pessoas.add(new Pessoas("maria",50));
        pessoas.add(new Pessoas("pedro",20));
        pessoas.add(new Pessoas("joao",45));
        pessoas.add(new Pessoas("joao",2));
        pessoas.add(new Pessoas("marcos",62));
        pessoas.add(new Pessoas("adao",75));

        System.out.println(pessoas+"\n");

        pessoas.sort(new Comparator<Pessoas>() {
            @Override
            public int compare(Pessoas o1, Pessoas o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });
        System.out.println(pessoas+"\n");

        pessoas.sort(new Comparator<Pessoas>() {
            @Override
            public int compare(Pessoas o1, Pessoas o2) {
                return o2.getIdade() - o1.getIdade();
            }
        });

        System.out.println(pessoas+"\n");

        pessoas.sort(new Comparator<Pessoas>() {
            @Override
            public int compare(Pessoas o1, Pessoas o2) {
                int comparacao = o1.getNome().compareTo(o2.getNome());
                if ((comparacao != 0)) {
                    return o1.getNome().compareTo(o2.getNome());
                }
                return o1.getIdade() - o2.getIdade();
            }
        });
        System.out.println(pessoas);
    }
}
