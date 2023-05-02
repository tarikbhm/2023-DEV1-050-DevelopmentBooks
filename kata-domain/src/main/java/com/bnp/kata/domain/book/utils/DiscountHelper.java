package com.bnp.kata.domain.book.utils;

import java.util.Map;

public class DiscountHelper {
    private static final Map<Integer, Double> DISCOUNTS = Map.of(
            2, 0.05,
            3, 0.1,
            4, 0.2,
            5, 0.25
    );

    public static double calculateDiscount(int numDistinctBooks) {
        return DISCOUNTS.getOrDefault(numDistinctBooks, 0.0);
    }
}
