package com.examples.junit.mockito;

public class MockService {
    private final Person person = new Person("John Doe");

    public String getName() {
        return person.getName();
    }
}

