package com.examples.java.core.lang;

import java.io.File;
import java.io.IOException;

public class ProcessBuilderDemo {
    public static void main(String[] args) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-version");
        processBuilder.redirectErrorStream(true);
        File log = new File("java-version.log");
        processBuilder.redirectOutput(log);
        processBuilder.start();
    }
}
