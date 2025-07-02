package com.litmus7.retail.model;

public class WholesaleCustomer implements Discount {

    @Override
    public double applyDiscount(double totalAmount) {
        if (totalAmount > 10000) {
            return totalAmount * 0.85; // 15% discount
        } else {
            return totalAmount * 0.90; // 10% discount
        }
    }
}
