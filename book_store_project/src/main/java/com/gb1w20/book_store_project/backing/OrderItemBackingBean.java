package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.entities.OrderItem;
import com.gb1w20.book_store_project.jpa_controllers.OrderItemJpaController;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("orderItemBacking")
@RequestScoped
public class OrderItemBackingBean implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(OrderItemBackingBean.class);

    @Inject
    private OrderItemJpaController orderItemJpaController;

    private OrderItem orderItem;

    /**
     * OrderItems created if it does not exist.
     *
     * @return
     */
    public OrderItem getOrderItem() {
        if (orderItem == null) {
            orderItem = new OrderItem();
        }
        return orderItem;
    }

    /**
     * Save the current orderItem to the db
     *
     * @return
     * @throws Exception
     */
    public String createOrderItem() throws Exception {
        orderItemJpaController.create(orderItem);
        return null;
    }
}
