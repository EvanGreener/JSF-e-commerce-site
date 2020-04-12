package com.gb1w20.arquillian.test.beans;

/**
 * Bean used for the order sale parameterized test
 * @author Giancarlo Biasiucci
 * @version April 11, 2020
 */
public class OrderSaleTestingBean {
    public String isbn;
    public double expectedTotal;
    
    /**
     * All necessary values to be incorporated and tested for are inserted
     * @param isbn
     * @param expectedTotal 
     */
    public OrderSaleTestingBean(String isbn, double expectedTotal)
    {
        this.isbn = isbn;
        this.expectedTotal = expectedTotal;
    }
}
