package com.bnp.kata.domain.book.data;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class Book {

    private Long id;
    private String title;
    private String author;
    private BigDecimal price;
    private int yearRelease;
    private String imgUrl;
}
