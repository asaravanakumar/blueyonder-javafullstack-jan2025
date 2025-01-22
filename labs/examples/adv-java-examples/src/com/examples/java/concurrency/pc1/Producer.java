package com.examples.java.concurrency.pc1;

/**
 * Thread Example
 * Producer with wait & notify
 *
 */
public class Producer implements Runnable{
	private Buffer buffer;
	
	public Producer(Buffer b) {
		buffer = b;
	}
	
	@Override
	public synchronized void run() {
		System.out.println(Thread.currentThread().getName() + " -->Start Running thread");
		while(true) {
			try {
				Thread.sleep(1000);
				while(buffer.hasValue()) {
					synchronized(buffer) { // Acquiring the lock
						buffer.wait(); // Releasing the lock and wait
					}
				}
				double d = Math.random();
				System.out.println(Thread.currentThread().getName() + " produced " + d);
				buffer.setValue(d);
				synchronized(buffer) { // acquiring the lock on buffer object
					buffer.notify(); // notifying the waiting threads
				}
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " interrupted");
				break;
			}
		}
		System.out.println(Thread.currentThread().getName() + " -->Stop thread");
	}
}
