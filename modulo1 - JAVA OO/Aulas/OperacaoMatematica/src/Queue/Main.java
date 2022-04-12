package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();
        fila.add("um");
        fila.add("dois");
        fila.add("três");
        fila.add("quatro");

        System.out.println(fila);

        String proximo = fila.poll();
        System.out.println(proximo);

        System.out.println(fila);

        System.out.println(fila.size());
        String verificar = fila.peek();
        System.out.println(verificar);

    }
}
