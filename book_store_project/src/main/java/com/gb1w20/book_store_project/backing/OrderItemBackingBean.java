package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.beans.BookBean;
import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.entities.OrderItem;
import com.gb1w20.book_store_project.jpa_controllers.BookJpaController;
import com.gb1w20.book_store_project.jpa_controllers.OrderItemJpaController;
import com.gb1w20.book_store_project.util.MessageLoader;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
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

    /**
     * Gets the removal status of the current order item
     * @param isRemoved
     * @return
     * @throws Exception 
     * By: Giancarlo Biasiucci
     */
    public String getRemovalStatus(boolean isRemoved) throws Exception {
        if (isRemoved) {
            return MessageLoader.getString("com.gb1w20.bundles.messages", "addItem", null);
        } else {
            return MessageLoader.getString("com.gb1w20.bundles.messages", "removeItem", null);
        }
    }

    /**
     * Removes an order item - changes removal status to true
     * @param item
     * @return
     * @throws Exception 
     * By: Giancarlo Biasiucci
     */
    public String removeItem(OrderItem item) throws Exception {
        item.setIsRemoved(true);
        item.setLastUpdated(new Date());
        orderItemJpaController.edit(item);
        return null;
    }

    /**
     * Adds an order item - changes its removal status to false
     * @param item
     * @return
     * @throws Exception 
     */
    public String addItem(OrderItem item) throws Exception {
        item.setIsRemoved(false);
        item.setLastUpdated(new Date());
        orderItemJpaController.edit(item);
        return null;
    }
    
    /**
     * Determines whether an order item should be "added" or "removed" depending on its
     * current status when the corresponding link is clicked
     * @param item
     * @return
     * @throws Exception 
     * By: Giancarlo Biasiucci
     */
    public String addOrRemoveItem(OrderItem item) throws Exception {
        if (item.getIsRemoved()) {
            addItem(item);
        } else {
            removeItem(item);
        }
        FacesContext.getCurrentInstance().getExternalContext().redirect("managerOrders.xhtml");
        return null;
    }
 
}
