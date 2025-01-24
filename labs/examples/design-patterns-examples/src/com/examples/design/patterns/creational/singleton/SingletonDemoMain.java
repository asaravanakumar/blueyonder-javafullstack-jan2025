package com.examples.design.patterns.creational.singleton;

public class SingletonDemoMain {
    public static void main(String[] args) {
        SingletonDemo obj1 = SingletonDemo.getInstance();
        obj1.greetings();

        SingletonDemo obj2 = SingletonDemo.getInstance();
        obj2.greetings();

//        SingletonDemo obj3 = new SingletonDemo();

        System.out.println(obj1 == obj2);
//        System.out.println(obj1 == obj3);

    }
}
