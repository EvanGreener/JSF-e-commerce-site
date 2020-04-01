/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.entities.OrderItem;
import com.gb1w20.book_store_project.entities.Orders;
import com.gb1w20.book_store_project.jpa_controllers.OrderItemJpaController;
import com.gb1w20.book_store_project.jpa_controllers.OrdersJpaController;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Saad
 */
@Named("OrderPagebb")
@SessionScoped
public class OrderPageBackingBean implements Serializable {

    @Inject
    private OrdersJpaController orderCtrl;

    @Inject
    private OrderItemJpaController orderItemCtrl;

    private Orders order;
    private List<OrderItem> orderItems;

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
        this.setOrderItems(order.getOrderItems());
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderPageBackingBean other = (OrderPageBackingBean) obj;
        if (!Objects.equals(this.order, other.order)) {
            return false;
        }
        if (!Objects.equals(this.orderItems, other.orderItems)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrderPageBackingBean{" + "order=" + order + ", orderItems=" + orderItems + '}';
    }

}
