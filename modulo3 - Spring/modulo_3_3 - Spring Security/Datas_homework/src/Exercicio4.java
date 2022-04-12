import java.time.LocalDateTime;

public class Exercicio4 {
    public static void main(String[] args) {
        LocalDateTime dataAtual = LocalDateTime.now();
        LocalDateTime dataAtualFinal = dataAtual.plusDays(15).plusHours(10);
        System.out.println("dia da semana: " + dataAtualFinal.getDayOfWeek());
        System.out.println("dia do ano (corrido): " + dataAtualFinal.getDayOfYear());
    }
}
