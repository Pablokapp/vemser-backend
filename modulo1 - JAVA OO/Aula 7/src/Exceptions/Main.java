package Exceptions;

import org.w3c.dom.ls.LSOutput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continua = false;

        do{
            try {
                System.out.println("Numerado");
                int numerador = scanner.nextInt();

                System.out.println("Denominador");
                int denominador = scanner.nextInt();

                continua = false;
            }catch(InputMismatchException ex){
                System.out.println("Não é permitido inserir letras, informa apenas numeros inteiros");
            }catch(InputMismatchException ex2){

            }




            )
        }

    }


}
