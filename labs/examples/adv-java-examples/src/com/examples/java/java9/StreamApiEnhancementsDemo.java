package com.examples.java.java9;

import java.util.stream.Stream;

public class StreamApiEnhancementsDemo {
    public static void main(String[] args) {
        Stream<Integer> ids = Stream.of(10,20,30,20,40,50,60,70,80,90,10);
//        ids.filter(i -> i < 30).forEach(System.out::println);
        ids.takeWhile(i -> i < 30).forEach(System.out::println);
        ids.dropWhile(i -> i < 30).forEach(System.out::println);
    }
}
