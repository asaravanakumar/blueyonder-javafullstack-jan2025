package com.examples.java.concurrency;

import com.examples.java.concurrency.pc4.Buffer;
import com.examples.java.concurrency.pc4.Consumer;
import com.examples.java.concurrency.pc4.Producer;

/**
 * Thread Example
 * Producer Consumer using wait & notifyAll
 */
public class Eg08 {
	public static void main(String[] args) {
		Buffer b = new Buffer();
		Consumer c1 = new Consumer(b);
		Consumer c2 = new Consumer(b);
		Producer p = new Producer(b);
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		Thread t3 = new Thread(p);
		t1.start();
		t2.start();
		t3.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.interrupt();
		t2.interrupt();
		t3.interrupt();
	}
}
