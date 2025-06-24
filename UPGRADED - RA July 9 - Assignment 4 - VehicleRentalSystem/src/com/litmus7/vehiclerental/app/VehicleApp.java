package com.litmus7.vehiclerental.app;

import com.litmus7.vehiclerental.service.VehicleService;
import com.litmus7.vehiclerental.dto.Car;

/**
 * The main class that loads vehicles from file, displays them, and adds a new vehicle.
 */
public class VehicleApp {
    public static void main(String[] args) {
        VehicleService service = new VehicleService();

        System.out.println("Loading vehicles from file...");
        service.loadVehiclesFromFile("C:/Users/harin/Documents/vehicles.txt");

        System.out.println("All Loaded Vehicles:");
        service.displayAllVehicles();

        System.out.println("Adding a new Car...");
        Car newCar = new Car("Hyundai", "Elantra", 60.0, 4, true);
        service.addVehicle(newCar);

        System.out.println("Updated Vehicle List:");
        service.displayAllVehicles();
    }
}
