package com.company.first_example;

import com.sun.scenario.effect.impl.prism.PrImage;

public class Movie {
    //儿童片
    public static final int CHILDRENS = 2;
    //普通片
    public static final int REGULAR = 0;
    //新片
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;

    public Movie (String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

//    public void setTitle(String title) {
//        this.title = title;
//    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }
}
