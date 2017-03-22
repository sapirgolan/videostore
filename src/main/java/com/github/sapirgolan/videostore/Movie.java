package com.github.sapirgolan.videostore;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;
    Price price;

    public Movie(final String title, final int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(final int code) {
        priceCode = code;
        switch (code){
            case REGULAR:
                price = new RegularPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasesPrice();
                break;
            case CHILDRENS:
                price = new ChildrenPrice();
                break;
            default:
                throw new IllegalArgumentException("Not valid price code");
        }
    }

    public String getTitle() {
        return title;
    }

    public int getFrequentRenterPoints(int daysRented) {
        if (getPriceCode() == NEW_RELEASE && daysRented > 1) {
            return 2;
        }
        return 1;
    }

    public double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }
}