import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a primeira data no formato dd/mm/aaaa");
        String primeiraData = scanner.nextLine();
        System.out.println("Digite a segunda data no formato dd/mm/aaaa");
        String segundaData = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate primeiraDataFormatada = LocalDate.parse(primeiraData, formatter);
        LocalDate segundaDataFormatada = LocalDate.parse(segundaData, formatter);

        Period periodo = Period.between(primeiraDataFormatada, segundaDataFormatada);
        System.out.println("Faltam " + periodo.getMonths() + " meses " + periodo.getDays() + " dias para a próxima data" );

    }
}
