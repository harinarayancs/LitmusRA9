package com.litmus7.product.exception;

public class DataAccessException extends RuntimeException {

    public DataAccessException(String message) {
        super(message);  
    }

    public DataAccessException(String message, Throwable cause) {
        super(message, cause);  
    }
}
