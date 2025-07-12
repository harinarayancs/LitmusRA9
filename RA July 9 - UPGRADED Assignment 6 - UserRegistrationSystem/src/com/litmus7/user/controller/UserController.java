package com.litmus7.user.controller;

import com.litmus7.user.constants.AppConstants;
import com.litmus7.user.dto.Response;
import com.litmus7.user.exception.*;
import com.litmus7.user.model.User;
import com.litmus7.user.service.UserService;

public class UserController {

    private UserService userService = new UserService();

    public Response<User> register(String name, int age, String email, String password) {
        try {
            User user = new User(name, age, email, password);
            return userService.registerUser(user);
        } catch (Exception e) {
            return new Response<>(AppConstants.ERROR_CODE, "Registration failed: " + e.getMessage(), null);
        }
    }

    public Response<String> validateName(String name) {
        try {
            return userService.validateName(name);
        } catch (InvalidNameException e) {
            return new Response<>(AppConstants.ERROR_CODE, e.getMessage(), null);
        }
    }

    public Response<String> validateAge(int age) {
        try {
            return userService.validateAge(age);
        } catch (InvalidAgeException e) {
            return new Response<>(AppConstants.ERROR_CODE, e.getMessage(), null);
        }
    }

    public Response<String> validateEmail(String email) {
        try {
            return userService.validateEmail(email);
        } catch (InvalidEmailException e) {
            return new Response<>(AppConstants.ERROR_CODE, e.getMessage(), null);
        }
    }

    public Response<String> validatePassword(String password) {
        try {
            return userService.validatePassword(password);
        } catch (WeakPasswordException e) {
            return new Response<>(AppConstants.ERROR_CODE, e.getMessage(), null);
        }
    }
}
