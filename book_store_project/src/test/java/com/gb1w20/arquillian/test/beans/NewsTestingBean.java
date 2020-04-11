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
public class NewsTestingBean {
    public int newsID;
    public String expectedStatus;
    
    public NewsTestingBean(int newsID, String expectedStatus)
    {
        this.newsID = newsID;
        this.expectedStatus = expectedStatus;
    }
}
