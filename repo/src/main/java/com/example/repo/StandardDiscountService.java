package com.example.repo;

public class StandardDiscountService implements DiscountService{
    
    @Override
    public double applayDiscount( double orderTotal){
        if (orderTotal < 100) {
            return orderTotal;
        }
        else if (100 <= orderTotal && orderTotal < 200){
            return orderTotal * 0.95;
        }
        else {
            return orderTotal * 0.9;
        }
    }
}
