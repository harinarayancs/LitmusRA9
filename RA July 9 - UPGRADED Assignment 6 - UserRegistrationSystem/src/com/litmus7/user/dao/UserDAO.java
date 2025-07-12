package com.litmus7.user.dao;

import com.litmus7.user.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    void saveUser(User user)throws SQLException;
    User getUserByEmail(String email)throws SQLException;
}
