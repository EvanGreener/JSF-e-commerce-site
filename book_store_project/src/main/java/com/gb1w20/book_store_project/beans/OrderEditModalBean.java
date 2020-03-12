package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.Orders;
import com.gb1w20.book_store_project.jpa_controllers.OrdersJpaController;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author 1733408
 */

@Named("modalBean")
@SessionScoped
public class OrderEditModalBean implements Serializable {
    
    private final static Logger LOG = LoggerFactory.getLogger(OrderEditModalBean.class);
    private String query = "";
    private Orders currentOrder;
    
    @Inject
    private OrdersJpaController orderCtrl;
    
    @PostConstruct
     public void init() {
          LOG.debug("Init called!");
     }
    
    public String getQuery()
    {
        return query;
    }
    
    public void setQuery(String newVal)
    {
        query = newVal;
    }
    
    public Orders getCurrentOrder()
    {
        return currentOrder;
    }
    
    public void onEdit(int id) {
          LOG.debug("Edit called!");
          currentOrder = orderCtrl.findOrders(id);
     }
    
}
