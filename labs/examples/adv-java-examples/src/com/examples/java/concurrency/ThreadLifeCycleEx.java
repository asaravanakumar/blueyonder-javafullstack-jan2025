package com.examples.java.concurrency;

import java.util.Scanner;

public class ThreadLifeCycleEx {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Thread lifecycle demo");
		System.out.println(">>>> Starting thread " + Thread.currentThread().getName());

		System.out.println("Goes to sleep...");
		Thread.sleep(3000);

		System.out.println("Thread woke up...");

		System.out.println("Blocked for input");
		Scanner in = new Scanner(System.in);
		System.out.print("Enter input: ");
		String input = in.nextLine();
		System.out.println("Got input and thread execution resumed");
		
		System.out.println("<<<< Stopping thread " + Thread.currentThread().getName());
	}

}
