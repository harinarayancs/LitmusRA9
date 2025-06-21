package com.litmus7.rental.dto;

import java.util.Scanner;

/**
 * Represents a class bike, extending from class Vehicle.
 */
public class Bike extends Vehicle {
	private boolean hasGear;
	private int engineCapacity;


	/**
	 * Default Constructor of bike.
	 */
	public Bike() {
		super();
		hasGear = false;
		engineCapacity = 000;
	}

	/**
	 * Parameterized constructor for bike.
	 */
	public Bike(String brand, String model, double rentalPricePerDay, boolean hasGear, int engineCapacity) {
		super(brand, model, rentalPricePerDay);
		this.hasGear = hasGear;
		this.engineCapacity = engineCapacity;
	}

	/**
	 * Accepts user input for bike.
	 */
	@Override
	public void inputDetails() {
		super.inputDetails();
		System.out.print("Does it have gears (true/false)? ");
		hasGear = sc.nextBoolean();
		System.out.print("Enter engine capacity (cc):");
		engineCapacity = sc.nextInt();
	}

	/**
	 * Displays details of bike.
	 */
	@Override
	public void displayDetails() {
		super.displayDetails();
		System.out.println("Has Gear:" + hasGear);
		System.out.println("Engine Capacity:" + engineCapacity + " cc");
	}
}
