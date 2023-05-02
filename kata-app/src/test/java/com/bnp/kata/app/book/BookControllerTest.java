package com.bnp.kata.app.book;

import com.bnp.kata.app.book.data.BookResponse;
import com.bnp.kata.app.book.mapper.BookMapper;
import com.bnp.kata.domain.book.data.Book;
import com.bnp.kata.domain.book.service.BookDomainService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookDomainService bookDomainService;

    @MockBean
    private BookMapper bookMapper;


    @Test
    public void testGetBooks() throws Exception {
        Book book1 = Book.builder().id(1L).title("Test Book 1").author("Test Author 1").price(BigDecimal.valueOf(10.00)).yearRelease(2022).imgUrl("test1.jpg").build();
        Book book2 = Book.builder().id(2L).title("Test Book 2").author("Test Author 2").price(BigDecimal.valueOf(20.00)).yearRelease(2021).imgUrl("test2.jpg").build();
        List<Book> books = Arrays.asList(book1, book2);

        BookResponse bookResponse1 = new BookResponse(1L, "Test Book 1", "Test Author 1", BigDecimal.valueOf(10.00), 2022, "test1.jpg");
        BookResponse bookResponse2 = new BookResponse(2L, "Test Book 2", "Test Author 2", BigDecimal.valueOf(20.00), 2021, "test2.jpg");

        when(bookDomainService.getBooks()).thenReturn(books);
        when(bookMapper.map(book1)).thenReturn(bookResponse1);
        when(bookMapper.map(book2)).thenReturn(bookResponse2);

        mockMvc.perform(MockMvcRequestBuilders.get("/books")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[{\"id\":1,\"title\":\"Test Book 1\",\"author\":\"Test Author 1\",\"price\":10.00,\"yearRelease\":2022,\"imgUrl\":\"test1.jpg\"}," +
                        "{\"id\":2,\"title\":\"Test Book 2\",\"author\":\"Test Author 2\",\"price\":20.00,\"yearRelease\":2021,\"imgUrl\":\"test2.jpg\"}]"));
    }
}