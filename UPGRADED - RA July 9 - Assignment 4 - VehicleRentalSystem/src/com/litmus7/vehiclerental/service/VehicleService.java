package com.litmus7.vehiclerental.service;

import java.util.ArrayList;
import java.util.List;

import com.litmus7.vehiclerental.dao.VehicleDAO;
import com.litmus7.vehiclerental.dto.Vehicle;
import com.litmus7.vehiclerental.exception.VehicleDataAccessException;
import com.litmus7.vehiclerental.exception.VehicleServiceException;

/**
 * Service layer for managing business logic related to vehicles.
 */
public class VehicleService {
    private List<Vehicle> vehicles;
    private VehicleDAO dao;

    public VehicleService() {
        this.vehicles = new ArrayList<>();
        this.dao = new VehicleDAO();
    }

    /**
     * Loads vehicles from the given file and adds them to the internal list.
     *
     * @param filepath path to input file
     * @return list of newly loaded vehicles
     * @throws VehicleServiceException if file loading fails
     */
    public List<Vehicle> loadVehicles(String filepath) throws VehicleServiceException {
        try {
            List<Vehicle> loaded = dao.loadVehiclesFromFile(filepath);
            vehicles.addAll(loaded);
            return loaded;
        } catch (VehicleDataAccessException e) {
            throw new VehicleServiceException("Failed to load vehicles!", e);
        }
    }

    /**
     * Adds a new vehicle to the in-memory list.
     *
     * @param vehicle the vehicle to be added
     */
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    /**
     * Displays all vehicles in the system.
     */
    public void displayAllVehicles() {
        for (Vehicle v : vehicles) {
            v.displayDetails();
        }
    }

    /**
     * Displays only available (non-rented) vehicles.
     */
    public void displayAvailableVehicles() {
        for (Vehicle v : vehicles) {
            if (!v.isRented()) {
                v.displayDetails();
            }
        }
    }

    /**
     * Marks a vehicle as rented if it matches brand and model.
     */
    public void rentVehicle(String brand, String model) throws VehicleServiceException {
        for (Vehicle v : vehicles) {
            if (!v.isRented() &&
                v.getBrand().equalsIgnoreCase(brand) &&
                v.getModel().equalsIgnoreCase(model)) {
                v.rent();
                return;
            }
        }
        throw new VehicleServiceException("Vehicle is not currently available!");
    }

    /**
     * Marks a rented vehicle as returned.
     *
     * @throws VehicleServiceException if the vehicle is not found or not rented
     */
    public void returnVehicle(String brand, String model) throws VehicleServiceException {
        for (Vehicle v : vehicles) {
            if (v.isRented() &&
                v.getBrand().equalsIgnoreCase(brand) &&
                v.getModel().equalsIgnoreCase(model)) {
                v.returnVehicle();
                return;
            }
        }
        throw new VehicleServiceException("Vehicle not found or not currently rented!");
    }

    /**
     * Calculates total revenue from all currently rented vehicles.
     */
    public double calculateTotalRentalPriceForRentedVehicles() {
        double price = 0;
        for (Vehicle v : vehicles) {
            if (v.isRented()) {
                price += v.getRentalPricePerDay();
            }
        }
        return price;
    }

    /**
     * Returns the full list of vehicles.
     */
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * Returns only available (non-rented) vehicles.
     */
    public List<Vehicle> getAvailableVehicles() {
        List<Vehicle> available = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (!v.isRented()) {
                available.add(v);
            }
        }
        return available;
    }
}
