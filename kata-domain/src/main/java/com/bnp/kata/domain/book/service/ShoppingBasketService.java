package com.bnp.kata.domain.book.service;

import com.bnp.kata.domain.book.data.ShoppingBasket;

import java.math.BigDecimal;
import java.util.List;

public interface ShoppingBasketService {

    /**
     * calculate the price for a list books and quantities
     * @param bookRequests
     * @return price
     */
    BigDecimal calculatePrice(List<ShoppingBasket> bookRequests);
}
