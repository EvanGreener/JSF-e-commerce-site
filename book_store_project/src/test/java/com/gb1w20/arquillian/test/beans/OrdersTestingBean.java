/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.arquillian.test.beans;

import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.entities.Clients;
import com.gb1w20.book_store_project.entities.OrderItem;
import com.gb1w20.book_store_project.entities.Orders;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Shruti pareek
 */
public class OrdersTestingBean {

 

    private final static Logger LOG = LoggerFactory.getLogger(OrdersTestingBean.class);

    /**
     *
     */
    public int testClientId;

    /**
     *
     */
    public String expectedEmail;

    /**
     *
     */
    public int testOrderId;

    /**
     *
     */
    public int expectedOrderItemCount;

    /**
     *
     */
    public String expectedStatus;

    /**
     *
     */
    public String testQuery;

    /**
     *
     */
    public String testSearchBy;

    /**
     *
     */
    public Orders expectedOrder;

    /**
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
