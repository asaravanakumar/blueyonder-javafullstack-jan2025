package com.examples.java.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TryCatchWithResourcesEx {
    public static void main(String[] args) {
        // try with resources
        try(Scanner reader  = new Scanner(new FileReader("D:\\Temp\\input.txt"))) { // throws FileNotFoundException

            // Pause the execution for 1 sec
            Thread.sleep(1000); // throws InterruptedException

            // Reads the content of the file
            while(reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }

            System.out.println("File has been read successfully!!!");
        } catch (FileNotFoundException | InterruptedException e) {  // multi catch exception block
            System.out.println("ERROR: " + e.getMessage());
        }

    }
}
