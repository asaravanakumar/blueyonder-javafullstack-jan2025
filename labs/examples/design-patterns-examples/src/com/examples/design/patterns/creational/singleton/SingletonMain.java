package com.examples.design.patterns.creational.singleton;

public class SingletonMain {
    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        obj1.doSomething();

        Singleton obj2 = Singleton.getInstance();
        obj2.doSomething();

        System.out.println(obj1 == obj2);
    }
}
