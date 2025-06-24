package com.litmus7.vehiclerental.dto;

public class Bike extends Vehicle {
    private boolean hasGear;
    private int engineCapacity;

    public Bike() {
        super();
    }

    public Bike(String brand, String model, double rentalPricePerDay, boolean hasGear, int engineCapacity) {
        super(brand, model, rentalPricePerDay);
        this.hasGear = hasGear;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Has Gear: " + hasGear);
        System.out.println("Engine Capacity: " + engineCapacity + "cc");
        System.out.println("----------------------");
    }
}
