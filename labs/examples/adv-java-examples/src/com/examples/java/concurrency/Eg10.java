package com.examples.java.concurrency;

import com.examples.java.concurrency.pc5.Buffer;
import com.examples.java.concurrency.pc5.Consumer;
import com.examples.java.concurrency.pc5.Producer;

/**
 * Thread Example
 * Producer Consumer using Lock
 */
public class Eg10 {
	public static void main(String[] args) {
		Buffer b = new Buffer(5);
		Consumer c = new Consumer(b);
		Producer p = new Producer(b);
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(p);
		t1.start();
		t2.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t1.interrupt();
		t2.interrupt();
	}
}
