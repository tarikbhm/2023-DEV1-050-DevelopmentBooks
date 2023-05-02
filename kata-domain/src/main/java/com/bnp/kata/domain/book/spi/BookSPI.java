package com.bnp.kata.domain.book.spi;

import com.bnp.kata.domain.book.data.Book;

import java.util.List;
import java.util.Optional;

public interface BookSPI {

    /**
     * find all books
     * @return books
     */
    List<Book> findBooks();

    /**
     * find book by id
     * @param bookId book id
     * @return book optional
     */
    Optional<Book> findBookById(Long bookId);
}
