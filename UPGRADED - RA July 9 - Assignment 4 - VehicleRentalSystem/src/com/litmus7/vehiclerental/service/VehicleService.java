package com.litmus7.vehiclerental.service;

import com.litmus7.vehiclerental.dto.*;
import java.io.*;
import java.util.*;

public class VehicleService {
    private List<Vehicle> vehicles = new ArrayList<>();

    public void loadVehiclesFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String type = parts[0];

                if (type.equalsIgnoreCase("Car")) {
                    String brand = parts[1];
                    String model = parts[2];
                    double price = Double.parseDouble(parts[3]);
                    int doors = Integer.parseInt(parts[4]);
                    boolean isAuto = Boolean.parseBoolean(parts[5]);
                    vehicles.add(new Car(brand, model, price, doors, isAuto));
                } else if (type.equalsIgnoreCase("Bike")) {
                    String brand = parts[1];
                    String model = parts[2];
                    double price = Double.parseDouble(parts[3]);
                    boolean hasGear = Boolean.parseBoolean(parts[4]);
                    int engine = Integer.parseInt(parts[5]);
                    vehicles.add(new Bike(brand, model, price, hasGear, engine));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public void displayAllVehicles() {
        for (Vehicle v : vehicles) {
            v.displayDetails();
        }
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
}
