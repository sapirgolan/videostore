package com.github.sapirgolan.videostore;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * Created by I062070 on 01/03/2017.
 */
public class VideoStoreTest {

    private Customer classUnderTest;

    @Before
    public void setUp() {
        classUnderTest = new Customer("Fred");
    }

    @Test
    public void testSingleNewReleaseStatement() {
        classUnderTest.addRental(new Rental(new Movie("The Cell", Movie.NEW_RELEASE), 3));
        assertThat(classUnderTest.statement(), is("Rental Record for Fred\n\tThe Cell\t9.0\nYou owed 9.0\nYou earned 2 frequent renter points\n"));
    }

    @Test
    public void testDualNewReleaseStatement() {
        classUnderTest.addRental(new Rental(new Movie("The Cell", Movie.NEW_RELEASE), 3));
        classUnderTest.addRental(new Rental(new Movie("The Tigger Movie", Movie.NEW_RELEASE), 3));
        assertThat(classUnderTest.statement(), is("Rental Record for Fred\n\tThe Cell\t9.0\n\tThe Tigger Movie\t9.0\nYou owed 18.0\nYou earned 4 frequent renter points\n"));
    }

    @Test
    public void testSingleChildrensStatement() {
        classUnderTest.addRental(new Rental(new Movie("The Tigger Movie", Movie.CHILDRENS), 3));
        assertThat(classUnderTest.statement(), is("Rental Record for Fred\n\tThe Tigger Movie\t1.5\nYou owed 1.5\nYou earned 1 frequent renter points\n"));
    }

    @Test
    public void testMultipleRegularStatement() {
        classUnderTest.addRental(new Rental(new Movie("Plan 9 from Outer Space", Movie.REGULAR), 1));
        classUnderTest.addRental(new Rental(new Movie("8 1/2", Movie.REGULAR), 2));
        classUnderTest.addRental(new Rental(new Movie("Eraserhead", Movie.REGULAR), 3));

        assertThat(classUnderTest.statement(),
                is("Rental Record for Fred\n\tPlan 9 from Outer Space\t2.0\n\t8 1/2\t2.0\n\tEraserhead\t3.5\nYou owed 7.5\nYou earned 3 frequent renter points\n"));
    }
}