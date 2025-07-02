package com.litmus7.retail.model;

public class PremiumCustomer implements Discount {
	
    @Override
    public double applyDiscount(double totalAmount) {
        if (totalAmount > 5000) {
            return totalAmount * 0.90; 
        } 
        else {
            return totalAmount * 0.93; 
        }
    }
}
