package com.examples.java.java10;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionAndStreamEnhancementsDemo {
    public static void main(String[] args) {
        List<String> skills = List.of("Java","Scala","Python","Java"); // Java 9

        // creates unmodifiable collection
//        var skills1 = Collections.unmodifiableList(skills);
//        System.out.println(skills1);
//        skills1.add("PHP"); // throws UnsupportedOperationException

        var skills1 = List.copyOf(skills); // Java 10
        System.out.println(skills1);
//        skills1.add("PHP"); // throws UnsupportedOperationException

        var skills2 = Set.copyOf(skills); // Java 10
        System.out.println(skills2);
//        skills2.add("PHP"); // throws UnsupportedOperationException

        // Stream API Enhancements
        Stream<Integer> ids = Stream.of(10,20,30,20,40,50,60,70,80,90,10);
        var filteredIds = ids.filter(i -> i < 30).collect(Collectors.toUnmodifiableList()); // Java 10
        System.out.println(filteredIds);
//        filteredIds.add(30); // throws UnsupportedOperationException

    }
}
