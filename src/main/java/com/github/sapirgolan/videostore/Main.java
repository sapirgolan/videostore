package com.github.sapirgolan.videostore;

/**
 * Created by I062070 on 01/03/2017.
 */
public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer("Test customer");

        Movie movie2 = new Movie("The godfather", Movie.REGULAR);
        Movie movie3 = new Movie("The Matrix", Movie.REGULAR);
        Movie movie4 = new Movie("Despicable me", Movie.CHILDRENS);

        customer.addRental(new Rental(movie2, 2));
        customer.addRental(new Rental(movie2, 2));
        customer.addRental(new Rental(movie3, 10));
        customer.addRental(new Rental(movie4, 1));

        System.out.println(customer.statement());
        /*
        * Rental Record for Test customer
        * The godfather	2.0
        * The godfather	2.0
        * The Matrix	14.0
        * Despicable me	1.5
        * You owed 19.5
        * You earned 4 frequent renter points
        *
        */
    }
}