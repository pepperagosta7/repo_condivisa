package com.example.repo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("expressDiscountService")
public class ExpressDiscountService implements DiscountService{

    public double applayDiscount( double orderTotal){
        if (orderTotal < 100) {
            return orderTotal;
        }
        else if (100 <= orderTotal && orderTotal < 200){
            return orderTotal * 0.93;
        }
        else {
            return orderTotal * 0.88;
        }
    }
}
    

