package Exercicio3;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        Queue<String> fila = new LinkedList<>();

        String pessoa1 = "Joao";
        String pessoa2 = "Jose";
        String pessoa3 = "Pedro";
        String pessoa4 = "Mario";
        String pessoa5 = "Joana";

        String pessoa6 = "William";
        String pessoa7 = "Pablo";
        String pessoa8 = "Andreia";

        fila.add(pessoa1); //Joao
        fila.add(pessoa2); //Jose
        fila.add(pessoa3); //Pedro
        fila.add(pessoa4); //Mario
        fila.add(pessoa5);//Joana

        System.out.println(fila);
        fila.poll();
        fila.poll();
        System.out.println(fila);
        fila.poll();
        System.out.println(fila);
        fila.add(pessoa6);
        fila.add(pessoa7);
        fila.add(pessoa8);
        System.out.println(fila);
        fila.poll();
        fila.poll();
        fila.poll();
        System.out.println(fila);














    }
}
