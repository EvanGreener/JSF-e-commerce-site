package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.entities.Orders;
import com.gb1w20.book_store_project.jpa_controllers.OrdersJpaController;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Backing bean for the order entity
 * @author Giancarlo Biasiucci
 * @version April 4, 2020
 */
@Named("orderBacking")
@RequestScoped
public class OrderBackingBean implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(OrderBackingBean.class);

    @Inject
    private OrdersJpaController ordersJpaController;

    private Orders order;

    /**
     * In the event where the order is null, it is created from scratch to avoid a NullPointerException.
     *
     * @return The order being managed by the bean
     */
    public Orders getOrder() {
        if (order == null) {
            order = new Orders();
        }
        return order;
    }

    /**
     * Creates the order and saves it to the database
     *
     * @return
     * @throws Exception
     */
    public String createOrder() throws Exception {
        ordersJpaController.create(order);
        return null;
    }
    
    /**
     * Marks an order as removed (changes removal status to true)
     * @param order
     * @return
     * @throws Exception 
     */
    public String removeOrder(Orders order) throws Exception {
        order.setIsRemoved(true);
        order.setLastUpdated(new Date());
        ordersJpaController.edit(order);
        return null;
    }
    
    /**
     * Marks an order as not removed (changes removal status to false)
     * @param order
     * @return
     * @throws Exception 
     */
    public String addOrder(Orders order) throws Exception {
        order.setIsRemoved(false);
        order.setLastUpdated(new Date());
        ordersJpaController.edit(order);
        return null;
    }
    
    /**
     * Determines whether an order should be added or removed based on its current removal status
     * whenever the corresponding link in the managerial order page is clicked
     * (changed to other state, if true than changed to false and vice versa)
     * @param order
     * @return
     * @throws Exception 
     */
    public String addOrRemoveOrder(Orders order) throws Exception
    {
        if (order.getIsRemoved())
        {
            addOrder(order);
        }
        else
        {
            removeOrder(order);
        }
        FacesContext.getCurrentInstance().getExternalContext().redirect("managerOrders.xhtml");
        return null;
    }
    
    /**
     * Returns a String indicating what will occur when the corresponding link in the managerial
     * order page is clicked
     * @param isRemoved
     * @return
     * @throws Exception 
     */
    public String getRemovalStatus(boolean isRemoved) throws Exception {
        if (isRemoved)
        {
            return "Add Order";
        }
        else
        {
            return "Remove Order";
        }
    }
}
