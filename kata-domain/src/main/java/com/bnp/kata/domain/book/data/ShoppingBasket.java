package com.bnp.kata.domain.book.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingBasket {
    private Long bookId;
    private int quantity;

}
