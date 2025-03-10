package com.example.repo;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Qualifier;

@Service
public class OrderService {
    private final ShippingService standardShippingService;
    private final ShippingService expressShippingService;
    private final DiscountService standardDiscountService;
    private final DiscountService expressDiscountService;

    public OrderService(@Qualifier ("standardShippingService") ShippingService standardShippingService,
                        @Qualifier ("expressShippingService") ShippingService expressShippingService,
                        @Qualifier ( "standardDiscountService") DiscountService standardDiscountService,
                        @Qualifier ( "expressDiscountService") DiscountService expressDiscountService){
        this.standardShippingService = standardShippingService;
        this.expressShippingService = expressShippingService;
        this.standardDiscountService = standardDiscountService;
        this.expressDiscountService = expressDiscountService;
    }

    public double getTotalOrderCost(double orderTotal, String discountType, String shippingType, String country, double weight) {
        DiscountService discountService;
        ShippingService shippingService;

        switch (discountType.toLowerCase()){
            case "standard":
                discountService = standardDiscountService;
                break;
            case "express":
                discountService = expressDiscountService;
                break;
            default:
                throw new IllegalArgumentException("Invalid discount type" + discountType);
        }

        switch (shippingType.toLowerCase()){
            case "standard":
                shippingService = standardShippingService;
                break;
            case "express":
                shippingService = expressShippingService;
                break;
            default:
                throw new IllegalArgumentException("Invalid shipping type" + shippingType);
        }

        double discountPrice = discountService.applayDiscount(orderTotal);
        double shippingCost = shippingService.calculateShipping(country, weight);
        return discountPrice + shippingCost;
    }

}
