import java.time.LocalTime;
import java.time.ZoneId;

public class Exercicio3 {
    public static void main(String[] args) {

        LocalTime horaBrasil = LocalTime.now(ZoneId.of("Brazil/East"));
        LocalTime horaAustralia = LocalTime.now(ZoneId.of("Australia/Sydney"));
        LocalTime horaJapao = LocalTime.now(ZoneId.of("Japan"));
        LocalTime horaRussia = LocalTime.now(ZoneId.of("Europe/Moscow"));
        LocalTime horaDubai = LocalTime.now(ZoneId.of("Asia/Dubai"));
        LocalTime horaEstadosUnidos = LocalTime.now(ZoneId.of("America/North_Dakota/Center"));

        System.out.println("Brasil " + horaBrasil+ "\n Australia "+ horaAustralia +"\n Japão "+ horaJapao + "\n Russia "
        + horaRussia + "\n Dubai " + horaDubai + "\n Estados Unidos " + horaEstadosUnidos);



    }
}
