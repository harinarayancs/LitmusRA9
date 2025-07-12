package com.litmus7.user.ui;

import com.litmus7.user.controller.UserController;
import com.litmus7.user.constants.AppConstants;
import com.litmus7.user.dto.Response;
import com.litmus7.user.model.User;

import java.util.Scanner;

public class UserApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserController controller = new UserController();

        String name;
        int age;
        String email;
        String password;

        while (true) {
            System.out.print("Enter Name: ");
            name = scanner.nextLine();
            Response<String> res = controller.validateName(name);
            if (res.getStatusCode() == AppConstants.SUCCESS_CODE) 
            	break;
            System.out.println(res.getMessage());
        }

        while (true) {
            System.out.print("Enter Age: ");
            try {
                age = Integer.parseInt(scanner.nextLine());
                Response<String> res = controller.validateAge(age);
                if (res.getStatusCode() == AppConstants.SUCCESS_CODE)
                	break;
                System.out.println(res.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Age must be a number.");
            }
        }

        while (true) {
            System.out.print("Enter Email: ");
            email = scanner.nextLine();
            Response<String> res = controller.validateEmail(email);
            if (res.getStatusCode() == AppConstants.SUCCESS_CODE) 
            	break;
            System.out.println(res.getMessage());
        }

        while (true) {
            System.out.print("Enter Password: ");
            password = scanner.nextLine();
            Response<String> res = controller.validatePassword(password);
            if (res.getStatusCode() == AppConstants.SUCCESS_CODE) 
            	break;
            System.out.println(res.getMessage());
        }

        Response<User> regResponse = controller.register(name, age, email, password);
        System.out.println("User Registration Successful");

        scanner.close();
    }
}
