package com.examples.java.java8.time;

import java.util.Calendar;
import java.util.Date;

public class LegacyDateTimeEx {
	
	public static void main(String[] args) 
	{
		// today's date
		Date today = new Date();
		System.out.println(today);
		
		// yesterday's date
		Date yesterday = new Date("2019/03/14 14:30:00");
		System.out.println(yesterday);	
		
		// yesterday's date in no of seconds elapsed since 1970 01 Jan midnight GMT
		long timeInMillis = Date.parse("2019/03/14 14:30:00");
		System.out.println(timeInMillis);
		// convert time in millis to date object
		System.out.println(new Date(timeInMillis));
		
		
		// creates calendar instance
		Calendar calender = Calendar.getInstance();
		// UTC time in no of seconds elapsed since 1970 01 Jan midnight GMT
		System.out.println(calender.getTimeInMillis());
		// Provides date object
		System.out.println(calender.getTime());
		
	}

}
