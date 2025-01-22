package com.examples.java.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Thread Example
 * Creation of thread by implementing Callable
 */
public class Eg03{

	public static void main(String[] args) {
		Eg03 eg = new Eg03();

		Callable<String> c1 = new Eg03.MyCallable();

//		Callable<String> c2 = new Eg03.MyCallable();
//		Callable<String> c3 = new Eg03.MyCallable();
//
//		List<Callable<String>> callList = List.of(c1, c2, c3);

		ExecutorService e = Executors.newSingleThreadExecutor();
//		ExecutorService e = Executors.newFixedThreadPool(3);
//		ExecutorService e = Executors.newCachedThreadPool();

//		List<Future<String>> futureList = null;
//		try {
//			futureList = e.invokeAll(callList);
//		} catch (InterruptedException e2) {
//			e2.printStackTrace();
//		}

		Future<String> f = e.submit(c1);

//		for (Future<String> f : futureList) {
			if(!f.isDone()) {
				System.out.println(Thread.currentThread().getName() + " -->Waiting");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			String s = null;
			try {
				s = f.get();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			} catch (ExecutionException e1) {
				e1.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " Reuturned Value:" + s);			
//		}

		// shutdown the executor
		e.shutdown();
	}
	public static class MyCallable implements Callable<String> {
		@Override
		public String call() throws Exception {
			System.out.println(Thread.currentThread().getName() + " -->Start Running thread");
			for(int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + " - " + i);
				//			try {
				//				Thread.sleep(1000);
				//			} catch (InterruptedException e) {
				//				e.printStackTrace();
				//			}
			}
			System.out.println(Thread.currentThread().getName() + " -->Stop thread");
			return "Hello World";
		}
	}
}
