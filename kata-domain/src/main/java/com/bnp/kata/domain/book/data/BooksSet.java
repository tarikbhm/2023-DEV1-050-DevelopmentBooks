package com.bnp.kata.domain.book.data;

import java.util.HashSet;

public class BooksSet {
    private final HashSet<Book> books;
    private final int discount;

    public BooksSet(HashSet<Book> books, int discount){
        this.books = books;
        this.discount = discount;
    }

    public HashSet<Book> getBooks() {
        return books;
    }

    public int getDiscount() {
        return discount;
    }
}