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
//    private int priceCode;
    private Price price;

    public Movie (String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode) {
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDRENS:
                price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

//移动到了price类
    public double getCharge(int dayRented) {
//        double result = 0;
//        switch (getPriceCode()) {
//            case Movie.REGULAR:
//                result += 2;
//                if (dayRented > 2) {
//                    result += (dayRented - 2) * 1.5;
//                }
//                break;
//            case Movie.NEW_RELEASE:
//                result += dayRented * 3;
//                break;
//            case Movie.CHILDRENS:
//                result += 1.5;
//                if (dayRented > 3) {
//                    result += (dayRented -3) * 1.5;
//                }
//                break;
//            default:
//                result += (dayRented -1) * 1.5;
//                break;
//        }
//        return result;
        return price.getCharge(dayRented);
    }

    public int getFrequentRenterPoints(int dayRented) {
        return price.getFrequentRenterPoints(dayRented);
    }

}
