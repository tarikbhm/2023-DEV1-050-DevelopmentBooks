package com.bnp.kata.domain.book.service.impl;

import com.bnp.kata.domain.book.data.Book;
import com.bnp.kata.domain.book.data.BooksSet;
import com.bnp.kata.domain.book.data.ShoppingBasket;
import com.bnp.kata.domain.book.service.ShoppingBasketService;
import com.bnp.kata.domain.book.spi.BookSPI;
import com.bnp.kata.domain.book.utils.DiscountHelper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


@Service
@AllArgsConstructor
public class StandardShoppingBasketService implements ShoppingBasketService {

    private final BookSPI bookSPI;

    public BigDecimal calculatePrice(List<ShoppingBasket> bookRequests) {
        if(bookRequests.isEmpty())
            return BigDecimal.ZERO;

        List<BooksSet> setsOfDifferentBooks = getDifferentBooksSetsWithMaxTotalDiscount(bookRequests);

        BigDecimal totalPrice = BigDecimal.ZERO;
        BigDecimal setPrice;

        for (BooksSet booksSet : setsOfDifferentBooks) {
            setPrice = BigDecimal.ZERO;
            for (Book book : booksSet.getBooks()) {
                setPrice = setPrice.add(book.getPrice());
            }

            setPrice = setPrice.multiply(BigDecimal.ONE.subtract(BigDecimal.valueOf(booksSet.getDiscount()).divide(BigDecimal.valueOf(100))));
            totalPrice = totalPrice.add(setPrice);
        }

        int totalBooksInCart = bookRequests.stream().mapToInt(ShoppingBasket::getQuantity).sum();
        int totalBooksInSets = setsOfDifferentBooks.stream().mapToInt(set -> set.getBooks().size()).sum();

        int remainingBooks = totalBooksInCart - totalBooksInSets;

        BigDecimal remainingPrice = BigDecimal.valueOf(remainingBooks).multiply(BigDecimal.valueOf(50));

        totalPrice = totalPrice.add(remainingPrice);

        return totalPrice;
    }


    public List<BooksSet> getDifferentBooksSetsWithMaxTotalDiscount(List<ShoppingBasket> shoppingCartItems) {

        List<BooksSet> optimizeSetList;

        optimizeSetList = getBestCombinationBooksSets(shoppingCartItems);

        return optimizeSetList;
    }

    private List<BooksSet> getBestCombinationBooksSets(List<ShoppingBasket> shoppingCartItems) {
        List<List<BooksSet>> differentBooksSetsCombinations = new ArrayList<>();

        for (int i = shoppingCartItems.size();i>=1;i--){
            differentBooksSetsCombinations.add(calculateDifferentBooksSetsByMaxSize(shoppingCartItems,i));
        }

        List<BooksSet> optimizeSetList;

        if(differentBooksSetsCombinations.size() > 1)
            optimizeSetList = selectBooksSetsWithMaxDiscount(differentBooksSetsCombinations);
        else
            optimizeSetList = differentBooksSetsCombinations.get(0);
        return optimizeSetList;
    }

    private List<BooksSet> calculateDifferentBooksSetsByMaxSize(List<ShoppingBasket> shoppingCartItems, int maxSizeSet) {
        List<ShoppingBasket> remainingShoppingCartItems = cloneShoppingCartItems(shoppingCartItems);
        List<BooksSet> setsOfDifferentBooks = new ArrayList<>();

        while (remainingShoppingCartItems.size() > 0) {
            final BooksSet oneSetOfDifferentBooks = createNextSet(remainingShoppingCartItems,maxSizeSet);
            setsOfDifferentBooks.add(oneSetOfDifferentBooks);
        }

        return setsOfDifferentBooks;
    }

    private BooksSet createNextSet(List<ShoppingBasket> remainingShoppingCartItems, int maxSizeSet) {
        HashSet<Book> books = new HashSet<>();

        for (ShoppingBasket item:new ArrayList<>(remainingShoppingCartItems)) {

            books.add(bookSPI.findBookById(item.getBookId()).orElseThrow());

            if (item.getQuantity() == 1)
                remainingShoppingCartItems.remove(item);
            else
                item.setQuantity(item.getQuantity() - 1);

            if (books.size() == maxSizeSet)
                break;
        }

        BooksSet booksSet = new BooksSet(books, DiscountHelper.calculateDiscount(books.size()));

        return booksSet;
    }

    private List<BooksSet> selectBooksSetsWithMaxDiscount(List<List<BooksSet>> booksSetsCombinations) {
        List<BooksSet> maxDiscountBooksSets = null;
        int maxBooksSetsDiscount = 0;
        int totalBooksSetsDiscount = 0;

        for (List<BooksSet> booksSets:booksSetsCombinations) {
            for (BooksSet booksSet:booksSets) {
                totalBooksSetsDiscount += booksSet.getDiscount();
            }

            if (maxBooksSetsDiscount < totalBooksSetsDiscount) {
                maxDiscountBooksSets = booksSets;
                maxBooksSetsDiscount = totalBooksSetsDiscount;
            }

            totalBooksSetsDiscount = 0;
        }

        return maxDiscountBooksSets;
    }


    private List<ShoppingBasket> cloneShoppingCartItems (List<ShoppingBasket> shoppingCartItems){
        List<ShoppingBasket> shoppingCartItemsCopy = new ArrayList<>();

        for (ShoppingBasket item:shoppingCartItems) {
            ShoppingBasket shoppingBasket = new ShoppingBasket();
            shoppingBasket.setQuantity(item.getQuantity());
            shoppingBasket.setBookId(item.getBookId());
            shoppingCartItemsCopy.add(shoppingBasket);
        }

        return shoppingCartItemsCopy;
    }

}
