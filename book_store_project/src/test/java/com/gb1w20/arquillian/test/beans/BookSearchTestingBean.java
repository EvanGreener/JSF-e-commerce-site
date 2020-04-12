package com.gb1w20.arquillian.test.beans;

/**
 * Bean used for the book search parameterized test
 * @author Giancarlo Biasiucci
 * @version April 11, 2020
 */
public class BookSearchTestingBean {
    
    public String query;
    public String searchBy;
    public int expectedResults;
    public int expectedResultsAll;
    
    /**
     * All necessary values to be incorporated and tested for are inserted
     * @param query
     * @param searchBy
     * @param expectedResults
     * @param expectedResultsAll 
     */
    public BookSearchTestingBean(String query, String searchBy, int expectedResults,
            int expectedResultsAll)
    {
        this.query = query;
        this.searchBy = searchBy;
        this.expectedResults = expectedResults;
        this.expectedResultsAll = expectedResultsAll;
    }
    
}
