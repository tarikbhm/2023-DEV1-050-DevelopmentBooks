package com.bnp.kata.domain.book.service.impl;

import com.bnp.kata.domain.book.data.Book;
import com.bnp.kata.domain.book.spi.BookSPI;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class StandardBookDomainServiceTest {

    @Mock
    private BookSPI bookSPI;

    @InjectMocks
    private StandardBookDomainService bookDomainService;

    @Test
    public void testGetBooks() {
        List<Book> books = new ArrayList<>();
        books.add(Book.builder().id(1L).title("Test Book 1").author("Test Author 1")
                .price(BigDecimal.valueOf(10.00)).yearRelease(2022).imgUrl("test1.jpg").build());
        books.add(Book.builder().id(2L).title("Test Book 2").author("Test Author 2")
                .price(BigDecimal.valueOf(20.00)).yearRelease(2021).imgUrl("test2.jpg").build());

        when(bookSPI.findBooks()).thenReturn(books);

        List<Book> result = bookDomainService.getBooks();

        assertEquals(2, result.size());
        assertEquals(books, result);
    }
}
