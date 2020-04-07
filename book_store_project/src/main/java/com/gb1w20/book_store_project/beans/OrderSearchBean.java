
package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.Orders;
import com.gb1w20.book_store_project.jpa_controllers.OrdersJpaController;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bean for updating the order search criteria (search by email) on the managerial order page
 * @author Giancarlo Biasiucci
 * @version April 4, 2020
 */
@Named("orderSearch")
@SessionScoped
public class OrderSearchBean implements Serializable {
    
    private final static Logger LOG = LoggerFactory.getLogger(OrderSearchBean.class);
    private String query = "";
    private List<Orders> searchResults;
    private Orders currentOrder;
    
    @Inject
    private OrdersJpaController orderCtrl;
    
    @PostConstruct
     public void init() {
          LOG.debug("Init called!");
          updateBean();
     }
    
    public String getQuery()
    {
        return query;
    }

     public void setQuery(String query) {
          this.query = query;
     }
    
    
    public List<Orders> getSearchResults() {
          return searchResults;
    }
    
    public Orders getCurrentOrder()
    {
        return this.currentOrder;
    }
    
    /**
     * Updates the bean with the new search query, and performs the search with the new query
     */
    public void updateBean() {
          LOG.debug("Update called");
          LOG.debug("Query: " + this.query);
          searchResults = orderCtrl.searchOrders(this.query);
     }
    
     public void onEdit(int id) {
          LOG.debug(id + "");
          currentOrder = orderCtrl.findOrders(id);
     }
}
