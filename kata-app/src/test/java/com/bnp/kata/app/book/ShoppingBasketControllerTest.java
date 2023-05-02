package com.bnp.kata.app.book;

import com.bnp.kata.app.book.data.BookRequest;
import com.bnp.kata.app.book.mapper.ShoppingBasketMapper;
import com.bnp.kata.domain.book.data.ShoppingBasket;
import com.bnp.kata.domain.book.service.ShoppingBasketService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ShoppingBasketController.class)
public class ShoppingBasketControllerTest {

    @MockBean
    private ShoppingBasketService shoppingBasketService;

    @MockBean
    private ShoppingBasketMapper shoppingBasketMapper;

    @Autowired
    private MockMvc mockMvc;



    @Test
    void calculatePrice_ShouldReturnCorrectPrice() throws Exception {
        BookRequest bookRequest1 = new BookRequest(1L, 2);
        BookRequest bookRequest2 = new BookRequest(2L, 1);

        List<BookRequest> bookRequests = List.of(new BookRequest(1L, 2), new BookRequest(2L, 1));
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        shoppingBasket.setQuantity(10);
        shoppingBasket.setBookId(10L);
        ShoppingBasket shoppingBasket2 = new ShoppingBasket();
        shoppingBasket2.setQuantity(20);
        shoppingBasket2.setBookId(20L);

        List<ShoppingBasket> shoppingBaskets = List.of(shoppingBasket, shoppingBasket2);
        BigDecimal expectedPrice = BigDecimal.valueOf(25.00);

        when(shoppingBasketMapper.map(bookRequest1)).thenReturn(shoppingBasket);
        when(shoppingBasketMapper.map(bookRequest2)).thenReturn(shoppingBasket2);

        when(shoppingBasketService.calculatePrice(shoppingBaskets)).thenReturn(expectedPrice);

        MvcResult result = mockMvc.perform(post("/shop/price")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(bookRequests)))
                .andExpect(status().isOk())
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();
        BigDecimal actualPrice = new ObjectMapper().readValue(responseBody, BigDecimal.class);
        assertEquals(expectedPrice, actualPrice);
    }
}