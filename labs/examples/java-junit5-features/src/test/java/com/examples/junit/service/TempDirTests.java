package com.examples.junit.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.io.CleanupMode;
import org.junit.jupiter.api.io.TempDir;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TempDirTests {

    @Test
    @Order(3)
    void givenTestMethodWithTempDirectory_whenWriteToFile_thenContentIsCorrect(@TempDir Path tempDir)
            throws IOException {
        Path numbers = tempDir.resolve("numbers.txt");

        List<String> lines = Arrays.asList("1", "2", "3");
        Files.write(numbers, lines);

        System.out.println(Files.readAllLines(numbers));

        assertAll(
                () -> assertTrue(Files.exists(numbers)),
                () -> assertLinesMatch(lines, Files.readAllLines(numbers)));
    }

    @TempDir(cleanup = CleanupMode.ON_SUCCESS)
    File anotherTempDir;

    @Test
    @Order(1)
    void givenFieldWithTempDirectoryFile_whenWriteToFile_thenContentIsCorrect() throws IOException {
        assertTrue(this.anotherTempDir.isDirectory());

        File letters = new File(anotherTempDir, "letters.txt");
        List<String> lines = Arrays.asList("x", "y", "z");

        Files.write(letters.toPath(), lines);

        assertAll(
                () -> assertTrue( Files.exists(letters.toPath())),
                () -> assertLinesMatch(lines, Files.readAllLines(letters.toPath())));
    }

    @Test
    @Order(2)
    void testDataSharing() {
        System.out.println(Arrays.stream(anotherTempDir.listFiles()).count());

        for(File file: anotherTempDir.listFiles()) {
            System.out.println(file);
        }


    }

}
