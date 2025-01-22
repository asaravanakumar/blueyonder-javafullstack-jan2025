package com.examples.java.concurrency;

/**
 * Thread Examples
 * Volatile
 */
public class Eg09 {
	private volatile boolean flag;
	
	public class Consumer implements Runnable {

		@Override
		public void run() {
			while(!flag) {
				System.out.println(Thread.currentThread().getName() + " waiting for flag");
			}
			System.out.println(Thread.currentThread().getName() + " read flag. Finish processing");
			return;
		}
	}
	
	public class Producer implements Runnable {

		@Override
		public void run() {
			if(!flag) {
				System.out.println(Thread.currentThread().getName() + " setting flag");
				flag = true;
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		Eg09 e = new Eg09();
		Consumer c = e.new Consumer();
		Thread t1 = new Thread(c);
		Producer p = e.new Producer();
		Thread t2 = new Thread(p);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " Joined");
	}
}
