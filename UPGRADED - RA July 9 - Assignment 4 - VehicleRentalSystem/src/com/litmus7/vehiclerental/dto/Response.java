package com.litmus7.vehiclerental.dto;


public class Response<T> {
    private Integer statusCode;
    private String errorMessage;
    private T data;

    // Constructors
    public Response() {}

    public Response(Integer statusCode, String errorMessage, T data) {
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
        this.data = data;
    }

    // Getters and Setters

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
