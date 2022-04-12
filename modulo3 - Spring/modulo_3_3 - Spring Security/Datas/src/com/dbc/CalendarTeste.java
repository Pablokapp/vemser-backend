package com.dbc;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class CalendarTeste {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        Date data = calendar.getTime();
        System.out.println(data);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));

        calendar.set(Calendar.MONTH, Calendar.JULY);
        System.out.println(calendar.getTime());


        Calendar calendarTimeZone = Calendar.getInstance();
        calendarTimeZone.setTimeZone(TimeZone.getTimeZone("Asia/Dubai"));
        System.out.println(calendarTimeZone.getTime());

        

    }
}
