package com.silva.productsact.product_app.util;
import java.text.NumberFormat;
import java.util.Locale;

public class PaymentFormat {

    private PaymentFormat() {
        throw new IllegalStateException("Utility class");
    }

    public static String formatToUSD(double price) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.US);
        return formatter.format(price);
    }
}

