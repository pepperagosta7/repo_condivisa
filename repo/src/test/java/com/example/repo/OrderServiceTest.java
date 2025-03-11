package com.example.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@ImportAutoConfiguration(exclude = DataSourceAutoConfiguration.class) 
public class OrderServiceTest {
    
    private final DiscountService standaDiscountService = new StandardDiscountService();
    private final DiscountService expressDiscountService = new ExpressDiscountService();
    private final DiscountService customExpressDiscountService = new CustomExpressDiscountService();
    private final ShippingService standardShippingService = new StandardShippingService();
    private final ShippingService expressShippingService = new ExpressShippingService();

    @Test
    public void testStandardDiscountService() {
        OrderService orderService = new OrderService(standardShippingService, expressShippingService, standaDiscountService, expressDiscountService);
        double totalOrderCost = orderService.getTotalOrderCost(100, "standard", "standard", "USA", 10);
        assertEquals(120, totalOrderCost);
    }

    @Test
    public void testExpressDiscountService() {
        OrderService orderService = new OrderService(standardShippingService, expressShippingService, standaDiscountService, expressDiscountService);
        double totalOrderCost = orderService.getTotalOrderCost(100, "express", "express", "USA", 10);
        assertEquals(148, totalOrderCost);
    }

    @Test
    public void testCustomExpressDiscountService() {
        OrderService orderService = new OrderService(standardShippingService, expressShippingService, standaDiscountService, customExpressDiscountService);
        double totalOrderCost = orderService.getTotalOrderCost(100, "express", "express", "USA", 10);
        assertEquals(140, totalOrderCost);
    }

    @Test
    public void testStandardShippingService() {
        OrderService orderService = new OrderService(standardShippingService, expressShippingService, standaDiscountService, expressDiscountService);
        double totalOrderCost = orderService.getTotalOrderCost(100, "standard", "standard", "USA", 10);
        assertEquals(120, totalOrderCost);
    }

    @Test
    public void testExpressShippingService() {
        OrderService orderService = new OrderService(standardShippingService, expressShippingService, standaDiscountService, expressDiscountService);
        double totalOrderCost = orderService.getTotalOrderCost(100, "express", "express", "USA", 10);
        assertEquals(148, totalOrderCost);
    }
}
