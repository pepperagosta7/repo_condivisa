package com.example.repo;

public class ExpressDiscountService implements DiscountService{

    public double applayDiscount( double orderTotal){
        if (orderTotal < 100) {
            return orderTotal;
        }
        else if (100 < orderTotal && orderTotal < 200){
            return orderTotal * 0.93;
        }
        else {
            return orderTotal * 0.88;
        }
    }
}
    

