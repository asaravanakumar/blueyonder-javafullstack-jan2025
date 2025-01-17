package com.examples.java.oops;

/**
 * Models contractor details
 */
public class Contractor extends Person {
	
	private int contractorId;
	private int duration;	// in months
	private double cost;	// in rupees
	
	public Contractor(int contractorId, String name, int age, String gender, int duration, double cost)
	{
		super(name, age, gender);
		this.contractorId = contractorId;
		this.duration = duration;
		this.cost = cost;
	}
	
	public int getContractorId() {
		return contractorId;
	}

	public void setContractorId(int contractorId) {
		this.contractorId = contractorId;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public void printDetails() {
		System.out.println("Print contractor details");
		System.out.println("Contractor Id: " + this.getContractorId());
		System.out.println("Name: " + this.getName());
		System.out.println("Age: " + this.getAge());
		System.out.println("Gender: " + this.getGender());		
		System.out.println("Duration: " + this.getDuration());
		System.out.println("Cost: " + this.getCost());	
		System.out.println();
	}

}
