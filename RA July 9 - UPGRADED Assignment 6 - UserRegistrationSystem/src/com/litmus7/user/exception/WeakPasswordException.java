package com.litmus7.user.exception;

public class WeakPasswordException extends Exception {
    public WeakPasswordException(String message) {
        super(message);
    }
}