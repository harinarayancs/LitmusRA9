package com.litmus7.retail.app;

import com.litmus7.retail.model.*;

import java.util.Scanner;

public class RetailApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter customer type (1- Regular, 2- Premium, 3- Wholesale): ");
        int customerType = scanner.nextInt();

        System.out.print("Enter total purchase amount: ");
        double totalAmount = scanner.nextDouble();

        Discount customer = null;
        String customerTypeName = "";

        switch (customerType) {
            case 1:
                customer = new RegularCustomer();
                customerTypeName = "RegularCustomer";
                break;
            case 2:
                customer = new PremiumCustomer();
                customerTypeName = "PremiumCustomer";
                break;
            case 3:
                customer = new WholesaleCustomer();
                customerTypeName = "WholesaleCustomer";
                break;
            default:
                System.out.println("Invalid customer type.");
                return;
        }

        double finalAmount = customer.applyDiscount(totalAmount);
        double discount = totalAmount - finalAmount;

        System.out.println("\nCustomer Type: " + customerTypeName);
        System.out.printf("Original Amount: ₹%.2f\n", totalAmount);
        System.out.printf("Discount Applied: ₹%.2f\n", discount);
        System.out.printf("Final Payable Amount: ₹%.2f\n", finalAmount);

        scanner.close();
    }
}
