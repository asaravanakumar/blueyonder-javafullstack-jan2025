package com.examples.java.java11;

import java.util.Optional;

public class EmptyOptionalMethodDemo {
    public static void main(String[] args) {
//        Optional<String> address = Optional.of("MG Road, Bengaluru");
        Optional<String> address = Optional.empty();

        if(address.isEmpty()) { // Java 11
            System.out.println("Optional is empty");
        } else {
            System.out.println(address.get());
        }
    }
}
