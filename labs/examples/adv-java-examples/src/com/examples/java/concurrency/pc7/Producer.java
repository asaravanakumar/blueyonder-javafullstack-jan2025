package com.examples.java.concurrency.pc7;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * Thread Example
 * Producer
 *
 */
public class Producer implements Runnable{
	private static final Semaphore producerCounter = new Semaphore(2);
	private BlockingQueue<Double> buffer;
	
	public Producer(BlockingQueue<Double> q) {
		buffer = q;
	}
	
	@Override
	public void run() {
		try {
			producerCounter.acquire();
			System.out.println(Thread.currentThread().getName() + " -->Start Running thread");
			while(true) {
				Thread.sleep(2000);
				double d = Math.random();
				System.out.println(Thread.currentThread().getName() + " produced " + d);
				buffer.put(d);
			}
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " interrupted");
		}
		
		producerCounter.release();		
		System.out.println(Thread.currentThread().getName() + " -->Stop thread");
	}
}
