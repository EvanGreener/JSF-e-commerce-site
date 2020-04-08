/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    public ReviewTestingBean(String isbn, int expectedReviews, double expectedAverage, int clientID,
            int expectedClientReviews)
    {
        this.isbn = isbn;
        this.expectedReviews = expectedReviews;
        this.expectedAverage = expectedAverage;
        this.clientID = clientID;
        this.expectedClientReviews = expectedClientReviews;
    }
}
