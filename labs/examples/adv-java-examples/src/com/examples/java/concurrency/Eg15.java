package com.examples.java.concurrency;

/**
 * Thread Examples
 * ThreadGroups
 */
public class Eg15 {
	public class MyThread extends Thread {
		public MyThread(ThreadGroup tg, String name) {
			super(tg,name);
		}
		
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " -->Start Running thread");
			try {
				for(int i=0; i <10; i++) {
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " interrupted");
			}
			System.out.println(Thread.currentThread().getName() + " -->Stop thread");
		}
	}
	
	public static void main(String[] args) {
		Eg15 e = new Eg15();
		ThreadGroup tgParent = new ThreadGroup("TG1");
		ThreadGroup tgChild = new ThreadGroup(tgParent,"TG2");
		tgParent.setMaxPriority(Thread.MIN_PRIORITY);
		
		Thread t1 = e.new MyThread(tgParent,"t1");
		t1.setPriority(Thread.MAX_PRIORITY);
		
		Thread t2 = e.new MyThread(tgChild,"t2");
		
		System.out.println(t1.getName() + " priority=" + t1.getPriority());
		System.out.println(t2.getName() + " priority=" + t2.getPriority());
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		tgParent.interrupt();
	}
}
