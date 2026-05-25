package com.silva.productsact.product_app.util;

public class ProductUtil {
    private ProductUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static String capitalizeFully(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "";
        }

        String[] words = input.trim().toLowerCase().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }

        return result.toString().trim();
    }
}

