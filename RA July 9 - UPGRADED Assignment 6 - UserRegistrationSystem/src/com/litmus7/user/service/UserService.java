package com.litmus7.user.service;

import com.litmus7.user.constants.AppConstants;
import com.litmus7.user.dao.UserDAO;
import com.litmus7.user.dao.UserDAOImpl;
import com.litmus7.user.dto.Response;
import com.litmus7.user.exception.*;
import com.litmus7.user.model.User;

import java.sql.SQLException;
import java.util.regex.Pattern;

public class UserService {

	private UserDAO userDAO = new UserDAOImpl();

	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");
	private static final Pattern PASSWORD_PATTERN = Pattern.compile("^.{6,}$");

	public Response<String> validateName(String name) throws InvalidNameException {
		if (name == null || name.trim().isEmpty()) {
			throw new InvalidNameException("Username must not be empty.");		
		}
	    return new Response<>(AppConstants.SUCCESS_CODE, AppConstants.SUCCESS_MESSAGE, null);

		}

	public Response<String> validateAge(int age)throws InvalidAgeException {
		if (age < AppConstants.MIN_AGE || age > AppConstants.MAX_AGE) {
			throw new InvalidAgeException("Age must be between " + AppConstants.MIN_AGE + " and " + AppConstants.MAX_AGE + ".");
	}
	    return new Response<>(AppConstants.SUCCESS_CODE, AppConstants.SUCCESS_MESSAGE, null);
	}

		
	public Response<String> validateEmail(String email) throws InvalidEmailException{
		try {
			if (userDAO.getUserByEmail(email) != null) {
				return new Response<>(AppConstants.ERROR_CODE,
						"Email already registered. Try logging in or use another email.", null);
			}
		} catch (SQLException e) {
			return new Response<>(AppConstants.ERROR_CODE, "System error while validating email.", null);
		}

		if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
			throw new InvalidEmailException("Invalid email format.");
		}
		return new Response<>(AppConstants.SUCCESS_CODE, AppConstants.SUCCESS_MESSAGE, null);
	}


    public Response<String> validatePassword(String password) throws WeakPasswordException {
        if (password == null || !PASSWORD_PATTERN.matcher(password).matches()) {
            throw new WeakPasswordException("Password must be at least 6 characters.");
        }
        return new Response<>(AppConstants.SUCCESS_CODE, AppConstants.SUCCESS_MESSAGE, null);

    }
	public Response<User> registerUser(User user) {

		try {
			userDAO.saveUser(user);
			return new Response<>(AppConstants.SUCCESS_CODE, AppConstants.SUCCESS_MESSAGE, user);
		} catch (SQLException e) {
			return new Response<>(AppConstants.ERROR_CODE, "Registration failed due to a system error.", null);
		}
	}
}
