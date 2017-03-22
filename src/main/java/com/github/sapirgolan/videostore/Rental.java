package com.github.sapirgolan.videostore;

public class Rental {

    Movie movie;
    private int daysRented;

    public Rental(final Movie movie, final int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getFrequentRenterPoints() {
        int frequentRenterPoints = 1;

        if (getMovie().getPriceCode() == Movie.NEW_RELEASE && getDaysRented() > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }

    public double getCharge() {
        return movie.getCharge(daysRented);
    }
}