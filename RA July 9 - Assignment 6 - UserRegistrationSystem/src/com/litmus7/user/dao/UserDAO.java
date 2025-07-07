package com.litmus7.user.dao;

import com.litmus7.user.dto.User;
import java.util.List;

public interface UserDAO {
    void saveUser(User user);
    User getUserByEmail(String email);
}
