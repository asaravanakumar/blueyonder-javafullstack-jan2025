package com.examples.java.java10;

import java.util.Arrays;
import java.util.Optional;

public class OptionalEnhancementsDemo {
    public static void main(String[] args) {
//        Optional<List<String>> skills = Optional.of(Arrays.asList("Java","Scala","Python","Node"));
        var skills = Optional.of(Arrays.asList("Java","Scala","Python","Node"));
//        var skills = Optional.empty();

        System.out.println(skills.get());
//        System.out.println(skills.orElse(Arrays.asList("Java","Scala")));
        System.out.println(skills.orElseThrow()); // Added in Java 10
    }
}
