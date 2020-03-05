package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.entities.Orders;
import com.gb1w20.book_store_project.jpa_controllers.OrdersJpaController;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("orderBacking")
@RequestScoped
public class OrderBackingBean implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(OrderBackingBean.class);

    @Inject
    private OrdersJpaController ordersJpaController;

    private Orders order;

    /**
     * Orders created if it does not exist.
     *
     * @return
     */
    public Orders getOrder() {
        if (order == null) {
            order = new Orders();
        }
        return order;
    }

    /**
     * Save the current order to the db
     *
     * @return
     * @throws Exception
     */
    public String createOrder() throws Exception {
        ordersJpaController.create(order);
        return null;
    }
}
