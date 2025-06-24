package com.litmus7.vehiclerental.dto;

/**
 * The general class for all vehicles.
 * Stores common attributes like brand, model, and rental price.
 */
public class Vehicle {
    protected String brand;
    protected String model;
    protected double rentalPricePerDay;
    
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
}
