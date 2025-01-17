package com.examples.java.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MultiCatchExceptionEx {
    public static void main(String[] args) {
        Scanner reader = null;
        try {
            reader = new Scanner(new FileReader("D:\\Temp\\input.txt")); // throws FileNotFoundException
            // Pause the execution for 1 sec
            Thread.sleep(1000); // throws InterruptedException

            // Reads the content of the file
            while(reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }

            System.out.println("File has been read successfully!!!");
        } catch (FileNotFoundException | InterruptedException e) {  // multi catch exception block
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            if(reader != null) {
                reader.close();
            }
        }

    }
}
