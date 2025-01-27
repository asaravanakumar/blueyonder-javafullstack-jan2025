package com.examples.java.java8.time;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/**
 * Instant class represents an instantaneous moment on the timeline.
 */
public class InstantEx {
	public static void main(String[] args)
	{
		InstantEx instantEx = new InstantEx();
		instantEx.testInstant();
	}
	
	public void testInstant()
	{
		   // Get the current UTC time
		   Instant timestamp = Instant.now();
		   System.out.println(timestamp);
		   
		   // One hour later
		   Instant oneHourLater = Instant.now().plus(1, ChronoUnit.HOURS);
		   System.out.println(oneHourLater);		   
	}
}
