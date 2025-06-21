package com.litmus7.rental;

import com.litmus7.rental.dto.Car;
import com.litmus7.rental.dto.Bike;

/**
 * VehicleApp, the entry point of the Vehicle Rental System application.
 */
public class VehicleApp {

    /**
     * The main method it creates Car and Bike objects, collects input from the user,and displays them.
     */
    public static void main(String[] args) {

        // Create a Car object using the default constructor.
        Car car = new Car();
        System.out.println("\n--- Enter Car Details ---");
        car.inputDetails();
        System.out.println("--- Displaying Car Details ---");
        car.displayDetails();

        // Create a Bike object using the default constructor.
        Bike bike = new Bike();
        System.out.println("\n--- Enter Bike Details ---");
        bike.inputDetails();
        System.out.println("--- Displaying Bike Details ---");
        bike.displayDetails();
    }
       
}
