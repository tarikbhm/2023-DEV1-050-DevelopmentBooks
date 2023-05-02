package com.bnp.kata.domain.book.service;

import com.bnp.kata.domain.book.data.ShoppingBasket;

import java.math.BigDecimal;
import java.util.List;

public interface ShoppingBasketService {

    BigDecimal calculatePrice(List<ShoppingBasket> bookRequests);
}
