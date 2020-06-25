package com.company.first_example;

public abstract class Price {
    abstract int getPriceCode();

    abstract double getCharge(int dayRented);
//    public double getCharge(int dayRented) {
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
//    }

    int getFrequentRenterPoints(int dayRented) {
        return 1;
    }
}
