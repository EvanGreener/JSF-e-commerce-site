
package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.Orders;
import com.gb1w20.book_store_project.jpa_controllers.OrdersJpaController;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author 1733408
 */
@Named("orderSearch")
@SessionScoped
public class OrderSearchBean implements Serializable {
    
    private final static Logger LOG = LoggerFactory.getLogger(OrderSearchBean.class);
    private String query = "";
    private List<Orders> searchResults;
    private String searchBy;
    
    @Inject
    private OrdersJpaController bookCtrlr;
    
    public String getSearchBy()
    {
        return searchBy;
    }
    public void setSearchBy(String newValue)
    {
        this.searchBy = newValue;
    }
    public String getQuery()
    {
        return query;
    }
    public void setQuery(String newValue)
    {
        this.query = newValue;
    }
    public List<Orders> getSearchResults() {
          return searchResults;
     }
    public void onKeyUp() {
          LOG.debug("onKeyUp called");
     }
}
