package ArrayList;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> minhaLista = new ArrayList<>();
        minhaLista.add("um");
        minhaLista.add("dois");
        minhaLista.add("três");

        System.out.println(minhaLista);

        System.out.println(minhaLista.size());

        System.out.println(minhaLista.indexOf("dois"));
        System.out.println(minhaLista.remove(1));
        System.out.println(minhaLista.contains("dois"));
        System.out.println(minhaLista);
        System.out.println(minhaLista.indexOf("três"));

        minhaLista.add(0, "Quatro");
        System.out.println(minhaLista);


    }
}
