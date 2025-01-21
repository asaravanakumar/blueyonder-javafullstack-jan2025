package com.examples.java.collection;

import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeIteratorEx {
    public static void main(String[] args) {
        List<String> skills = new CopyOnWriteArrayList<>();
        skills.add("Java");
        skills.add("Python");
        skills.add(".Net");
        skills.add("Java");

        System.out.println(skills);

//        Iterator<String> it = skills.iterator();
        ListIterator<String> it = skills.listIterator();

        while(it.hasNext()) {
            System.out.println(it.next());
            skills.add("PHP");      // fail-safe -> no exception
        }

        System.out.println(skills);
    }
}
