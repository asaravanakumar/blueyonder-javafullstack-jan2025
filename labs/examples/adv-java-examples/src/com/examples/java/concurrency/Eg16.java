package com.examples.java.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Thread Examples
 * Atomic
 */
public class Eg16 {
	AtomicInteger count = new AtomicInteger(100);
	ThreadLocal<Integer> threadId = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return count.incrementAndGet();
		}
	};
	
	public class MyThread extends Thread {
		
		@Override
		public void run() {
			System.out.println("Thread #" + threadId.get());
		}

	}
	
	public static void main(String[] args) {
		Eg16 e = new Eg16();
		MyThread t1 = e.new MyThread();
		MyThread t2 = e.new MyThread();
		t1.start();
		t2.start();
	}
}
