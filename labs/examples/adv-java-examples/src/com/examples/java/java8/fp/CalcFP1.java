package com.examples.java.java8.fp;

/**
 * Calculator with Functional Programming style
 */
public class CalcFP1 {

    public int compute(int a, int b, String operator) {
        int out;

        switch (operator) {
            case "add":
                out = a + b;
                break;
            case "sub":
                out = a - b;
                break;
            case "mul":
                out = a * b;
                break;
            case "div":
                out = a / b;
                break;
            default:
                out = 0;
        }
        return out;
    }

    public int compute(int a, int b, MathOperation op) {
        return op.compute(a,b);
    }

//    public int compute(int a, MathOperation op) {
//        return op.compute(a);
//    }

}
