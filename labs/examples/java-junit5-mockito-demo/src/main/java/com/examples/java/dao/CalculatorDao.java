package com.examples.java.dao;

public class CalculatorDao {
    public int add(int a, int b) {
        System.out.println("DAO add called...");
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a - b;
    }

    public int divide(int a, int b) throws ArithmeticException {
        if(b == 0) {
            throw new ArithmeticException("Can't divide by zero");
        }
        return a / b;
    }
}
