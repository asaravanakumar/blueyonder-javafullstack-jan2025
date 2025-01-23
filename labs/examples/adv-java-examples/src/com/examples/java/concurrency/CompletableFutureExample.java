package com.examples.java.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
    public static void main(String[] args) {
        // Asynchronous task using supplyAsync() to fetch data
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Fetching data in " + Thread.currentThread().getName());
            // Simulate long-running task (e.g., API call or computation)
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 50; // Returning some result
        });


        // Chain another task to process the result
        CompletableFuture<Integer> resultFuture = future.thenApply(result -> {
            System.out.println("Processing result in " + Thread.currentThread().getName());
            return result * 2; // Process the result (multiply by 2)
        });

        // Get the result (blocking, just for demo purposes)
        try {
            System.out.println("Result: " + resultFuture.get()); // Prints 100
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}