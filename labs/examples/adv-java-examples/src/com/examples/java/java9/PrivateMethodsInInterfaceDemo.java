package com.examples.java.java9;

public interface PrivateMethodsInInterfaceDemo {

//    void print();

    default void print() {
        printDetails();
    }

    // supported in Java 9
    private void printDetails() {
        System.out.println("Hello Java!!!");
    }

}
