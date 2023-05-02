package com.bnp.kata.domain.book.utils;

import java.util.Map;

public class DiscountHelper {
    private static final Map<Integer, Integer> DISCOUNTS = Map.of(
            2, 5,
            3, 10,
            4, 20,
            5, 25
    );

    public static int calculateDiscount(int numDistinctBooks) {
        return DISCOUNTS.getOrDefault(numDistinctBooks, 0);
    }
}