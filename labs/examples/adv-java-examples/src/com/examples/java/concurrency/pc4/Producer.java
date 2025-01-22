package com.examples.java.concurrency.pc4;

/**
 * Thread Example
 * Join
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
				while(buffer.hasValue()) {
					synchronized(buffer) {
						buffer.wait();
					}
				}
				double d = Math.random();
				System.out.println(Thread.currentThread().getName() + " produced " + d);
				buffer.setValue(d);
				synchronized(buffer) {
					buffer.notifyAll();
				}
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " interrupted");
				break;
			}
		}
		System.out.println(Thread.currentThread().getName() + " -->Stop thread");
	}
}
