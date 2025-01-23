package com.examples.java.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class CustomThreadFactoryExample {
    public static void main(String[] args) {
        // Create an ExecutorService with a custom ThreadFactory
        ExecutorService executor = Executors.newFixedThreadPool(3, new CustomThreadFactory());

        // Submit tasks to the executor
        for (int i = 0; i < 5; i++) {
            executor.submit(() -> {
                System.out.println("Running in thread: " + Thread.currentThread().getName());
            });
        }

        executor.shutdown();
    }

    // Custom ThreadFactory that names threads and sets them as daemon
    static class CustomThreadFactory implements ThreadFactory {
        private int threadId = 1;

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("CustomThread-" + threadId++);
//            thread.setDaemon(true); // Set as daemon thread
            return thread;
        }
    }
}