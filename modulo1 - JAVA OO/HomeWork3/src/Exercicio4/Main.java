package Exercicio4;
import java.util.Random;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Stack<Integer> pilha = new Stack<>();


        for (int i = 0; i < 15; i++) {
            int numero = random.nextInt(0, 1000);
            System.out.println("numero aleatório gerado: "+numero);
            if (numero % 2 == 0) {
                pilha.add(numero);
                System.out.println("numero adicionado");

            } else if(numero % 2 != 0){
                System.out.println("número impar encontrado");
                if(!pilha.empty()) {
                    pilha.pop();
             }
            }
            System.out.println(pilha+"\n");
        }

        System.out.println("Esvaziando pilha");
        for(int i = pilha.size();i> 0; i--){
            System.out.println(pilha);
            pilha.pop();
        }




    }
}