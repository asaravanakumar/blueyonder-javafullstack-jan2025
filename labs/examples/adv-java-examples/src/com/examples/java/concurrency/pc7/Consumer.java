package com.examples.java.concurrency.pc7;

import java.util.concurrent.BlockingQueue;

/**
 * Thread Example
 * Consumer
 *
 */
public class Consumer implements Runnable{
	private BlockingQueue<Double> buffer;
	
	public Consumer(BlockingQueue<Double> q) {
		buffer = q;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " -->Start Running thread");
		double d = 0;
		try {
			while(true) {
				d = buffer.take();
				System.out.println(Thread.currentThread().getName() + " consumed " + d);
			
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " interrupted");
		}
		System.out.println(Thread.currentThread().getName() + " -->Stop thread");
	}
}
