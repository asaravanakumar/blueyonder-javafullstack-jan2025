package com.examples.java.java10;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LocalVariableTypeInferenceDemo {
    // var not allowed as instance/member variable
//    var counter = 0;
    public static void main(String[] args) {
//        var a; // Not allowed. Need initializer.
        var a = 10;
        var b = 20;
        System.out.println(add(10,20));

        // It's not recommended. May reduce the readability
        var skills = Stream.of("Java","Python","Scala","Java")
                .filter(item -> item.equals("Java"))
                .collect(Collectors.toList());
        System.out.println(skills);
    }

    // can't use var for method params and return type
    public static int add(int a, int b) {
        return a + b;
    }
}
