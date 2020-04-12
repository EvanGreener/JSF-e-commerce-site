/*
 *All test beans belong to this package
 */
package com.gb1w20.arquillian.test.beans;

import com.gb1w20.book_store_project.entities.Orders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bean used only for the purpose of performing arquillian tests on the orders
 * controller class
 *
 * @author Shruti pareek
 */
public class OrdersTestingBean {

    private final static Logger LOG = LoggerFactory.getLogger(OrdersTestingBean.class);

    public int testClientId;
    public String expectedEmail;
    public int testOrderId;
    public int expectedOrderItemCount;
    public String expectedStatus;
    public String testQuery;
    public String testSearchBy;
    public Orders expectedOrder;

    /**
     * Constructor takes all necessary input needed for testing
     *
     * @param testClientId
     * @param expectedEmail
     * @param testOrderId
     * @param expectedOrderItemCount
     * @param expectedStatus
     * @param testQuery
     * @param testSearchBy
     * @param expectedOrder
     */
    public OrdersTestingBean(int testClientId, String expectedEmail, int testOrderId, int expectedOrderItemCount, String expectedStatus, String testQuery, String testSearchBy, Orders expectedOrder) {
        LOG.debug("OrdersTestingBean");
        this.testClientId = testClientId;
        this.expectedEmail = expectedEmail;
        this.testOrderId = testOrderId;
        this.expectedOrderItemCount = expectedOrderItemCount;
        this.expectedStatus = expectedStatus;
        this.testQuery = testQuery;
        this.testSearchBy = testSearchBy;
        this.expectedOrder = expectedOrder;
    }

}
