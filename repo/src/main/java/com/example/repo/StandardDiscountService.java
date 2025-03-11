package com.example.repo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("standardDiscountService")
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
