package com.bnp.kata.app.book.mapper;

import com.bnp.kata.app.book.data.BookRequest;
import com.bnp.kata.domain.book.data.ShoppingBasket;
import org.mapstruct.Mapper;

@Mapper
public interface ShoppingBasketMapper {
    ShoppingBasket map(BookRequest bookRequest);
}
