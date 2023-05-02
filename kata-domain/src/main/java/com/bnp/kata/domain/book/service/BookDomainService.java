package com.bnp.kata.domain.book.service;

import com.bnp.kata.domain.book.data.Book;

import java.util.List;

public interface BookDomainService {

    /**
     * get all books
     * @return book list
     */
    List<Book> getBooks();
}
