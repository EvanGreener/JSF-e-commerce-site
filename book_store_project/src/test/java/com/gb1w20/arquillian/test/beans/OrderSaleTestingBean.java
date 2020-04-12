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
public class OrderSaleTestingBean {
    public String isbn;
    public double expectedTotal;
    
    public OrderSaleTestingBean(String isbn, double expectedTotal)
    {
        this.isbn = isbn;
        this.expectedTotal = expectedTotal;
    }
}
