package com.github.sapirgolan.videostore;

import java.util.Enumeration;

public class StringStatement extends Statement {

    public StringStatement(Customer customer) {
        super(customer);
    }

    @Override
    protected String generateRentEntry(String title, String charge) {
        return String.format("\t%s\t%s\n", title, charge);
    }

    @Override
    protected String generateTotalFrequentPoints(String totalFrequentRenterPoints) {
        return String.format("You earned %s frequent renter points\n", totalFrequentRenterPoints);
    }

    @Override
    protected String generateTotalCharge(String totalCharge) {
        return String.format("You owed %s\n", totalCharge);
    }

    @Override
    protected String generateTitle(String name) {
        return String.format("Rental Record for %s\n", name);
    }
}