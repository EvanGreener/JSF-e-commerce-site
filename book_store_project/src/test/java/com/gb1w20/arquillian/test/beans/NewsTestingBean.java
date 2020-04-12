/*
 *All test beans belong to this package
 */
package com.gb1w20.arquillian.test.beans;

/**
 * Bean used for the news parameterized test
 * @author Giancarlo Biasiucci
 * @version April 11, 2020
 */
public class NewsTestingBean {


    public int newsID;
    public String expectedStatus;
    
    /**
     * All necessary values to be incorporated and tested for are inserted
     * @param newsID
     * @param expectedStatus
     */
    public NewsTestingBean(int newsID, String expectedStatus)
    {
        this.newsID = newsID;
        this.expectedStatus = expectedStatus;
    }
}
