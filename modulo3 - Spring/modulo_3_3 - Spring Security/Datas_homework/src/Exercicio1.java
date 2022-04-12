import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("digite a data do seu aniversário dd/mm/aaaa");
        String data = scanner.nextLine();
        DateTimeFormatter aniversario = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataAniversario = LocalDate.parse(data, aniversario);
        LocalDate hoje = LocalDate.now();
        Period periodo = Period.between(dataAniversario, hoje);
        System.out.println("Faltam " + periodo.getMonths() + " meses " + periodo.getDays() + " dias para o seu aniversário" );
    }
}
