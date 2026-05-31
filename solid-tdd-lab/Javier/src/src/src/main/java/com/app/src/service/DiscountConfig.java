package com.app.src.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiscountConfig {

    // DIP: provides the default discount policy as a Spring-managed bean
    @Bean
    public ClothingDiscountPolicy defaultDiscountPolicy() {
        return new NoDiscountPolicy();
    }
}