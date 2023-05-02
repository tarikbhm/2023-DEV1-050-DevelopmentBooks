package com.bnp.kata.app.book.data;

import java.math.BigDecimal;

public record BookResponse (Long id, String title, String author, BigDecimal price, int yearRelease, String imgUrl) {
}
