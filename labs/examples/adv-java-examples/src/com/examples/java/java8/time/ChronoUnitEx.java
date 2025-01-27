package com.examples.java.java8.time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class ChronoUnitEx {

	public static void main(String args[]) {
		ChronoUnitEx chronoUnitEx = new ChronoUnitEx();
		chronoUnitEx.testChromoUnits();
	}

	public void testChromoUnits() {
		// Get the current date
		LocalDate today = LocalDate.now();
		System.out.println("Current date: " + today);

		// add 1 week to the current date
		LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
		System.out.println("Next week: " + nextWeek);

		// add 1 month to the current date
		LocalDate nextMonth = today.plus(1, ChronoUnit.MONTHS);
		System.out.println("Next month: " + nextMonth);

		// add 1 year to the current date
		LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
		System.out.println("Next year: " + nextYear);

		// add 10 years to the current date
		LocalDate nextDecade = today.plus(1, ChronoUnit.DECADES);
		System.out.println("Date after ten year: " + nextDecade);
		
		// Get the current date
		LocalTime currentTime = LocalTime.now();
		System.out.println("Current time: " + currentTime);

		// add 1 second to the current time
		LocalTime nextSecond = currentTime.plus(1, ChronoUnit.SECONDS);
		System.out.println("Next second: " + nextSecond);

		// add 1 minute to the current time
		LocalTime nextMinute = currentTime.plus(1, ChronoUnit.MINUTES);
		System.out.println("Next minute: " + nextMinute);

		// add 1 year to the current time
		LocalTime nextHour = currentTime.plus(1, ChronoUnit.HOURS);
		System.out.println("Next hour: " + nextHour);		
	}
}
