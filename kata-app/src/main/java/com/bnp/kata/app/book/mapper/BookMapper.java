package com.bnp.kata.app.book.mapper;

import com.bnp.kata.app.book.data.BookResponse;
import com.bnp.kata.domain.book.data.Book;
import org.mapstruct.Mapper;

@Mapper
public interface BookMapper {

    BookResponse map(Book book);
}
