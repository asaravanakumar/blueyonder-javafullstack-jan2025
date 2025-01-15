package com.examples.java.core.lang;

public class SystemDemo {
    public static void main(String[] args) {
       long currentTimeMillis =  System.currentTimeMillis();
       System.out.println(currentTimeMillis);

       long currentTimeNanos = System.nanoTime();
       System.out.println(currentTimeNanos);
    }
}
