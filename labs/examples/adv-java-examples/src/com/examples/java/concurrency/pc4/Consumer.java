package com.examples.java.concurrency.pc4;

/**
 * Thread Example
 * Join
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
		while(true) {
			try {
				while(!buffer.hasValue()) {
					synchronized(buffer) {
						buffer.wait();
					}
				}
				double d = buffer.getValue();
				System.out.println(Thread.currentThread().getName() + " consumed " + d);
				synchronized(buffer) {
					buffer.notifyAll();
				}
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " interrupted");
				break;
			}
		}
		System.out.println(Thread.currentThread().getName() + " -->Stop thread");
	}
}
