package com.company.first_example;

public class RegularPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

    public double getCharge(int dayRented) {
        double result = 2;
        if (dayRented > 2) {
            result += (dayRented - 1) * 1.5;
        }
        return result;
    }
}
