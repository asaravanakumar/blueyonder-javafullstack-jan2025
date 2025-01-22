package com.examples.java.concurrency.pc2;

/**
 * Thread Example
 * Producer
 *
 */
public class Producer implements Runnable{
	private Buffer buffer;
	
	public Producer(Buffer b) {
		buffer = b;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " -->Start Running thread");
		while(true) {
			try {
				Thread.sleep(1000);
				double d = Math.random();
				System.out.println(Thread.currentThread().getName() + " produced " + d);
				while(buffer.isFull()) {
					System.out.println(Thread.currentThread().getName() + " waiting for buffer space");
					Thread.sleep(100);
				}
				buffer.setValue(d);
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " interrupted");
				break;
			}

		}
		System.out.println(Thread.currentThread().getName() + " -->Stop thread");
	}
}
