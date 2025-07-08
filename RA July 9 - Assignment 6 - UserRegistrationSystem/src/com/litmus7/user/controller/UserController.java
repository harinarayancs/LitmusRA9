package com.litmus7.user.controller;

import com.litmus7.user.dto.User;
import com.litmus7.user.exception.*;
import com.litmus7.user.service.UserService;

public class UserController {


    public void validateName(String name) throws InvalidNameException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidNameException("Name cannot be empty.");
        }
    }

    public void validateAge(int age) throws InvalidAgeException {
        if (age < 18 || age > 60) {
            throw new InvalidAgeException("Age must be between 18 and 60.");
        }
    }

    public void validateEmail(String email) throws InvalidEmailException {
        if (email == null || !(email.contains("@") && email.contains("."))) {
            throw new InvalidEmailException("Email must contain '@' and '.'");
        }
    }

    public void validatePassword(String password) throws WeakPasswordException {
        if (password == null || password.length() < 6) {
            throw new WeakPasswordException("Password must be at least 6 characters.");
        }
    }

    private UserService userService = new UserService();

    public User register(String name, int age, String email, String password)
            throws ValidationException {
        User user = new User(name, age, email, password);
        userService.registerUser(user);
        return user; 
    }

}
