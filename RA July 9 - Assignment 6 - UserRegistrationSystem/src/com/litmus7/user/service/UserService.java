package com.litmus7.user.service;

import com.litmus7.user.dao.UserDAO;
import com.litmus7.user.dao.UserDAOImpl;
import com.litmus7.user.dto.User;
import com.litmus7.user.exception.ValidationException;

public class UserService {

    private UserDAO userDAO = new UserDAOImpl();

    public void registerUser(User user) throws ValidationException {
        if (userDAO.getUserByEmail(user.getEmail()) != null) {
            throw new ValidationException("Email already registered. Try logging in or use another email.");
        }

        try {
            userDAO.saveUser(user);
        } catch (Exception e) {
            throw new ValidationException("Registration failed due to a system error.");
        }
    }

}
