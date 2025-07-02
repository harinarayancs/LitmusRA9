package com.litmus7.retail.model;

public class RegularCustomer implements Discount {

    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount * 0.95; 
    }
}
