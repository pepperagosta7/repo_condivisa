package com.example.repo;

public class CustomExpressDiscountService implements DiscountService{

    public double applayDiscount( double orderTotal){
        if (orderTotal < 100) {
            return orderTotal * 0.90;
        }
        else if (100 <= orderTotal && orderTotal < 200){
            return orderTotal * 0.85;
        }
        else {
            return orderTotal * 0.80;
        }
    }

}
