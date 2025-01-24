package com.examples.design.patterns.creational.singleton;

public class Singleton {
    private static Singleton instance;

    private Singleton() {
        System.out.println("Singleton constructor called...");
    }

    public static synchronized Singleton getInstance(){

        if (instance == null)
            instance = new Singleton();

        return instance;
    }

    public void doSomething()
    {
        System.out.println("Hello Singleton!!!");
    }
}
