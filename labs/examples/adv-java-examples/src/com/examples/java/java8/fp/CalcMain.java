package com.examples.java.java8.fp;

public class CalcMain {
    public static void main(String[] args) {

        // Object Oriented Programming style
        System.out.println("Object Oriented Programming style");

        CalcOOP calc = new CalcOOP();
        calc.a = 100;
        calc.b = 20;

        System.out.println("100 + 20 = " + calc.add());
        System.out.println("100 - 20 = " + calc.subtract());
        System.out.println("100 * 20 = " + calc.multiply());
        System.out.println("100 / 20 = " + calc.divide());

        calc.a = 500;
        calc.b = 100;

        System.out.println("500 + 100 = " + calc.add());
        System.out.println("500 - 100 = " + calc.subtract());
        System.out.println("500 * 100 = " + calc.multiply());
        System.out.println("500 / 100 = " + calc.divide());

        // Functional Programming style
        System.out.println("\nFunctional Programming style");

//        CalcFP calc = new CalcFP();
//
//        System.out.println("100 + 20 = " + calc.add(100, 20));
//        System.out.println("100 - 50 = " + calc.subtract(100, 50));
//        System.out.println("500 * 20 = " + calc.multiply(500, 20));
//        System.out.println("500 / 100 = " + calc.divide(500, 100));

//        CalcFP1 calc1 = new CalcFP1();
//        System.out.println("100 + 20 = " + calc1.compute(100, 20, "add"));
//        System.out.println("100 - 50 = " + calc1.compute(100, 50, "sub"));
//        System.out.println("500 * 20 = " + calc1.compute(500, 20, "mul"));
//        System.out.println("500 / 100 = " + calc1.compute(500, 100, "div"));
//
//        CalcFP1 calc2 = new CalcFP1();
//        MathOperation add = new MathOperation() {
//            @Override
//            public int compute(int a, int b) {
//                return a + b;
//            }
//        };
//
//        MathOperation sub = new MathOperation() {
//            @Override
//            public int compute(int a, int b) {
//                return a - b;
//            }
//        };
//
//        MathOperation mul = new MathOperation() {
//            @Override
//            public int compute(int a, int b) {
//                return a * b;
//            }
//        };
//
//        MathOperation div = new MathOperation() {
//            @Override
//            public int compute(int a, int b) {
//                return a / b;
//            }
//        };
//
//        System.out.println("100 + 20 = " + calc1.compute(100, 20, add));
//        System.out.println("100 - 50 = " + calc1.compute(100, 50, sub));
//        System.out.println("500 * 20 = " + calc1.compute(500, 20, mul));
//        System.out.println("500 / 100 = " + calc1.compute(500, 100, div));

        // Lambda Expression with Custom Functional Interface
//        System.out.println("\nFunctional Programming with Lambda Expressions");

//        MathOperation add = (int a, int b) -> a + b;        // parameters w/ data types
//        MathOperation subtract = (a, b) -> a - b;           // parameters w/ data types
//        MathOperation multiply = (a, b) -> {return a * b;}; // expression body w/ return statement
//        MathOperation divide = (a, b) -> {                  // expression body w/ multiple statements
//            System.out.println("Divding " + a + " by " + b);
//            return a / b;
//        };
//
//        System.out.println("100 + 20 = " + add.compute(100, 20));
//        System.out.println("100 - 50 = " + subtract.compute(100, 50));
//        System.out.println("500 * 20 = " + multiply.compute(500, 20));
//        System.out.println("500 / 100 = " + divide.compute(500, 100));

        // Lambda Expression with Standard Functional Interface
//        BiFunction<Integer, Integer, Integer> add = (Integer a, Integer b) -> a + b;        // parameters w/ data types
//        BiFunction<Integer, Integer, Integer> subtract = (a, b) -> a - b;           // parameters w/ data types
//        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> {return a * b;}; // expression body w/ return statement
//        BiFunction<Integer, Integer, Integer> divide = (a, b) -> {                  // expression body w/ multiple statements
//            System.out.println("Divding " + a + " by " + b);
//            return a / b;
//        };
//
//        Function<Integer, Integer> square = a -> a * a;
//        Predicate<Integer> condition = a -> a > 50;
//        Consumer<String> print = msg -> System.out.println(msg);
//        Supplier<String> greetings = () -> "Welcome to Lambda Expressions!!!";
//
//        System.out.println("100 + 20 = " + add.apply(100, 20));
//        System.out.println("100 - 50 = " + subtract.apply(100, 50));
//        System.out.println("500 * 20 = " + multiply.apply(500, 20));
//        System.out.println("500 / 100 = " + divide.apply(500, 100));
//        System.out.println("100 ^ 2 = " + square.apply(100));
//        System.out.println("25 > 50 = " + condition.test(25));
//        print.accept("Hello Calculator");
//        System.out.println(greetings.get());

    }
}
