package com.examples.java.core.statins;

public class StaticInstanceBlockDemo {

    // static block
    static {
        System.out.println("Static Block called..");
    }

    // instance block
    {
        System.out.println("Instance Block called..");
    }

    public StaticInstanceBlockDemo() {
        System.out.println("Default Constructor called...");
    }

    public static void main(String[] args) {
        System.out.println("Static and Instance Block Demo!!!");
        StaticInstanceBlockDemo obj1 = new StaticInstanceBlockDemo();
        StaticInstanceBlockDemo obj2 = new StaticInstanceBlockDemo();
    }

}
