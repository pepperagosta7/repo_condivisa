package com.example.repo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("expressShippingService")
public class ExpressShippingService implements ShippingService{
    
    @Override
    public double calculateShipping(String country, double weight) {
        switch (country){
            case "USA":
                return 25 + weight * 3;
            case "Europe":
                return 30 + weight * 3.5;
            case "Other":
                return 40 + weight * 4;
            default:
                return 0;
        }
    }
}
