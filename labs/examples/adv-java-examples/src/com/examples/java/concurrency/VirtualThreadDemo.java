package com.examples.java.concurrency;

public class VirtualThreadDemo {
    public static void main(String[] args) {
        // Using a virtual thread factory
        var thread = Thread.ofVirtual().start(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from a virtual thread!");

            }});

        // Waiting for the virtual thread to finish
        try {
            System.out.println(thread.isVirtual());
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread interrupted");
        }
    }
}

