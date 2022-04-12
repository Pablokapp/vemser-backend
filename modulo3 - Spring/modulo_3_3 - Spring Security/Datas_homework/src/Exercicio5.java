import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Exercicio5 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        Locale brasil = new Locale("pt-BR");
        System.out.println("Formato de data Brasileira: " + now.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
                .withLocale(brasil)));
        Locale eua = new Locale("en");
        System.out.println("Formato de data Americano: " + now.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
                .withLocale(eua)));
        Locale frances = new Locale("fr");
        System.out.println("Formato de data Francês: " + now.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
                .withLocale(frances)));
    }
}
