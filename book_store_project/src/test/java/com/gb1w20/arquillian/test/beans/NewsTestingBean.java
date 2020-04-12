/*
 *All test beans belong to this package
 */
package com.gb1w20.arquillian.test.beans;

/**
 *
 * @author giancarlo
 */
public class NewsTestingBean {


    public int newsID;
    public String expectedStatus;
    
    /**
     *
     * @param newsID
     * @param expectedStatus
     */
    public NewsTestingBean(int newsID, String expectedStatus)
    {
        this.newsID = newsID;
        this.expectedStatus = expectedStatus;
    }
}
