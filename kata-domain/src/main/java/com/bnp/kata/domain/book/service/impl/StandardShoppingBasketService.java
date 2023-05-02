package com.bnp.kata.domain.book.service.impl;

import com.bnp.kata.domain.book.data.Book;
import com.bnp.kata.domain.book.data.ShoppingBasket;
import com.bnp.kata.domain.book.service.ShoppingBasketService;
import com.bnp.kata.domain.book.spi.BookSPI;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.util.List;


@Service
@AllArgsConstructor
public class StandardShoppingBasketService implements ShoppingBasketService {

    private final BookSPI bookSPI;

    @Override
    public BigDecimal calculatePrice(List<ShoppingBasket> bookRequests) {
        //to implement
        return BigDecimal.valueOf(25L);
    }
}
