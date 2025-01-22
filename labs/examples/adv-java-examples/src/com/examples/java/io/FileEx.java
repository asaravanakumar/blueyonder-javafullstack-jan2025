package com.examples.java.io;

import java.io.File;

public class FileEx {
	
	public static void main(String[] args)
	{
		File file = new File("./input");
		
		System.out.println("Is Directory: " + file.isDirectory());
		System.out.println("Absolute Path: " + file.getAbsolutePath());
		System.out.println("Path: " + file.getPath());
		System.out.println(file.lastModified());
		System.out.println();
		for (File f : file.listFiles()) {
			System.out.println(f.getName() + (f.isDirectory() ? " is a directory" : " is a file") );
		}
	}
	

}
