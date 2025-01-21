package com.examples.java.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * PECS - Producer Extends Consumer Super
 * Use an extends wildcard when you only get values out of a structure.
 * Use a super wildcard when you only put values into a structure.
 * And don’t use a wildcard when you both get and put.
 */
public class WildCardGeneric {
    public static void main(String[] args) {
        List skills = new ArrayList();

        List<String> skills1 = new ArrayList<>();
        skills1.add("Java");
        skills1.add(".Net");
        skills1.add("Python");
        skills1.add("PHP");

        List<Integer> skills2 = new ArrayList<>();

        skills2.add(100);
        skills2.add(200);

        printDetails(skills1);
//        printDetails1(skills1); // incompatible types
        printDetails2(skills1);
        printDetails2(skills2);


        printDetails3(skills1);
//        printDetails3(skills2); // incompatible types

        printDetails4(skills1);
        printDetails4(skills2);

        printDetails5(skills1);

    }

    private static void printDetails(List<String> skills) {
        for (String skill: skills) {
            System.out.println(skill);
        }
    }

    private static void printDetails1(List<Comparable> skills) {
        for (Comparable skill: skills) {
            System.out.println(skill);
        }
    }

    // upper bound wildcard - Producer Extends
    private static void printDetails2(List<? extends Comparable> skills) {
        for (Comparable skill: skills) {
            System.out.println(skill);
        }
    }

    // lower bound wildcard - Consumer Super
    private static void printDetails3(List<? super String> skills) {
        skills.add("Node JS");
        skills.add("Angular");
    }

    // unbounded
    private static void printDetails4(List<?> skills) {
        for (Object skill: skills) {
            System.out.println(skill);
        }
    }

    // No Wildcard when want to do both get and put
    private static void printDetails5(List skills) {
        skills.add("Node JS");
        skills.add("Angular");

        for (Object skill: skills) {
            System.out.println(skill);
        }
    }
}
