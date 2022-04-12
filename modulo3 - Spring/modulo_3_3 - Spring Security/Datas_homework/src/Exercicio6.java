import java.time.*;
import java.time.temporal.ChronoUnit;

public class Exercicio6 {
    public static void main(String[] args) {

        ZonedDateTime dataShow = LocalDateTime.of(2024, 9, 14, 18, 30).atZone(ZoneId.of("Europe/London"));
        ZonedDateTime dataHoje = LocalDateTime.now().atZone(ZoneId.of("Brazil/East"));
        LocalDateTime tempo = LocalDateTime.from(dataHoje);

        long anos = tempo.until(dataShow, ChronoUnit.YEARS);
        tempo = tempo.plusYears(anos);
        long meses = tempo.until(dataShow, ChronoUnit.MONTHS);
        tempo = tempo.plusMonths(meses);
        long dias = tempo.until(dataShow, ChronoUnit.DAYS);
        tempo = tempo.plusDays(dias);
        long horas = tempo.until(dataShow, ChronoUnit.HOURS);
        tempo = tempo.plusHours(horas);
        long minutos = tempo.until(dataShow, ChronoUnit.MINUTES);
        tempo = tempo.plusMinutes(minutos);
        long segundos = tempo.until(dataShow, ChronoUnit.SECONDS);
        System.out.println("faltam " +anos +"anos " + meses +" meses " + dias +" dias " + horas +" horas " + minutos + " minutos " + segundos+" segundos");
    }
}
