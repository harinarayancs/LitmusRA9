package com.litmus7.rental.dto;

import java.util.Scanner;

/**
 * Represents a class car, extending from class vehicle.
 */
public class Car extends Vehicle {
    private int numberOfDoors;
    private boolean isAutomatic;

    /**
     * Default constructor for car.
     */
    public Car() {
        super();
        numberOfDoors = 4;
        isAutomatic = false;
    }

    /**
     * Parameterized constructor for car.
     *
     * @param brand - the car brand
     * @param model - the car model
     * @param rentalPricePerDay - the rental cost per day
     * @param numberOfDoors - number of doors in the car
     * @param isAutomatic - whether the car has automatic transmission
     */
    public Car(String brand, String model, double rentalPricePerDay, int numberOfDoors, boolean isAutomatic) {
        super(brand, model, rentalPricePerDay);
        this.numberOfDoors = numberOfDoors;
        this.isAutomatic = isAutomatic;
    }

    /**
     * Accepts user input of car details.
     */
    @Override
    public void inputDetails() {
        super.inputDetails();
        System.out.print("Enter number of doors: ");
        numberOfDoors = sc.nextInt();
        System.out.print("Is it automatic (true/false)? ");
        isAutomatic = sc.nextBoolean();
    }

    /**
     * Displays details of car.
     */
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Automatic: " + isAutomatic);
    }
}
