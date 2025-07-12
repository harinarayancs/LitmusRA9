package com.litmus7.user.dao;

import com.litmus7.user.constants.SQLQueries;
import com.litmus7.user.model.User;
import com.litmus7.user.util.DBUtil;

import java.sql.*;

public class UserDAOImpl implements UserDAO {

    public void saveUser(User user) throws SQLException{
        try (Connection connection = DBUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQLQueries.INSERT_USER)) {

            stmt.setString(1, user.getName());
            stmt.setInt(2, user.getAge());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.executeUpdate();

            System.out.println("User saved to database.");
        }

     
    }

    public User getUserByEmail(String email) throws SQLException{
        User user = null;

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQLQueries.SELECT_USER_BY_EMAIL)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setEmail(rs.getString("email"));
            }
        }
        

    
        return user;
    }
  
    }

