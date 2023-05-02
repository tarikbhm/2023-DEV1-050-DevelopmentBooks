package com.bnp.kata.app.book;


import com.bnp.kata.app.book.data.BookRequest;
import com.bnp.kata.app.book.mapper.ShoppingBasketMapper;
import com.bnp.kata.domain.book.service.ShoppingBasketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ShoppingBasketController {

    private ShoppingBasketService shoppingBasketService;
    private ShoppingBasketMapper shoppingBasketMapper;

    @PostMapping(path = "/shop/price")
    BigDecimal calculatePrice(@RequestBody List<BookRequest> bookRequests) {
        return shoppingBasketService.calculatePrice(bookRequests.stream().map(shoppingBasketMapper::map).toList());
    }
}
