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
public class BookSearchTestingBean {
    
    public String query;
    public String searchBy;
    public int expectedResults;
    public int expectedResultsAll;
    
    public BookSearchTestingBean(String query, String searchBy, int expectedResults,
            int expectedResultsAll)
    {
        this.query = query;
        this.searchBy = searchBy;
        this.expectedResults = expectedResults;
        this.expectedResultsAll = expectedResultsAll;
    }
    
}
