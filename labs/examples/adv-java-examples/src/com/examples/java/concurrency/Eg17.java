package com.examples.java.concurrency;

import com.examples.java.concurrency.pc7.Consumer;
import com.examples.java.concurrency.pc7.Producer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Thread Example
 * Producer Consumer using BlockingQueue
 *
 */
public class Eg17 {
	public static void main(String[] args) {
		BlockingQueue<Double> q = new LinkedBlockingQueue<Double>(5);
		Consumer c = new Consumer(q);
		Producer p1 = new Producer(q);
		Producer p2 = new Producer(q);
		Producer p3 = new Producer(q);
		Thread t1 = new Thread(c,"c");
		Thread t2 = new Thread(p1,"p1");
		Thread t3 = new Thread(p2,"p2");
		Thread t4 = new Thread(p3,"p3");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		try {
			Thread.sleep(10000);
			t2.interrupt();

			Thread.sleep(10000);
			t1.interrupt();
			t3.interrupt();
			t4.interrupt();
		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
