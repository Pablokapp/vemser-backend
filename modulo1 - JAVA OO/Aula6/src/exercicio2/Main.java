package exercicio2;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
//        Function<Double, Double> sqrt = (value) -> Math.sqrt(value);
//        Function<Double, Double> cos = (value) -> Math.cos(value);
//       Function <Double, Double> cosSqrt = cos.andThen(sqrt);
//       System.out.println(cosSqrt.apply(1.0 ));

        System.out.println(recursiva(4));
    }

    public static Integer recursiva(Integer numero) {
        return numero == 0 ? 0 : numero + recursiva(numero - 1);
        }
    }



