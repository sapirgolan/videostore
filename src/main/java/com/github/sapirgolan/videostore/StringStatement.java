package com.github.sapirgolan.videostore;

import java.util.Enumeration;

public class StringStatement {
    private final Customer customer;

    public StringStatement(Customer customer) {
        this.customer = customer;
    }

    public String statement() {
        final Enumeration rentals = customer.getRentals().elements();
        String result = generateTitle(customer.getName());

        while (rentals.hasMoreElements()) {
            final Rental each = (Rental) rentals.nextElement();

            result += generateRentEntry(each.getMovie().getTitle(), String.valueOf(each.getCharge()));
        }

        result += generateTotalCharge(String.valueOf(customer.getTotalCharge()));
        result += generateTotalFrequentPoints(String.valueOf(customer.getTotalFrequentRenterPoints()));

        return result;
    }

    private String generateRentEntry(String title, String charge) {
        return String.format("\t%s\t%s\n", title, charge);
    }

    private String generateTotalFrequentPoints(String totalFrequentRenterPoints) {
        return String.format("You earned %s frequent renter points\n", totalFrequentRenterPoints);
    }

    private String generateTotalCharge(String totalCharge) {
        return String.format("You owed %s\n", totalCharge);
    }

    private String generateTitle(String name) {
        return String.format("Rental Record for %s\n", name);
    }
}