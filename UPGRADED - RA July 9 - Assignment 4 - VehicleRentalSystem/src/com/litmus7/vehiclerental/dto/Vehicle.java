package com.litmus7.vehiclerental.dto;

/**
 * The general class for all vehicles.
 * Stores common attributes like brand, model, and rental price.
 */
public class Vehicle {
    protected String brand;
    protected String model;
    protected double rentalPricePerDay;
    protected boolean isRented; // Indicates if the vehicle is rented
    
    /**
     * Default constructor.
     */
    public Vehicle() {}
    
    /**
     * Parameterized constructor.
     */
    public Vehicle(String brand, String model, double rentalPricePerDay) {
        this.brand = brand;
        this.model = model;
        this.rentalPricePerDay = rentalPricePerDay;
    }

    /**
     * Displays the vehicle details.
     */
    public void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Rental Price/Day: " + rentalPricePerDay);
    }
    //Getters 
	public String getBrand() { 
		return brand; 
	}
    public String getModel() { 
    	return model; 
    }
    public double getRentalPricePerDay() { 
    	return rentalPricePerDay; 
    }
    public boolean isRented() { 
    	return isRented; 
    }
    public void rent() { 
    	isRented = true; 
    }
    public void returnVehicle() { 
    	isRented = false; 
    }
}
