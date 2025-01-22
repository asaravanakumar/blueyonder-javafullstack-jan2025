package com.examples.java.concurrency.pc2;

/**
 * Thread Example
 * Consumer
 *
 */
public class Consumer implements Runnable{
	private Buffer buffer;
	
	public Consumer(Buffer b) {
		buffer = b;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " -->Start Running thread");
		double d = 0;
		while(true) {
			try {
				if(buffer.hasValue()) {
					d = buffer.getValue();
					System.out.println(Thread.currentThread().getName() + " consumed " + d);
				} else {
					System.out.println(Thread.currentThread().getName() + " waiting for value to be available");
					Thread.sleep(100);
				}
			
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " interrupted");
				break;
			}
		}
		System.out.println(Thread.currentThread().getName() + " -->Stop thread");
	}
}
