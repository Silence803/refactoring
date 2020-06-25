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
//        double totalAmount = 0;
        //积分
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
        if (rentals != null) {
            while (rentals.hasMoreElements()) {
                Rental each = rentals.nextElement();
                //determine amounts for each line
// 将这块代码重构为一个方法
//                switch (each.getMovie().getPriceCode()) {
//                    case Movie.REGULAR:
//                        thisAmount += 2;
//                        if (each.getDaysRented() > 2) {
//                            thisAmount += (each.getDaysRented() - 2) * 1.5;
//                        }
//                        break;
//                    case Movie.NEW_RELEASE:
//                        thisAmount += each.getDaysRented() * 3;
//                        break;
//                    case Movie.CHILDRENS:
//                        thisAmount += 1.5;
//                        if (each.getDaysRented() > 3) {
//                            thisAmount += (each.getDaysRented() -3) * 1.5;
//                        }
//                        break;
//                    default:
//                        thisAmount += (each.getDaysRented() -1) * 1.5;
//                        break;
//                }
//                thisAmount = amountFor(each);
//                thisAmount = each.getCharge();

                //add frequent renter points
                frequentRenterPoints += each.getFrequentRenterPoints();
                //add bonus for a two day new release rental
//                if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
//                    each.getDaysRented() > 1) {
//                    frequentRenterPoints ++;
//                }
                //show figures for this rental
                result.append("\t").append(each.getMovie().getTitle()).append("\t").append(each.getCharge()).append("\n");
//                totalAmount += each.getCharge();
            }
            //add footer lines
            result.append("Amount owed is ").append(getTotalCharge()).append("\n");
            result.append("You earned ").append(getTotalFrequentRenterPoints()).append(" frequent renter points");

        }
        return result.toString();
    }

//    public double amountFor(Rental rental) {
//        return rental.getCharge();
//    }

    public double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> renatls = _rentals.elements();
        while (renatls.hasMoreElements()) {
            Rental rental = renatls.nextElement();
            result += rental.getCharge();
        }
        return result;
    }

    public int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration<Rental> rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental rental = rentals.nextElement();
            result += rental.getFrequentRenterPoints();
        }
        return result;
    }

    public String htmlStatement() {
        Enumeration<Rental> rentals = _rentals.elements();
        StringBuilder result = new StringBuilder("<H1>Rental for <EM>" + getName() + "</EM></H1><P>\n");
        while (rentals.hasMoreElements()) {
            Rental rental = rentals.nextElement();
            result.append(rental.getMovie().getTitle()).append(": ").append(rental.getCharge()).append("<BR>\n");
        }
        result.append("<P>You owe <EM>").append(getTotalCharge()).append("</EM><P>\n");
        result.append("On this rental ypu earned <EM>").append(getTotalFrequentRenterPoints())
                .append("</EM> frequent renter points");
        return result.toString();
    }
}
