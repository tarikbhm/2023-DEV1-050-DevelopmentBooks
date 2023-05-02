package com.bnp.kata.infra.mapper;


import com.bnp.kata.domain.book.data.Book;
import com.bnp.kata.infra.db.entity.BookEntity;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BookEntityMapperTest {
    BookEntityMapper mapper = new BookEntityMapperImpl();

    @Test
    public void testMapBookEntityToBook() {
        BookEntity entity = new BookEntity();
        entity.setId(1L);
        entity.setTitle("Title");
        entity.setAuthor("Author");
        entity.setPrice(BigDecimal.valueOf(10.50));
        entity.setYearRelease(2021);
        entity.setImgUrl("https://example.com/image.jpg");

        Book book = mapper.map(entity);

        assertNotNull(book);
        assertEquals(entity.getId(), book.getId());
        assertEquals(entity.getTitle(), book.getTitle());
        assertEquals(entity.getAuthor(), book.getAuthor());
        assertEquals(entity.getPrice(), book.getPrice());
        assertEquals(entity.getYearRelease(), book.getYearRelease());
        assertEquals(entity.getImgUrl(), book.getImgUrl());
    }

}