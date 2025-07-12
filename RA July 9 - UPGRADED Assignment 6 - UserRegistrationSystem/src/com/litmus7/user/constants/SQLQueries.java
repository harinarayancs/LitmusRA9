package com.litmus7.user.constants;

public class SQLQueries {

    public static final String INSERT_USER =
        "INSERT INTO users (name, age, email, password) VALUES (?, ?, ?, ?)";

    public static final String SELECT_USER_BY_EMAIL =
        "SELECT id, name, age, email, password FROM users WHERE email = ?";

    public static final String SELECT_ALL_USERS =
        "SELECT id, name, age, email, password FROM users";
}
