package com.examples.java.java9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TryWithResourcesEnhancementsDemo {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(new File("./input/test.txt"));
        Scanner accIn = new Scanner(new File("./input/account.txt"));

        try(in;accIn) {
            while(in.hasNext()) {
                System.out.println(in.nextLine());
            }
            System.out.println("NO ERROR");
        }
//        catch (FileNotFoundException e) {
//            System.out.println("ERROR: " + e.getMessage());
//        }
    }
}
