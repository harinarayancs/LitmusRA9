package com.litmus7.vehiclerental.controller;

import java.util.List;
import com.litmus7.vehiclerental.dto.Bike;
import com.litmus7.vehiclerental.dto.Car;
import com.litmus7.vehiclerental.dto.Response;
import com.litmus7.vehiclerental.dto.Vehicle;
import com.litmus7.vehiclerental.exception.VehicleServiceException;
import com.litmus7.vehiclerental.service.VehicleService;

public class VehicleController {

    private VehicleService service;
    private final int SUCCESS_STATUS_CODE = 200;
    private final int ERROR_STATUS_CODE = 500;

    // Constructors
    public VehicleController() {
        this.service = new VehicleService();
    }

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    // Loads vehicle data from a file
    public Response loadVehiclesFromFile(String filepath) {
        Response response = new Response();
        try {
            List<Vehicle> loadedVehicles = service.loadVehicles(filepath);
            response.setStatusCode(SUCCESS_STATUS_CODE);
            response.setVehicles(loadedVehicles);
        } catch (VehicleServiceException e) {
            response.setStatusCode(ERROR_STATUS_CODE);
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }

    // Adds a generic vehicle
    public Response addVehicle(Vehicle vehicle) {
        Response response = new Response();
        if (vehicle == null) {
            response.setStatusCode(ERROR_STATUS_CODE);
            response.setErrorMessage("Vehicle cannot be null.");
            return response;
        }
        service.addVehicle(vehicle);
        response.setStatusCode(SUCCESS_STATUS_CODE);
        return response;
    }

    // Returns all vehicles
    public List<Vehicle> getAllVehicles() {
        return service.getVehicles();
    }

    // Returns only available vehicles
    public List<Vehicle> getAvailableVehicles() {
        return service.getAvailableVehicles();
    }

    // Adds a car using user input
    public Response addCar(String brand, String model, double price, int doors, boolean isAuto) {
        Vehicle car = new Car(brand, model, price, doors, isAuto);
        return addVehicle(car);
    }

    // Adds a bike using user input
    public Response addBike(String brand, String model, double price, boolean hasGear, int capacity) {
        Vehicle bike = new Bike(brand, model, price, hasGear, capacity);
        return addVehicle(bike);
    }

    // Rents a vehicle
    public Response rentVehicle(String brand, String model) {
        Response response = new Response();
        try {
            service.rentVehicle(brand, model);
            response.setStatusCode(SUCCESS_STATUS_CODE);
        } catch (VehicleServiceException e) {
            response.setStatusCode(ERROR_STATUS_CODE);
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }

    // Returns a rented vehicle
    public Response returnVehicle(String brand, String model) {
        Response response = new Response();
        try {
            service.returnVehicle(brand, model);
            response.setStatusCode(SUCCESS_STATUS_CODE);
        } catch (VehicleServiceException e) {
            response.setStatusCode(ERROR_STATUS_CODE);
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }

    // Calculates revenue
    public double calculateRevenue() {
        return service.calculateTotalRentalPriceForRentedVehicles();
    }
}
