package com.examples.java.io;

import java.util.List;

public class Employee implements java.io.Serializable {

	private static final long serialVersionUID = -8806552347539859660L;

	public String name;
	public String address;
	public transient int uid; // aadhaar
	public int id;
	public List<String> skills;

	public void mailCheck() {
		System.out.println("Mailing a check to " + name + " " + address);
	}

	public String toString() {
		return "Name: " + name +", Address: " + address + ", UID: " + uid + ", ID: " + id + ", Skills: " + skills;
	}
}