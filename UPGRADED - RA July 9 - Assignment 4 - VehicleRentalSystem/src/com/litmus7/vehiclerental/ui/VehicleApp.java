package com.litmus7.vehiclerental.ui;

import java.util.List;
import java.util.Scanner;
import com.litmus7.vehiclerental.controller.VehicleController;
import com.litmus7.vehiclerental.dto.Response;
import com.litmus7.vehiclerental.dto.Vehicle;

public class VehicleApp {
    public static void main(String[] args) {
        VehicleController controller = new VehicleController();
        Response response = controller.loadVehiclesFromFile("vehicles.txt");
        if (response.getStatusCode() == 200) {
            System.out.println("Vehicles Loaded successfully!");
        } else {
            System.out.println("Error loading Vehicles" + response.getErrorMessage());
        }
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nVehicle Rental System");
            System.out.println("1.Display All Vehicles");
            System.out.println("2.Display Available Vehicles");
            System.out.println("3.Add New Vehicle");
            System.out.println("4.Rent a Vehicle");
            System.out.println("5.Return a Vehicle");
            System.out.println("6.Calculate Rental Price for rented Vehicles");
            System.out.println("0.Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("All Vehicles : ");
                    List<Vehicle> allVehicles = controller.getAllVehicles();
                    for (Vehicle v : allVehicles) {
                        v.displayDetails();
                    }
                    break;

                case 2:
                    System.out.println("\nAvailable Vehicles:");
                    List<Vehicle> availableVehicles = controller.getAvailableVehicles();
                    if (availableVehicles.isEmpty()) {
                        System.out.println("No vehicles available.");
                    } else {
                        for (Vehicle v : availableVehicles) {
                            v.displayDetails();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Vehicle type (Car or Bike): ");
                    String type = sc.nextLine();

                    if (type.equalsIgnoreCase("Car")) {
                        System.out.print("Brand: ");
                        String brand = sc.nextLine();
                        System.out.print("Model: ");
                        String model = sc.nextLine();
                        System.out.print("Rental Price per Day: ");
                        double price = Double.parseDouble(sc.nextLine());
                        System.out.print("Number of Doors: ");
                        int doors = Integer.parseInt(sc.nextLine());
                        System.out.print("Is Automatic (true/false): ");
                        boolean isAuto = Boolean.parseBoolean(sc.nextLine());

                        controller.addCar(brand, model, price, doors, isAuto);
                        System.out.println("Car added successfully!");
                    } else if (type.equalsIgnoreCase("Bike")) {
                        System.out.print("Brand: ");
                        String brand = sc.nextLine();
                        System.out.print("Model: ");
                        String model = sc.nextLine();
                        System.out.print("Rental Price per Day: ");
                        double price = Double.parseDouble(sc.nextLine());
                        System.out.print("Has Gear (true/false): ");
                        boolean hasGear = Boolean.parseBoolean(sc.nextLine());
                        System.out.print("Engine Capacity (cc): ");
                        int capacity = Integer.parseInt(sc.nextLine());

                        controller.addBike(brand, model, price, hasGear, capacity);
                        System.out.println("Bike added successfully!");
                    } else {
                        System.out.println("Invalid Vehicle Type!!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Brand: ");
                    String brand = sc.nextLine();
                    System.out.print("Enter Model: ");
                    String model = sc.nextLine();
                    Response rentResponse = controller.rentVehicle(brand, model);
                    if (rentResponse.getStatusCode() == 200) {
                        System.out.println("Vehicle rented successfully!");
                    } else {
                        System.out.println("Error renting vehicle: " + rentResponse.getErrorMessage());
                    }
                    break;

                case 5:
                    System.out.print("Enter Brand: ");
                    String returnBrand = sc.nextLine();
                    System.out.print("Enter Model: ");
                    String returnModel = sc.nextLine();
                    Response returnResponse = controller.returnVehicle(returnBrand, returnModel);
                    if (returnResponse.getStatusCode() == 200) {
                        System.out.println("Vehicle returned successfully!");
                    } else {
                        System.out.println("Error returning vehicle: " + returnResponse.getErrorMessage());
                    }
                    break;

                case 6:
                    double total = controller.calculateRevenue();
                    System.out.println("Total Rental Price of Rented Vehicles : " + total);
                    break;

                case 0:
                    exit = true;
                    System.out.println("Exiting..Thank you!");
                    break;

                default:
                    System.out.println("Invalid entry!");
            }
        }

        sc.close();
    }
}