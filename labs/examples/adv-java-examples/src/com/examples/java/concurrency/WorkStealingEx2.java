package com.examples.java.concurrency;

import java.util.concurrent.*;

public class WorkStealingEx2 {
    public static void main(final String... args) throws InterruptedException, ExecutionException {
        Callable<String> task1 = () -> {
            System.out.println("Executing Task-1");
            return "Task-1 Finish.";
        };
        Callable<String> task2 = () -> {
            System.out.println("Executing Task-2");
            return "Task-2 Finish.";
        };


        ExecutorService execService = Executors.newWorkStealingPool();
        Future<String> future1 = execService.submit(task1);
        Future<String> future2 = execService.submit(task2);

        String output1 = future1.get();
        System.out.println(output1);

        String output2 = future2.get();
        System.out.println(output2);

        execService.awaitTermination(3, TimeUnit.SECONDS);
        execService.shutdownNow();
    }
}
