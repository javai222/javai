package com.app.src.service;

import com.app.src.entity.ClothingItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClothingDiscountServiceTest {

    @Test
    void shouldApplyInjectedDiscountPolicy() {
        ClothingDiscountPolicy mockPolicy = mock(ClothingDiscountPolicy.class);
        when(mockPolicy.apply(any())).thenReturn(80.0);
        ClothingDiscountService service = new ClothingDiscountService(mockPolicy);
        assertEquals(80.0, service.getDiscountedPrice(new ClothingItem()));
    }

    @Test
    void shouldReturnDiscountDescription() {
        ClothingDiscountPolicy mockPolicy = mock(ClothingDiscountPolicy.class);
        when(mockPolicy.getDescription()).thenReturn("20% off all items");
        ClothingDiscountService service = new ClothingDiscountService(mockPolicy);
        assertEquals("20% off all items", service.getDiscountDescription());
    }

    @Test
    void shouldUseNewPolicyAfterSwap() {
        ClothingDiscountPolicy original = mock(ClothingDiscountPolicy.class);
        ClothingDiscountPolicy swapped = mock(ClothingDiscountPolicy.class);
        when(swapped.apply(any())).thenReturn(50.0);
        ClothingDiscountService service = new ClothingDiscountService(original);
        service.setDiscountPolicy(swapped);
        assertEquals(50.0, service.getDiscountedPrice(new ClothingItem()));
        verify(swapped).apply(any());
    }

    @Test
    void shouldProduceDifferentResultsForDifferentPolicies() {
        // LSP + OCP proof: both implementations honor the same interface contract
        ClothingItem item = new ClothingItem();
        item.setPrice(1000.00);

        ClothingDiscountPolicy percentage = new PercentageDiscountPolicy(10);
        ClothingDiscountPolicy seasonal   = new SeasonalSalePolicy("Summer", 20);

        ClothingDiscountService service1 = new ClothingDiscountService(percentage);
        ClothingDiscountService service2 = new ClothingDiscountService(seasonal);

        // Both work correctly through the same interface, no if/else needed
        assertEquals(900.00, service1.getDiscountedPrice(item), 0.01);
        assertEquals(800.00, service2.getDiscountedPrice(item), 0.01);
    }
}