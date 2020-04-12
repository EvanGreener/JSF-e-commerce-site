/*
 *All test beans belong to this package
 */
package com.gb1w20.arquillian.test.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bean used only for the purpose of performing arquillian tests on the
 * orderItem controller class
 *
 * @author shruti Pareek
 */
public class OrderItemTestingBean {
    
    private final static Logger LOG = LoggerFactory.getLogger(OrderItemTestingBean.class);

    public int itemId;
    public String expectedStatus;

    /**
     * Constructor takes all necessary input needed for testing
     *
     * @param itemId
     * @param expectedStatus
     */
    public OrderItemTestingBean(int itemId, String expectedStatus) {
        LOG.debug("OrderItemTestingBean");
        this.itemId = itemId;
        this.expectedStatus = expectedStatus;
    }
}
