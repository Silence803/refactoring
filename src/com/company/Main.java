package com.company;

import com.company.first_example.Customer;
import com.company.first_example.Movie;
import com.company.first_example.Rental;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Movie dhxy = new Movie("大话西游", 0);
        Movie nj = new Movie("哪吒脑海", 2);
        Movie xp = new Movie("姜子牙", 1);
        Rental rental = new Rental(dhxy, 2);
        Rental rental1 = new Rental(nj, 2);
        Rental rental2 = new Rental(xp, 5);
        Customer customer = new Customer("zxr");
        customer.addRental(rental);
        customer.addRental(rental1);
        customer.addRental(rental2);
        System.out.println(customer.statement());
        System.out.println(customer.htmlStatement());

    }
}
