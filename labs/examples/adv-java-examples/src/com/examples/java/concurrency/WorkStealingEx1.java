package com.examples.java.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WorkStealingEx1 {

        public static void main(final String... args) throws InterruptedException {
            Runnable task1 = () -> System.out.println("Executing Task-1 ...");
            Runnable task2 = () -> 	System.out.println("Executing Task-2 ...");

            ExecutorService execService = Executors.newWorkStealingPool();
            int availableProcessors = Runtime.getRuntime().availableProcessors();
            System.out.println("availableProcessors: " + availableProcessors);
            execService.submit(task1);
            execService.submit(task2);
            execService.awaitTermination(3, TimeUnit.SECONDS);
            execService.shutdownNow();
        }

}
