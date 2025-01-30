package com.examples.junit.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

public class ParameterizedTests {
    @ParameterizedTest
    @MethodSource("provideSkills")
    public void parameterizedTest(List skills) {
        assertTrue(skills.contains("Java"));
    }

    private static Stream<Arguments> provideSkills() {
        return Stream.of(
                Arguments.of(List.of("Java", "Python", "PHP")),
                Arguments.of(List.of("JUnit", ".Net", "Java"))
        );
    }
}
