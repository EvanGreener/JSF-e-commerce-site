/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.arquillian.test.beans;

import com.gb1w20.book_store_project.entities.Ads;
import com.gb1w20.book_store_project.entities.Authors;
import java.util.List;

/**
 *
 * @author shruti Pareek
 */
public class OrderItemTestingBean {

    public int itemId;
    public String expectedStatus;

    public OrderItemTestingBean(int itemId, String expectedStatus) {
        this.itemId = itemId;
        this.expectedStatus = expectedStatus;
    }
}
