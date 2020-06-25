package com.company.first_example;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

    private String name;
    public Vector<Rental> _rentals = new Vector<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        //积分
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
        if (rentals != null) {
            while (rentals.hasMoreElements()) {
                double thisAmount = 0;
                Rental each = rentals.nextElement();
                //determine amounts for each line
                switch (each.getMovie().getPriceCode()) {
                    case Movie.REGULAR:
                        thisAmount += 2;
                        if (each.getDaysRented() > 2) {
                            thisAmount += (each.getDaysRented() - 2) * 1.5;
                        }
                        break;
                    case Movie.NEW_RELEASE:
                        thisAmount += each.getDaysRented() * 3;
                        break;
                    case Movie.CHILDRENS:
                        thisAmount += 1.5;
                        if (each.getDaysRented() > 3) {
                            thisAmount += (each.getDaysRented() -3) * 1.5;
                        }
                        break;
                    default:
                        thisAmount += (each.getDaysRented() -1) * 1.5;
                        break;
                }

                //add frequent renter points
                frequentRenterPoints ++;
                //add bonus for a two day new release rental
                if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                    each.getDaysRented() > 1) {
                    frequentRenterPoints ++;
                }
                //show figures for this rental
                result.append("\t").append(each.getMovie().getTitle()).append("\t").append(String.valueOf(thisAmount)).append("\n");
                totalAmount += thisAmount;
            }
            //add footer lines
            result.append("Amount owed is ").append(String.valueOf(totalAmount)).append("\n");
            result.append("You earned ").append(String.valueOf(frequentRenterPoints)).append(" frequent renter points");

        }
        return result.toString();
    }
}
