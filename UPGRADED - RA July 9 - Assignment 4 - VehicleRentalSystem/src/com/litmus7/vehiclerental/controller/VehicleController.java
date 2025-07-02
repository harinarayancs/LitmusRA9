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
    public Response<List<Vehicle>> loadVehiclesFromFile(String filepath) {
        Response<List<Vehicle>> response = new Response<>();
        try {
            List<Vehicle> loadedVehicles = service.loadVehicles(filepath);
            response.setStatusCode(SUCCESS_STATUS_CODE);
            response.setData(loadedVehicles);
        } catch (VehicleServiceException e) {
            response.setStatusCode(ERROR_STATUS_CODE);
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }

    // Adds a generic vehicle
    public Response<String> addVehicle(Vehicle vehicle) {
        Response<String> response = new Response<>();
        if (vehicle == null) {
            response.setStatusCode(ERROR_STATUS_CODE);
            response.setErrorMessage("Vehicle cannot be null.");
            return response;
        }
        service.addVehicle(vehicle);
        response.setStatusCode(SUCCESS_STATUS_CODE);
        response.setData("Vehicle added successfully");
        return response;
    }

    // Returns all vehicles
    public Response<List<Vehicle>> getAllVehicles() {
        Response<List<Vehicle>> response = new Response<>();
        response.setStatusCode(SUCCESS_STATUS_CODE);
        response.setData(service.getVehicles());
        return response;
    }

    // Returns only available vehicles
    public Response<List<Vehicle>> getAvailableVehicles() {
        Response<List<Vehicle>> response = new Response<>();
        response.setStatusCode(SUCCESS_STATUS_CODE);
        response.setData(service.getAvailableVehicles());
        return response;
    }

    // Adds a car using user input
    public Response<String> addCar(String brand, String model, double price, int doors, boolean isAuto) {
        Vehicle car = new Car(brand, model, price, doors, isAuto);
        return addVehicle(car);
    }

    // Adds a bike using user input
    public Response<String> addBike(String brand, String model, double price, boolean hasGear, int capacity) {
        Vehicle bike = new Bike(brand, model, price, hasGear, capacity);
        return addVehicle(bike);
    }

    // Rents a vehicle
    public Response<String> rentVehicle(String brand, String model) {
        Response<String> response = new Response<>();
        try {
            service.rentVehicle(brand, model);
            response.setStatusCode(SUCCESS_STATUS_CODE);
            response.setData("Vehicle rented successfully");
        } catch (VehicleServiceException e) {
            response.setStatusCode(ERROR_STATUS_CODE);
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }

    // Returns a rented vehicle
    public Response<String> returnVehicle(String brand, String model) {
        Response<String> response = new Response<>();
        try {
            service.returnVehicle(brand, model);
            response.setStatusCode(SUCCESS_STATUS_CODE);
            response.setData("Vehicle returned successfully");
        } catch (VehicleServiceException e) {
            response.setStatusCode(ERROR_STATUS_CODE);
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }

    // Calculates revenue
    public Response<Double> calculateRevenue() {
        Response<Double> response = new Response<>();
        double revenue = service.calculateTotalRentalPriceForRentedVehicles();
        response.setStatusCode(SUCCESS_STATUS_CODE);
        response.setData(revenue);
        return response;
    }
}
