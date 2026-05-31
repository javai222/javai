package com.silva.productsact.product_app.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentFormatTest {

    @Test
    public void testFormatToUSD() {
        // Test normal conversion
        String formattedPrice = PaymentFormat.formatToUSD(1999.50);
        assertEquals("$1,999.50", formattedPrice);
    }
}
