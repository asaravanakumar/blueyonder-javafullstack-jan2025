package com.examples.java.java9;

import java.util.List;
import java.util.Set;

public class CollectionEnhancementsDemo {
    public static void main(String[] args) {
        List<String> skills = List.of("Java","Python","Node");
//        skills.add("PHP"); // throws UnsupportedOperationException
        System.out.println(skills);

        Set<String> skillSet = Set.of("Java","Python","Node");
//        skills.add("PHP"); // throws UnsupportedOperationException
        System.out.println(skillSet);
    }
}
