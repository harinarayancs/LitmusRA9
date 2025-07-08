package com.litmus7.user.dao;

import com.litmus7.user.dto.User;
import com.litmus7.user.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    
    public void saveUser(User user) {
        String query = "INSERT INTO users (name, age, email, password) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, user.getName());
            stmt.setInt(2, user.getAge());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.executeUpdate();

            System.out.println("User saved to database.");

        } catch (Exception e) {
            System.out.println("Error while saving user:");
            e.printStackTrace();
        }
    }

    public User getUserByEmail(String email) {
        String query = "SELECT * FROM users WHERE email = ?";
        User user = null;

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User(); 
                user.setEmail(rs.getString("email"));
            }

        } catch (Exception e) {
            System.out.println("Error while fetching user by email:");
            e.printStackTrace();
        }

        return user;
    }
}
