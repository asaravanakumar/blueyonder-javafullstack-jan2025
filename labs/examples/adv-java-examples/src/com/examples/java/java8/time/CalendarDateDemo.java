package com.examples.java.java8.time;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarDateDemo {
    public static void main(String[] args) {
        Date current = new Date();
        Date nextWeek = new Date("2023/07/20");
        System.out.println(current);
        System.out.println(nextWeek);

        Calendar currentDate = Calendar.getInstance();
        Calendar greoDate1 = new GregorianCalendar();
//        Calendar japanesDate1 = new ();
        System.out.println(currentDate);

        // JODA DataTime
    }
}
