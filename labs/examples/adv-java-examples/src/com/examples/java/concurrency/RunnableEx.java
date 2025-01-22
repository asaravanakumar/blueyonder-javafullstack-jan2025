package com.examples.java.concurrency;

public class RunnableEx implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " -->Start Running thread");
		for(int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " - " + i);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
		System.out.println(Thread.currentThread().getName() + " -->Stop thread");
		
	}
	
}
