package com.litmus7.product.exception;

public class ProductExistException extends RuntimeException{
	public ProductExistException(String message) {
		super(message);
	}
	public ProductExistException(String message, Throwable cause){
		super(message,cause);
	}
	
}
