/*
 *All test beans belong to this package
 */
package com.gb1w20.arquillian.test.beans;

/**
 *
 * @author giancarlo
 */
public class ReviewTestingBean {

    public String isbn;
    public int expectedReviews;
    public double expectedAverage;
    public int clientID;
    public int expectedClientReviews;

    /**
     * Constructor takes all necessary input needed for testing
     *
     * @param isbn
     * @param expectedReviews
     * @param expectedAverage
     * @param clientID
     * @param expectedClientReviews
     */
    public ReviewTestingBean(String isbn, int expectedReviews, double expectedAverage, int clientID,
            int expectedClientReviews) {
        this.isbn = isbn;
        this.expectedReviews = expectedReviews;
        this.expectedAverage = expectedAverage;
        this.clientID = clientID;
        this.expectedClientReviews = expectedClientReviews;
    }
}
