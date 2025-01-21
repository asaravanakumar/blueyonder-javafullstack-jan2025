package com.examples.java.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class IteratorEx {
    public static void main(String[] args) {
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("Python");
        skills.add(".Net");
        skills.add("Java");

        System.out.println(skills);

//        Iterator<String> it = skills.iterator();
        ListIterator<String> it = skills.listIterator();
//        skills.add("PHP");  // fail-fast -> throws concurrent modification exception
//        it.next();

        if(it.hasNext()) {
            System.out.println(it.next());
            skills.add("PHP");      // fail-fast -> throws concurrent modification exception
            System.out.println(it.next());
        }

        System.out.println(skills);
    }
}
