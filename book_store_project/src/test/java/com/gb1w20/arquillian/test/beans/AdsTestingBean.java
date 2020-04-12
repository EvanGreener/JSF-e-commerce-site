/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.arquillian.test.beans;

import com.gb1w20.book_store_project.entities.Ads;
import java.util.List;

/**
 *
 * @author giancarlo, shruti Pareek
 */
public class AdsTestingBean {
    public int adID;
    public String expectedStatus;
    public int expectedCount;
    
    public AdsTestingBean(int adID, String expectedStatus,int expectedCount)
    {
        this.adID = adID;
        this.expectedStatus = expectedStatus;
        this.expectedCount = expectedCount;
    }
    
}
