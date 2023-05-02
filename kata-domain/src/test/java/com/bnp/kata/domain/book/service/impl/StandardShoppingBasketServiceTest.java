package com.bnp.kata.domain.book.service.impl;

import com.bnp.kata.domain.book.data.Book;
import com.bnp.kata.domain.book.data.ShoppingBasket;
import com.bnp.kata.domain.book.spi.BookSPI;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StandardShoppingBasketServiceTest {

    @Mock
    private BookSPI bookSPI;

    @InjectMocks
    private StandardShoppingBasketService shoppingBasketService;

    /*
    One copy of the five books costs 50 EUR.
     */
    @Test
    void test_calculatePrice_withOneBook() {
        //data
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        shoppingBasket.setBookId(1L);
        shoppingBasket.setQuantity(1);
        List<ShoppingBasket> bookRequests = List.of(shoppingBasket);
        //mock
        when(bookSPI.findBookById(1L)).thenReturn(Optional.of(
                Book.builder()
                        .id(1L)
                        .title("Book 1")
                        .author("Author 1")
                        .price(BigDecimal.valueOf(50))
                        .build()
        ));
        //run
        BigDecimal result = shoppingBasketService.calculatePrice(bookRequests);
        //check
        assertEquals(BigDecimal.valueOf(50), result);
    }

    /*
    If, however, you buy two different books from the series, you get a 5% discount on those two books.
     */
    @Test
    void test_calculatePrice_withTwoDifferentBooks() {
        //data
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        shoppingBasket.setBookId(1L);
        shoppingBasket.setQuantity(1);

        ShoppingBasket shoppingBasket2 = new ShoppingBasket();
        shoppingBasket.setBookId(2L);
        shoppingBasket.setQuantity(1);

        List<ShoppingBasket> bookRequests = List.of(
                shoppingBasket,
                shoppingBasket2
        );
        //mock
        when(bookSPI.findBookById(1L)).thenReturn(Optional.of(
                Book.builder()
                        .id(1L)
                        .title("Book 1")
                        .author("Author 1")
                        .price(BigDecimal.valueOf(50))
                        .build()
        ));
        when(bookSPI.findBookById(2L)).thenReturn(Optional.of(
                Book.builder()
                        .id(2L)
                        .title("Book 2")
                        .author("Author 2")
                        .price(BigDecimal.valueOf(50))
                        .build()
        ));
        //run
        BigDecimal result = shoppingBasketService.calculatePrice(bookRequests);
        //check
        assertEquals(BigDecimal.valueOf(95), result);
    }

    /*
    If you buy 3 different books, you get a 10% discount.
     */
    @Test
    void test_calculatePrice_withThreeDifferentBooks() {
        //data
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        shoppingBasket.setBookId(1L);
        shoppingBasket.setQuantity(1);

        ShoppingBasket shoppingBasket2 = new ShoppingBasket();
        shoppingBasket.setBookId(2L);
        shoppingBasket.setQuantity(1);

        ShoppingBasket shoppingBasket3 = new ShoppingBasket();
        shoppingBasket.setBookId(3L);
        shoppingBasket.setQuantity(1);

        List<ShoppingBasket> bookRequests = List.of(
                shoppingBasket,
                shoppingBasket2,
                shoppingBasket3
        );
        //mock
        when(bookSPI.findBookById(1L)).thenReturn(Optional.of(
                Book.builder()
                        .id(1L)
                        .title("Book 1")
                        .author("Author 1")
                        .price(BigDecimal.valueOf(50))
                        .build()
        ));
        when(bookSPI.findBookById(2L)).thenReturn(Optional.of(
                Book.builder()
                        .id(2L)
                        .title("Book 2")
                        .author("Author 2")
                        .price(BigDecimal.valueOf(50))
                        .build()
        ));
        when(bookSPI.findBookById(3L)).thenReturn(Optional.of(
                Book.builder()
                        .id(3L)
                        .title("Book 3")
                        .author("Author 3")
                        .price(BigDecimal.valueOf(50))
                        .build()
        ));
        //run
        BigDecimal result = shoppingBasketService.calculatePrice(bookRequests);
        //check
        assertEquals(BigDecimal.valueOf(135), result);
    }

    /*
    With 4 different books, you get a 20% discount.
     */
    @Test
    void test_calculatePrice_withFourDifferentBooks() {
        //data
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        shoppingBasket.setBookId(1L);
        shoppingBasket.setQuantity(1);

        ShoppingBasket shoppingBasket2 = new ShoppingBasket();
        shoppingBasket.setBookId(2L);
        shoppingBasket.setQuantity(1);

        ShoppingBasket shoppingBasket3 = new ShoppingBasket();
        shoppingBasket.setBookId(3L);
        shoppingBasket.setQuantity(1);

        ShoppingBasket shoppingBasket4 = new ShoppingBasket();
        shoppingBasket.setBookId(4L);
        shoppingBasket.setQuantity(1);

        List<ShoppingBasket> bookRequests = List.of(
                shoppingBasket,
                shoppingBasket2,
                shoppingBasket3,
                shoppingBasket4
        );
        //mock
        Mockito.when(bookSPI.findBookById(1L)).thenReturn(Optional.of(
                Book.builder()
                        .id(1L)
                        .title("Book 1")
                        .author("Author 1")
                        .price(BigDecimal.valueOf(50))
                        .build()
        ));
        Mockito.when(bookSPI.findBookById(2L)).thenReturn(Optional.of(
                Book.builder()
                        .id(2L)
                        .title("Book 2")
                        .author("Author 2")
                        .price(BigDecimal.valueOf(50))
                        .build()
        ));
        Mockito.when(bookSPI.findBookById(3L)).thenReturn(Optional.of(
                Book.builder()
                        .id(3L)
                        .title("Book 3")
                        .author("Author 3")
                        .price(BigDecimal.valueOf(50))
                        .build()
        ));
        Mockito.when(bookSPI.findBookById(4L)).thenReturn(Optional.of(
                Book.builder()
                        .id(4L)
                        .title("Book 4")
                        .author("Author 4")
                        .price(BigDecimal.valueOf(50))
                        .build()
        ));
        //run
        BigDecimal result = shoppingBasketService.calculatePrice(bookRequests);
        //check
        assertEquals(BigDecimal.valueOf(160), result);
    }
    /*
    If you go for the whole hog, and buy all 5, you get a huge 25% discount.
     */
    @Test
    void test_calculatePrice_withAllBooks() {
        //data
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        shoppingBasket.setBookId(1L);
        shoppingBasket.setQuantity(1);

        ShoppingBasket shoppingBasket2 = new ShoppingBasket();
        shoppingBasket.setBookId(2L);
        shoppingBasket.setQuantity(1);

        ShoppingBasket shoppingBasket3 = new ShoppingBasket();
        shoppingBasket.setBookId(3L);
        shoppingBasket.setQuantity(1);

        ShoppingBasket shoppingBasket4 = new ShoppingBasket();
        shoppingBasket.setBookId(4L);
        shoppingBasket.setQuantity(1);

        ShoppingBasket shoppingBasket5 = new ShoppingBasket();
        shoppingBasket.setBookId(5L);
        shoppingBasket.setQuantity(1);

        List<ShoppingBasket> bookRequests = List.of(
                shoppingBasket,
                shoppingBasket2,
                shoppingBasket3,
                shoppingBasket4,
                shoppingBasket5
        );
        //mock
        Mockito.when(bookSPI.findBookById(1L)).thenReturn(Optional.of(
                Book.builder()
                        .id(1L)
                        .title("Book 1")
                        .author("Author 1")
                        .price(BigDecimal.valueOf(50))
                        .build()
        ));
        Mockito.when(bookSPI.findBookById(2L)).thenReturn(Optional.of(
                Book.builder()
                        .id(2L)
                        .title("Book 2")
                        .author("Author 2")
                        .price(BigDecimal.valueOf(50))
                        .build()
        ));
        Mockito.when(bookSPI.findBookById(3L)).thenReturn(Optional.of(
                Book.builder()
                        .id(3L)
                        .title("Book 3")
                        .author("Author 3")
                        .price(BigDecimal.valueOf(50))
                        .build()
        ));
        Mockito.when(bookSPI.findBookById(4L)).thenReturn(Optional.of(
                Book.builder()
                        .id(4L)
                        .title("Book 4")
                        .author("Author 4")
                        .price(BigDecimal.valueOf(50))
                        .build()
        ));
        Mockito.when(bookSPI.findBookById(5L)).thenReturn(Optional.of(
                Book.builder()
                        .id(5L)
                        .title("Book 5")
                        .author("Author 5")
                        .price(BigDecimal.valueOf(50))
                        .build()
        ));
        //run
        BigDecimal result = shoppingBasketService.calculatePrice(bookRequests);
        //check
        assertEquals(BigDecimal.valueOf(187.50), result);
    }
    /*
    Note that if you buy, say, 4 books, of which 3 are different titles, you get a 10% discount on the 3 that form part of a set, but the 4th book still costs 50 EUR
     */
    @Test
    void test_calculatePrice_whenFourBooksWithThreeDifferentTitles() {
        //data
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        shoppingBasket.setBookId(1L);
        shoppingBasket.setQuantity(1);

        ShoppingBasket shoppingBasket2 = new ShoppingBasket();
        shoppingBasket.setBookId(2L);
        shoppingBasket.setQuantity(1);

        ShoppingBasket shoppingBasket3 = new ShoppingBasket();
        shoppingBasket.setBookId(3L);
        shoppingBasket.setQuantity(1);

        ShoppingBasket shoppingBasket4 = new ShoppingBasket();
        shoppingBasket.setBookId(3L);
        shoppingBasket.setQuantity(1);

        List<ShoppingBasket> bookRequests = List.of(
                shoppingBasket,
                shoppingBasket2,
                shoppingBasket3,
                shoppingBasket4
        );
        //mock
        Mockito.when(bookSPI.findBookById(1L)).thenReturn(Optional.of(
                Book.builder()
                        .id(1L)
                        .title("Book 1")
                        .author("Author 1")
                        .price(BigDecimal.valueOf(50))
                        .build()
        ));
        Mockito.when(bookSPI.findBookById(2L)).thenReturn(Optional.of(
                Book.builder()
                        .id(2L)
                        .title("Book 2")
                        .author("Author 2")
                        .price(BigDecimal.valueOf(50))
                        .build()
        ));
        Mockito.when(bookSPI.findBookById(3L)).thenReturn(Optional.of(
                Book.builder()
                        .id(3L)
                        .title("Book 3")
                        .author("Author 3")
                        .price(BigDecimal.valueOf(50))
                        .build()
        ));
        Mockito.when(bookSPI.findBookById(4L)).thenReturn(Optional.of(
                Book.builder()
                        .id(4L)
                        .title("Book 4")
                        .author("Author 4")
                        .price(BigDecimal.valueOf(50))
                        .build()
        ));

        //run
        BigDecimal result = shoppingBasketService.calculatePrice(bookRequests);

        //check
        assertEquals(BigDecimal.valueOf(165), result);
    }

    /*
        2 copies of the book 1
        2 copies of the book 2
        2 copies of the book 3
        1 copy of the book 4
        1 copy of the book 5
        This case should return 320
    */
    @Test
    void test_calculatePrice_withAllBookAndMoreThanOneQuantity() {
        //data
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        shoppingBasket.setBookId(1L);
        shoppingBasket.setQuantity(2);

        ShoppingBasket shoppingBasket2 = new ShoppingBasket();
        shoppingBasket.setBookId(2L);
        shoppingBasket.setQuantity(2);

        ShoppingBasket shoppingBasket3 = new ShoppingBasket();
        shoppingBasket.setBookId(3L);
        shoppingBasket.setQuantity(2);

        ShoppingBasket shoppingBasket4 = new ShoppingBasket();
        shoppingBasket.setBookId(4L);
        shoppingBasket.setQuantity(1);

        ShoppingBasket shoppingBasket5 = new ShoppingBasket();
        shoppingBasket.setBookId(5L);
        shoppingBasket.setQuantity(1);

        List<ShoppingBasket> bookRequests = List.of(
                shoppingBasket,
                shoppingBasket2,
                shoppingBasket3,
                shoppingBasket4,
                shoppingBasket5
        );
        //mock
        Mockito.when(bookSPI.findBookById(1L)).thenReturn(Optional.of(
                Book.builder()
                        .id(1L)
                        .title("Book 1")
                        .author("Author 1")
                        .price(BigDecimal.valueOf(50))
                        .build()
        ));
        Mockito.when(bookSPI.findBookById(2L)).thenReturn(Optional.of(
                Book.builder()
                        .id(2L)
                        .title("Book 2")
                        .author("Author 2")
                        .price(BigDecimal.valueOf(50))
                        .build()
        ));
        Mockito.when(bookSPI.findBookById(3L)).thenReturn(Optional.of(
                Book.builder()
                        .id(3L)
                        .title("Book 3")
                        .author("Author 3")
                        .price(BigDecimal.valueOf(50))
                        .build()
        ));
        Mockito.when(bookSPI.findBookById(4L)).thenReturn(Optional.of(
                Book.builder()
                        .id(4L)
                        .title("Book 4")
                        .author("Author 4")
                        .price(BigDecimal.valueOf(50))
                        .build()
        ));
        Mockito.when(bookSPI.findBookById(5L)).thenReturn(Optional.of(
                Book.builder()
                        .id(5L)
                        .title("Book 5")
                        .author("Author 5")
                        .price(BigDecimal.valueOf(50))
                        .build()
        ));
        //run
        BigDecimal result = shoppingBasketService.calculatePrice(bookRequests);
        //check
        assertEquals(BigDecimal.valueOf(187.50), result);
    }
}
