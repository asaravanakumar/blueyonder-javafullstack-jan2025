package com.examples.junit.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class SimpleNestedTests {
    @Nested
    class PrimaryTests {

        @Test
        void test1() {
            Assertions.assertEquals(1 + 2, 3);
        }
    }

    @Nested
    class SecondaryTests {

        @Test
        void test2() {
            Assertions.assertEquals(1 + 2, 3);

        }
    }
}
