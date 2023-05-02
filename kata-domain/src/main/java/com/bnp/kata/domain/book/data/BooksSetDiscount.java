package com.bnp.kata.domain.book.data;

public class BooksSetDiscount {
    private int differentCopies;
    private int discount;

    public BooksSetDiscount(int differentCopies, int discount){
        this.differentCopies = differentCopies;
        this.discount = discount;
    }

    public int getDifferentCopies(){
        return differentCopies;
    }

    public int getDiscount(){
        return discount;
    }
}