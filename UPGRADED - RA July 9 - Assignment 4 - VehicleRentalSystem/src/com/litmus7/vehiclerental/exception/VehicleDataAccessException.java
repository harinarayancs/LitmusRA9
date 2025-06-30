package com.litmus7.vehiclerental.exception;

public class VehicleDataAccessException extends Exception {
	public VehicleDataAccessException(String message,Throwable cause) {
		super(message,cause);
	}
	public VehicleDataAccessException(String message) {
		super(message);
	}
}