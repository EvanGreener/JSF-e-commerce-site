/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.entities;

/**
 *
 * @author Cedric Richards
 */
public class OrderItemTotal {
    private OrderItem orderItem;
    private double total;
    public OrderItemTotal(OrderItem orderItem, double total)
    {
        this.orderItem = orderItem;
        this.total = total;
    }
    public OrderItem getOrderItem()
    {
        return orderItem;
    }
    public double getTotal()
    {
        return this.total;
    }
}
