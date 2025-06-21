package com.litmus7.rental.dto;

import java.util.Scanner;

/**
 * Represents a class vehicle with common attributes such as brand, model, and rental price.
 */
public class Vehicle {
    private String brand;
    private String model;
    private double rentalPricePerDay;


    Scanner sc = new Scanner(System.in);

    /**
     * Default constructor for vehicle.
     */
    public Vehicle() {
        brand = "NotAssigned";
        model = "Not Assigned";
        rentalPricePerDay = 0.0;
    }

    /**
     * Parameterized constructor for vehicle.
     *
     * @param brand - the vehicle brand
     * @param model - the vehicle model
     * @param rentalPricePerDay - the rental cost per day
     */
    public Vehicle(String brand, String model, double rentalPricePerDay) {
        this.brand = brand;
        this.model = model;
        this.rentalPricePerDay = rentalPricePerDay;
    }

    /**
     * Accepts input from user.
     */

    public void inputDetails() {
        System.out.print("Enter brand:");
        brand = sc.nextLine();  

        System.out.print("Enter model:");
        model = sc.nextLine();

        System.out.print("Enter rental price per day:");
        rentalPricePerDay = sc.nextDouble();
        sc.nextLine(); 
    }

    /**
     * Displays details.
     */
    public void displayDetails() {
        System.out.println("Brand:" + brand);
        System.out.println("Model:" + model);
        System.out.println("Rental Price/Day:" + rentalPricePerDay);
    }
}
