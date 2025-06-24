package com.litmus7.vehiclerental.dto;

public class Car extends Vehicle {
    private int numberOfDoors;
    private boolean isAutomatic;

    public Car() {
        super();
    }

    public Car(String brand, String model, double rentalPricePerDay, int numberOfDoors, boolean isAutomatic) {
        super(brand, model, rentalPricePerDay);
        this.numberOfDoors = numberOfDoors;
        this.isAutomatic = isAutomatic;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Automatic: " + isAutomatic);
        System.out.println("----------------------");
    }
}
