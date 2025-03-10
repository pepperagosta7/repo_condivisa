package com.example.repo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("standardShippingService")
public class StandardShippingService implements ShippingService{
    
    @Override
    public double calculateShipping(String country, double weight) {
        switch (country){
            case "USA":
                return 10 + weight * 1.5;
            case "Europe":
                return 15 + weight * 2;
            case "Other":
                return 20 + weight * 2.5;
            default:
                return 0;
        }
    }
}
