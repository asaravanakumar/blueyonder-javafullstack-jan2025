package com.examples.java.oops;

public class ProjectorDemo {
	
	public static void main(String[] args)
	{
		// Object Declaration
		Projector epson;
		//Projector.id = 10;
		//Projector.printProjectorDetail();
		
		// Instantiation -> Construction & Initialization with default constructor
//		epson = new Projector();
//		System.out.println(epson);
//		epson.printProjectorDetail();

		// Instantiation -> Construction & Initialization with overloaded constructor
		epson = new Projector("Epson","E105","White",4000,10);
		epson.printProjectorDetail();

		// update object state
		epson.switchOn();
		epson.zoomIn(100);
		epson.zoomOut(50);
		epson.switchOff();
		epson.printProjectorDetail();

		// Creation of another projector object
		Projector samsung = new Projector("Samsung","S105","Black",3000,20);
		samsung.printProjectorDetail();

		samsung.switchOn();
		samsung.zoomIn(200);
		samsung.zoomOut(100);
		samsung.switchOff();
		samsung.printProjectorDetail();

		// Pass by Value vs Pass by Reference
		String message = "Hello";
		print(message);	// pass by value
		System.out.println(message); // Hello
		System.out.println();
		print(samsung); // pass by reference
		System.out.println();
		samsung.printProjectorDetail();
	}
	
	public static void print(String message)
	{
		message = "Hello World";
		System.out.println("Print method called with pass by value: " + message); // Hello World
	}

	public static void print(Projector proj)
	{
		System.out.println("Print method called with pass by reference: " + proj);
		proj.model = "K897";
		proj.printProjectorDetail();
	}
}
