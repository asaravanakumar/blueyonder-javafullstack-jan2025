package com.examples.java.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinSumExample {

    // Task class that extends RecursiveTask to return a result
    static class SumTask extends RecursiveTask<Long> {
        private static final int THRESHOLD = 10; // Task splitting threshold
        private long[] array;
        private int start, end;

        public SumTask(long[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            // If the task is small enough, compute it directly
            if (end - start <= THRESHOLD) {
                System.out.println(Thread.currentThread().getName() + " inner task");

                long sum = 0;
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                return sum;
            } else {
                System.out.println(Thread.currentThread().getName() + " outer task");
                // Split task into two subtasks
                int mid = (start + end) / 2;
                SumTask leftTask = new SumTask(array, start, mid);
                SumTask rightTask = new SumTask(array, mid, end);

                // Fork both subtasks to be computed in parallel
                leftTask.fork();
                rightTask.fork();

                // Join results from both subtasks
                long leftResult = leftTask.join();
                long rightResult = rightTask.join();

                // Combine results
                return leftResult + rightResult;
            }
        }
    }

    public static void main(String[] args) {
        // Create an array of numbers
        long[] array = new long[40];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        // Create a ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool();

        // Create the main task (SumTask) and submit it to the pool
        SumTask task = new SumTask(array, 0, array.length);
        long result = pool.invoke(task); // Blocking call until the task is done

        System.out.println("Sum: " + result); // Should print the sum of numbers from 1 to 100
    }
}

