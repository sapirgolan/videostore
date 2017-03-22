package com.github.sapirgolan.videostore;

/**
 * Created by I062070 on 22/03/2017.
 */
public class HtmlStatement extends Statement{
    public HtmlStatement(Customer customer) {
        super(customer);
    }

    protected String generateRentEntry(String title, String charge) {
        return String.format("%s: %s<BR>\n", title, charge);
    }

    protected String generateTotalFrequentPoints(String totalFrequentRenterPoints) {
        return String.format("On this rental you earned <EM>%s</EM> frequent renter points<P>", totalFrequentRenterPoints);
    }

    protected String generateTotalCharge(String totalCharge) {
        return String.format("<P>You owe <EM>%s</EM><P>\n", totalCharge);
    }

    protected String generateTitle(String name) {
        return String.format("<H1>Rentals for <EM>%s</EM></H1><P>\n", name);
    }
}
