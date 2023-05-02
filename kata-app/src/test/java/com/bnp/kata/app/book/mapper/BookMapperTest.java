package com.bnp.kata.app.book.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import com.bnp.kata.domain.book.data.Book;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.bnp.kata.app.book.data.BookResponse;


public class BookMapperTest {

    private final BookMapper bookMapper = Mappers.getMapper(BookMapper.class);

    @Test
    void map_shouldReturnCorrectBookResponse() {
        Book book = Book.builder()
                .id(1L)
                .title("Test Book 1")
                .author("Test Author 1")
                .price(BigDecimal.valueOf(10.00))
                .yearRelease(2022)
                .imgUrl("test1.jpg")
                .build();

        BookResponse bookResponse = bookMapper.map(book);

        assertEquals(book.getId(), bookResponse.id());
        assertEquals(book.getTitle(), bookResponse.title());
        assertEquals(book.getAuthor(), bookResponse.author());
        assertEquals(book.getPrice(), bookResponse.price());
        assertEquals(book.getYearRelease(), bookResponse.yearRelease());
        assertEquals(book.getImgUrl(), bookResponse.imgUrl());
    }
}
