package com.bnp.kata.domain.book.service.impl;

import com.bnp.kata.domain.book.data.Book;
import com.bnp.kata.domain.book.service.BookDomainService;
import com.bnp.kata.domain.book.spi.BookSPI;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StandardBookDomainService implements BookDomainService {

    private final BookSPI bookSPI;

    @Override
    public List<Book> getBooks() {
        return bookSPI.findBooks();
    }

}
