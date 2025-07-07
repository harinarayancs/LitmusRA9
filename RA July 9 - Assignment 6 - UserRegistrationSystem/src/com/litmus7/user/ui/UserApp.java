package com.litmus7.user.ui;

import com.litmus7.user.controller.UserController;
import com.litmus7.user.exception.*;

import java.util.Scanner;

public class UserApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserController controller = new UserController();

        try {
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            controller.validateName(name);

            System.out.print("Enter Age: ");
            int age = Integer.parseInt(scanner.nextLine());
            controller.validateAge(age);

            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            controller.validateEmail(email);

            System.out.print("Enter Password: ");
            String password = scanner.nextLine();
            controller.validatePassword(password);

            controller.register(name, age, email, password);
            System.out.println("User registered successfully!");

        } catch (InvalidNameException | InvalidAgeException | InvalidEmailException |
                 WeakPasswordException | ValidationException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Age must be a valid number.");
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
