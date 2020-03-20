package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.OrderItem;
import com.gb1w20.book_store_project.entities.Orders;
import com.gb1w20.book_store_project.jpa_controllers.OrderItemJpaController;
import com.gb1w20.book_store_project.jpa_controllers.OrdersJpaController;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author 1733408
 */

@Named("orderEdit")
@SessionScoped
public class OrderEditModalBean implements Serializable {
    
    private final static Logger LOG = LoggerFactory.getLogger(OrderEditModalBean.class);
    private String query = "";
    private Orders currentOrder;
    private OrderItem currentItem;
    private BigDecimal newSalePrice;
    private String newSalePriceStr;
    
    @Inject
    private OrdersJpaController orderCtrl;
    
    @Inject
    private OrderItemJpaController orderItemCtrl;
    
    @PostConstruct
     public void init() {
          LOG.debug("Init called!");
     }
     
     public BigDecimal getNewSalePrice()
     {
         return newSalePrice;
     }
     
     public void setNewSalePrice(BigDecimal newVal)
     {
         newSalePrice = newVal;
     }
     
     public String getNewSalePriceStr()
     {
         return newSalePriceStr;
     }
     
     public void setNewSalePriceStr(String newVal)
     {
         newSalePriceStr = newVal;
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
    
    public OrderItem getCurrentItem()
    {
        return currentItem;
    }
    
    public void onEdit(int id) {
          LOG.debug("Edit called!");
          LOG.debug("ID we searching for: " + id);
          currentOrder = orderCtrl.findOrders(id);
          LOG.debug("Current order ID " + currentOrder.getOrderID());
          LOG.debug("Current order email " + currentOrder.getClient().getEmail());
    }
    
    public void onItemEdit(int id) {
          LOG.debug("Item edit called!");
          LOG.debug("ID we searching for: " + id);
          currentItem = orderItemCtrl.findOrderItem(id);
          newSalePriceStr = currentItem.getPriceSold() + "";
          LOG.debug("Current item ID " + currentItem.getItemID());
          LOG.debug("Current item price " + currentItem.getPriceSold());
    }
    
    public String onSubmitEdit() throws Exception {
        LOG.debug("onSubmitEdit called");
        currentItem.setPriceSold(Double.parseDouble(newSalePriceStr));
        LOG.debug("The new price of the item is: " + currentItem.getPriceSold());
        orderItemCtrl.edit(currentItem);
        LOG.debug("Item has been edited");
        LOG.debug("The new price of the item is: " + currentItem.getPriceSold());
        return null;
    }
    
    public void validateDouble(FacesContext context, UIComponent component, Object value)
    {
        String doubleStr = (String)value;
        if (doubleStr.isBlank() || doubleStr.isEmpty() || doubleStr == null)
        {
            String message = context.getApplication().evaluateExpressionGet(context, "Value must not be left blank", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
        try
        {
            double test = Double.parseDouble(doubleStr);
        }
        catch(NumberFormatException nfe)
        {
            String message = context.getApplication().evaluateExpressionGet(context, "Invalid double", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
    }
}
