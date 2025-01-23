package com.examples.java.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinActionExample {

    // Task class that extends RecursiveAction
    static class PrintTask extends RecursiveAction {
        private static final int THRESHOLD = 10;
        private int start, end;

        public PrintTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            // If the task is small enough, compute it directly
            if (end - start <= THRESHOLD) {
                for (int i = start; i < end; i++) {
                    System.out.println(Thread.currentThread().getName() + " Processing value: " + i);
                }
            } else {
                // Split task into two subtasks
                int mid = (start + end) / 2;
                PrintTask leftTask = new PrintTask(start, mid);
                PrintTask rightTask = new PrintTask(mid, end);

                // Fork both subtasks to be computed in parallel
                leftTask.fork();
                rightTask.fork();

                // Join results from both subtasks
                leftTask.join();
                rightTask.join();
            }
        }
    }

    public static void main(String[] args) {
        // Create a ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool();

        // Create the main task (PrintTask) and submit it to the pool
        PrintTask task = new PrintTask(0, 100);
        pool.invoke(task); // Blocking call until the task is done
    }
}

