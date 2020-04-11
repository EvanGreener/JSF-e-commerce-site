package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.OrderItem;
import com.gb1w20.book_store_project.entities.Orders;
import com.gb1w20.book_store_project.jpa_controllers.OrderItemJpaController;
import com.gb1w20.book_store_project.jpa_controllers.OrdersJpaController;
import com.gb1w20.book_store_project.util.MessageLoader;
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
 * Bean for editing an existing order's information
 * @author Giancarlo Biasiucci
 * @version April 4, 2020
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
    
    /**
     * Saves the current order information to be displayed in the "Edit Order" modal
     * when the corresponding button is clicked
     * @param id 
     */
    public void onEdit(int id) {
          LOG.debug("Edit called!");
          LOG.debug("ID we searching for: " + id);
          currentOrder = orderCtrl.findOrders(id);
          LOG.debug("Current order ID " + currentOrder.getOrderID());
          LOG.debug("Current order email " + currentOrder.getClient().getEmail());
    }
    
    /**
     * Saves the current order item information to be displayed in the "Edit Item" modal
     * when the corresponding button is clicked
     * @param id 
     */
    public void onItemEdit(int id) {
          LOG.debug("Item edit called!");
          LOG.debug("ID we searching for: " + id);
          currentItem = orderItemCtrl.findOrderItem(id);
          newSalePriceStr = currentItem.getPriceSold() + "";
          LOG.debug("Current item ID " + currentItem.getItemID());
          LOG.debug("Current item price " + currentItem.getPriceSold());
    }
    
    /**
     * Edits the existing order item information with what is present in the fields in the "Edit Item" modal
     * and updates the entry in the database
     * @return
     * @throws Exception 
     */
    public String onSubmitEdit() throws Exception {
        LOG.debug("onSubmitEdit called");
        currentItem.setPriceSold(Double.parseDouble(newSalePriceStr));
        LOG.debug("The new price of the item is: " + currentItem.getPriceSold());
        orderItemCtrl.edit(currentItem);
        LOG.debug("Item has been edited");
        LOG.debug("The new price of the item is: " + currentItem.getPriceSold());
        return null;
    }
    
    /**
     * Validates that the data entered in the field is a valid double (for new sale price)
     * @param context
     * @param component
     * @param value 
     */
    public void validateDouble(FacesContext context, UIComponent component, Object value)
    {
        String doubleStr = (String)value;
        if (doubleStr.isBlank() || doubleStr.isEmpty() || doubleStr == null)
        {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "valueNotNull", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        try
        {
            double test = Double.parseDouble(doubleStr);
        }
        catch(NumberFormatException nfe)
        {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "invalidDouble", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
