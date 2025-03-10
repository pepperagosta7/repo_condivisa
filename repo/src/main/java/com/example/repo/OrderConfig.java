package com.example.repo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {
    @Bean
    public DiscountService expressDiscountService() {
        return new CustomExpressDiscountService();
    }
}
