package com.examples.java.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadExecutor {
    public static void main(String[] args) {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 10; i++) {
                int taskId = i;
                executor.submit(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Task " + taskId + " running on thread: " + Thread.currentThread());
                    }
                });
            }
        } // Automatically closes the executor
    }
}

