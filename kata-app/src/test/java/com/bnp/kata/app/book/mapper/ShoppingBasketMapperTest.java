package com.bnp.kata.app.book.mapper;

import com.bnp.kata.app.book.data.BookRequest;
import com.bnp.kata.domain.book.data.ShoppingBasket;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingBasketMapperTest {

    private final ShoppingBasketMapper shoppingBasketMapper = Mappers.getMapper(ShoppingBasketMapper.class);

    @Test
    public void shouldMapBookRequestToShoppingBasket() {
        BookRequest bookRequest = new BookRequest(1L, 2);
        ShoppingBasket expectedShoppingBasket = new ShoppingBasket();
        expectedShoppingBasket.setBookId(1L);
        expectedShoppingBasket.setQuantity(2);

        ShoppingBasket shoppingBasket = shoppingBasketMapper.map(bookRequest);

        assertEquals(bookRequest.bookId(), shoppingBasket.getBookId());
        assertEquals(bookRequest.quantity(), shoppingBasket.getQuantity());
    }
}
