/*
 *All test beans belong to this package
 */
package com.gb1w20.arquillian.test.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bean used only for the purpose of performing arquillian tests on the ads
 * controller class
 *
 * @author giancarlo, shruti Pareek
 */
public class AdsTestingBean {
    
    private final static Logger LOG = LoggerFactory.getLogger(AdsTestingBean.class);
    
    public int adID;
    public String expectedStatus;
    public int expectedCount;

    /**
     * Constructor takes all necessary input needed for testing
     *
     * @param adID
     * @param expectedStatus
     * @param expectedCount
     */
    public AdsTestingBean(int adID, String expectedStatus, int expectedCount) {
        LOG.debug("AdsTestingBean");
        this.adID = adID;
        this.expectedStatus = expectedStatus;
        this.expectedCount = expectedCount;
    }

}
