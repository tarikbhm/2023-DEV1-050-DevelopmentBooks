package com.bnp.kata.app.book;

import com.bnp.kata.app.book.data.BookResponse;
import com.bnp.kata.app.book.mapper.BookMapper;
import com.bnp.kata.domain.book.service.BookDomainService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class BookController {

    private final BookDomainService bookDomainService;

    private final BookMapper bookMapper;

    @GetMapping(path = "/books")
    List<BookResponse> getBooks() {
        return bookDomainService.getBooks().stream().map(bookMapper::map).toList();
    }

}
