package com.examples.java.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class CopyFileWithCharacterStreamEx {

   public static void main(String args[]) throws IOException {
      FileReader in = null;
      FileWriter out = null;

      try {
         in = new FileReader("./input/input.txt");
         out = new FileWriter("./output/output.txt");
         
         int c;
         while ((c = in.read()) != -1) {
            out.write(c);
            System.out.println((char)c);
         }
         
         System.out.println("File copied successfully.");
         
      }finally {
         if (in != null) {
            in.close();
         }
         if (out != null) {
            out.close();
         }
      }
   }
}