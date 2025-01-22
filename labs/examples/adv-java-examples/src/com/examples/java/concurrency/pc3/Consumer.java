package com.examples.java.concurrency.pc3;

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
		while(true) {
			try {
				d = buffer.take();
				System.out.println(Thread.currentThread().getName() + " consumed " + d);
			
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " interrupted");
				break;
			}
		}
		System.out.println(Thread.currentThread().getName() + " -->Stop thread");
	}
}
