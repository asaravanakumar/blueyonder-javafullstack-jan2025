package com.examples.java.java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NewFileMethodsDemo {

	public static void main(String[] args) throws IOException {
		// eadString and writeString static methods from Files class
		Path filePath = Files.writeString(Files.createTempFile(Path.of("D:\\Temp"), "demo", ".txt"), "Sample text");
		String fileContent = Files.readString(filePath);
		System.out.println(fileContent);
	}

}
