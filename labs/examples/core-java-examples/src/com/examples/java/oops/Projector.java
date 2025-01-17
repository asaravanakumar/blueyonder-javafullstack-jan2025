package com.examples.java.oops;

public class Projector {
	
	// properties
	static int id;
	String maker;	// 10 bytes
	String model;	// 8 bytes
	String color;	// 10 bytes
	boolean isON;	// 1 bit
	int resolution; // 4 bytes
	int size;	// 4 bytes
	
	// empty constructor
	public Projector()
	{
		
	}
	
	//  overloaded constructor
	public Projector(String maker, String model, String color, int resolution, int size)
	{
		this.maker = maker;
		this.model = model;
		this.color = color;
		this.resolution = resolution;
		this.size = size;
		id++;
	}
	
	// behaviour => method
	// access modifier returntype methodname(parameter)
	public void switchOn(){
		isON = true;
		System.out.println("Switched ON");
	}
	
	public void switchOff(){
		isON = false;
		System.out.println("Switchec OFF");
	}
	
	public void zoomIn(int units){
		resolution -= units;
		System.out.println("Zoomed IN");
		
	}
	
	public void zoomOut(int units){
		resolution += units;
		System.out.println("Zoomed OUT");
	}
	
	public void printProjectorDetail()
	{
		System.out.println("Projector Id: " + id);
		System.out.println("Maker: " + maker);
		System.out.println("Model: " + model);
		System.out.println("Color: " + color);
		System.out.println("Resolution: " + resolution);
		System.out.println("Size: " + size);
		System.out.println("isON: " + isON);
		System.out.println();
	}
	
	public int getSize()
	{
		return this.size;

	}
}