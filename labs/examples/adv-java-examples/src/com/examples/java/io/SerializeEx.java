package com.examples.java.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class SerializeEx {

	public static void main(String[] args) {
		Employee e = new Employee();
		e.name = "Reyan Ali";
		e.address = "Phokka Kuan, Ambehta Peer";
		e.uid = 11122333;
		e.id = 101;
		e.skills = Arrays.asList("Java","Spring","Angular","React");

		System.out.println("Serializing Employee...");
		System.out.println("Name: " + e.name);
		System.out.println("Address: " + e.address);
		System.out.println("UID: " + e.uid);
		System.out.println("Id: " + e.id);
		System.out.println("Skill: " + e.skills);

		try {
			FileOutputStream fileOut = new FileOutputStream("./output/employee.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(e);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in ./output/employee.ser");
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
}