package com.examples.design.patterns.creational.singleton;

public class SingletonDemo {
//    static boolean flag = false;
    static SingletonDemo instance;

    // Eager Initialization
    static {
        System.out.println("Static block called...");
        if(instance == null) {
            instance = new SingletonDemo();
        }
    }

    private SingletonDemo() {
        System.out.println("Singleton constructor called...");
    }

    // Lazy Initialization
    public static SingletonDemo getInstance() {

        return instance;
    }

    public void greetings() {
        System.out.println("Hello Singleton!!!");
    }
}
