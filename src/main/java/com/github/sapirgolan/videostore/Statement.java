package com.github.sapirgolan.videostore;

import java.util.Enumeration;

/**
 * Created by I062070 on 22/03/2017.
 */
public abstract class Statement {
    protected final Customer customer;

    public Statement(Customer customer) {
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

    protected abstract String generateRentEntry(String title, String charge);

    protected abstract String generateTotalFrequentPoints(String totalFrequentRenterPoints);

    protected abstract String generateTotalCharge(String totalCharge);

    protected abstract String generateTitle(String name);
}
