package com.torrefranca.product_management.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscountStrategyTest {

    @Test
    void shouldApplyStudentDiscount() {

        DiscountStrategy strategy =
                new StudentDiscount();

        assertEquals(
                90,
                strategy.applyDiscount(100)
        );
    }

    @Test
    void shouldApplyHolidayDiscount() {

        DiscountStrategy strategy =
                new HolidayDiscount();

        assertEquals(
                80,
                strategy.applyDiscount(100)
        );
    }

    @Test
    void shouldApplyRegularDiscount() {

        DiscountStrategy strategy =
                new RegularDiscount();

        assertEquals(
                100,
                strategy.applyDiscount(100)
        );
    }
}