package com.dbc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy");

        Date d1 = new Date(1995, 11, 30,10,15,00);
        System.out.println(d1);

        System.out.println("informe uma data no formato dia/mês/ano");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println(string);
        Date data = formato.parse(string);
        System.out.println(data);
    }
}
