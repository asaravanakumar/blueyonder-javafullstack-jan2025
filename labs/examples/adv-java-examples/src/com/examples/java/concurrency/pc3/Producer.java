package com.examples.java.concurrency.pc3;

import java.util.concurrent.BlockingQueue;

/**
 * Thread Example
 * Producer
 *
 */
public class Producer implements Runnable{
	private BlockingQueue<Double> buffer;
	
	public Producer(BlockingQueue<Double> q) {
		buffer = q;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " -->Start Running thread");
		while(true) {
			try {
				Thread.sleep(2000);
				double d = Math.random();
				System.out.println(Thread.currentThread().getName() + " produced " + d);
				buffer.put(d);
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " interrupted");
				break;
			}
		}
		System.out.println(Thread.currentThread().getName() + " -->Stop thread");
	}
}
