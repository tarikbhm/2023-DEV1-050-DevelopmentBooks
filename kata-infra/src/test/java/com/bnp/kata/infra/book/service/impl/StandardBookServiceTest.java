package com.bnp.kata.infra.book.service.impl;

import com.bnp.kata.domain.book.data.Book;
import com.bnp.kata.infra.db.entity.BookEntity;
import com.bnp.kata.infra.db.repository.BookRepository;
import com.bnp.kata.infra.mapper.BookEntityMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StandardBookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookEntityMapper bookEntityMapper;

    @InjectMocks
    private StandardBookService bookService;

    @Test
    public void testFindBooks() {
        BookEntity bookEntity1 = new BookEntity();
        bookEntity1.setId(1L);
        bookEntity1.setTitle("Test Book 1");
        bookEntity1.setAuthor("Test Author 1");
        bookEntity1.setPrice(BigDecimal.valueOf(10.00));
        bookEntity1.setYearRelease(2022);
        bookEntity1.setImgUrl("test1.jpg");

        BookEntity bookEntity2 = new BookEntity();
        bookEntity2.setId(2L);
        bookEntity2.setTitle("Test Book 2");
        bookEntity2.setAuthor("Test Author 2");
        bookEntity2.setPrice(BigDecimal.valueOf(20.00));
        bookEntity2.setYearRelease(2023);
        bookEntity2.setImgUrl("test2.jpg");

        Book book1 = Book.builder().id(1L).title("Test Book 1").author("Test Author 1").price(BigDecimal.valueOf(10.00)).yearRelease(2022).imgUrl("test1.jpg").build();
        Book book2 = Book.builder().id(2L).title("Test Book 2").author("Test Author 2").price(BigDecimal.valueOf(20.00)).yearRelease(2023).imgUrl("test2.jpg").build();

        List<Book> expectedBooks = Arrays.asList(book1, book2);

        when(bookRepository.findAll()).thenReturn(Arrays.asList(bookEntity1, bookEntity2));
        when(bookEntityMapper.map(bookEntity1)).thenReturn(book1);
        when(bookEntityMapper.map(bookEntity2)).thenReturn(book2);

        List<Book> actualBooks = bookService.findBooks();

        assertEquals(expectedBooks, actualBooks);
    }

    @Test
    public void testFindBookById() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(1L);
        bookEntity.setTitle("Test Book 1");
        bookEntity.setAuthor("Test Author 1");
        bookEntity.setPrice(BigDecimal.valueOf(10.00));
        bookEntity.setYearRelease(2022);
        bookEntity.setImgUrl("test1.jpg");

        Book book = Book.builder().id(1L).title("Test Book 1").author("Test Author 1").price(BigDecimal.valueOf(10.00)).yearRelease(2022).imgUrl("test1.jpg").build();

        when(bookRepository.findById(1L)).thenReturn(Optional.of(bookEntity));
        when(bookEntityMapper.map(bookEntity)).thenReturn(book);

        Optional<Book> bookResult = bookService.findBookById(1L);

        assertEquals(book, bookResult.get());
    }
}