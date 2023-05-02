package com.bnp.kata.infra.mapper;


import com.bnp.kata.domain.book.data.Book;
import com.bnp.kata.infra.db.entity.BookEntity;
import org.mapstruct.Mapper;

@Mapper
public interface BookEntityMapper {

    Book map(BookEntity bookEntity);
}
