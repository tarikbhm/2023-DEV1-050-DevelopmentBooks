package com.bnp.kata.infra.book.service.impl;

import com.bnp.kata.domain.book.data.Book;
import com.bnp.kata.domain.book.spi.BookSPI;
import com.bnp.kata.infra.db.repository.BookRepository;
import com.bnp.kata.infra.mapper.BookEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StandardBookService implements BookSPI {
    private final BookRepository bookRepository;

    private final BookEntityMapper bookEntityMapper;

    @Override
    public List<Book> findBooks(){
        var books = bookRepository.findAll();
        return books.stream()
                .map(bookEntityMapper::map)
                .toList();
    }

    @Override
    public Optional<Book> findBookById(Long bookId){
        return bookRepository.findById(bookId).map(bookEntityMapper::map);
    }
}
