/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.MailSender;
import com.gb1w20.book_store_project.beans.MailBean;
import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.entities.Clients;
import com.gb1w20.book_store_project.entities.OrderItem;
import com.gb1w20.book_store_project.entities.Orders;
import com.gb1w20.book_store_project.jpa_controllers.BookJpaController;
import com.gb1w20.book_store_project.jpa_controllers.ClientsJpaController;
import com.gb1w20.book_store_project.jpa_controllers.OrderItemJpaController;
import com.gb1w20.book_store_project.jpa_controllers.OrdersJpaController;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
 * @author Saad
 */
@Named("cbb")
@SessionScoped
public class CartBackingBean implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(CartBackingBean.class);

    private List<Book> CartItems = new ArrayList<Book>();
    private String creditCardNumber;
    private String expiryMonth;
    private String expiryYear;

    @Inject
    private BookJpaController bookCtrlr;

    @Inject
    private OrdersJpaController orderCtrl;

    @Inject
    private OrderItemJpaController orderItemCtrl;

    @Inject
    private ClientsJpaController clientCtrl;

    @Inject
    private TaxBackingBean taxbb;

    @Inject
    private MailBean mailBean;

    @Inject
    private OrderPageBackingBean orderPage;
    
    public List<Book> getCartItems() {
        return this.CartItems;
    }

    public void setCartItems(List<Book> CartItems) {
        this.CartItems = CartItems;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public int getCartSize() {
        return getCartItems().size();
    }

    public void setCreditCardNumber(String newValue) {
        creditCardNumber = newValue;
    }

    public String getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(String newValue) {
        expiryYear = newValue;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(String newValue) {
        expiryMonth = newValue;
    }

    public Boolean isCartEmpty() {
        List<Book> cartList = this.getCartItems();
        return cartList.size() < 1;
    }

    public double getCartTotal() {
        List<Book> cartList = this.getCartItems();
        double cartTotal = 0.00;
        for (Book cartBook : cartList) {
            LOG.info("cart has " + cartBook.getListPrice());
            cartTotal += cartBook.getListPrice().doubleValue();
        }
        cartTotal = Math.round(cartTotal * 100.0) / 100.0;
        return cartTotal;
    }

    public double getCartTotalAfterTax() {
        double total = 0;
        for (int i = 0; i < this.getCartItems().size(); i++) {
            total += this.calculateItemTaxPrice(this.getCartItems().get(i));
        }
        return total;
    }

    public double calculateItemTaxPrice(Book book) {
        return taxbb.getTotalWithTaxByProvince(book.getListPrice().doubleValue());
    }

    public void addBookToCart(Book addingBook) {
        LOG.info("adding");
        List<Book> cartList = this.getCartItems();
        if (!cartList.contains(addingBook)) {
            cartList.add(addingBook);
            LOG.info("cart has " + cartList.size());
            this.setCartItems(cartList);
        }
    }

    public void checkSignedIn(boolean signedIn) {
        LOG.debug(signedIn ? "Signed in" : "not signed in");
    }

    public String removeBookFromCart(Book removingBook) throws Exception {
        List<Book> cartList = this.getCartItems();
        if (cartList.contains(removingBook)) {
            cartList.remove(removingBook);
            LOG.info("cart has " + cartList.size());
            this.setCartItems(cartList);
        }
        FacesContext.getCurrentInstance().getExternalContext().redirect("cart.xhtml");
        return "cart.xhtml";
    }

    public void validateExpiryYear(FacesContext context, UIComponent component, Object value) {
        String year = (String) value;
        try {
            for (char c : year.toCharArray()) {
                Integer.parseInt(Character.toString(c));
            }
        } catch (NumberFormatException nfe) {
            String message = context.getApplication().evaluateExpressionGet(context, "Invalid year: contains non-numeric characters", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
        int yearInt = Integer.parseInt(year);
        if (!(yearInt >= 2020)) {
            String message = context.getApplication().evaluateExpressionGet(context, "Invalid year: must be either present or future year", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
    }

    public void validateExpiryMonth(FacesContext context, UIComponent component, Object value) {
        String month = (String) value;
        try {
            for (char c : month.toCharArray()) {
                Integer.parseInt(Character.toString(c));
            }
        } catch (NumberFormatException nfe) {
            String message = context.getApplication().evaluateExpressionGet(context, "Invalid month: contains non-numeric characters", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
        int monthInt = Integer.parseInt(month);
        if (!(monthInt >= 1 && monthInt <= 12)) {
            String message = context.getApplication().evaluateExpressionGet(context, "Invalid month: must be between 1 and 12", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
    }

    public void validateNotNull(FacesContext context, UIComponent component, Object value) {
        String input = (String) value;
        if (input.isBlank() || input.isEmpty() || input == null) {
            String message = context.getApplication().evaluateExpressionGet(context, "Value must not be left blank", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
    }

    public void validateCardNumber(FacesContext context, UIComponent component, Object value) {
        String number = (String) value;
        try {
            for (char c : number.toCharArray()) {
                Integer.parseInt(Character.toString(c));
            }
        } catch (NumberFormatException nfe) {
            String message = context.getApplication().evaluateExpressionGet(context, "Invalid card number: contains non-numeric characters", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
        if (!luhnCheck(number)) {
            String message = context.getApplication().evaluateExpressionGet(context, "Invalid credit card number", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
    }

    private boolean luhnCheck(String cardNumber) {
        int sum = 0;

        for (int i = cardNumber.length() - 1; i >= 0; i -= 2) {
            sum += Integer.parseInt(cardNumber.substring(i, i + 1));
            if (i > 0) {
                int d = 2 * Integer.parseInt(cardNumber.substring(i - 1, i));
                if (d > 9) {
                    d -= 9;
                }
                sum += d;
            }
        }

        return sum % 10 == 0;
    }

    public String redirectToFinalizePage(Boolean isSignedIn) {
        LOG.info("user is " + isSignedIn);
        return isSignedIn ? "index.xhtml" : "signIn.xhtml";
    }

    public String finalizePurchase(String email) throws Exception {
        Orders newOrder = new Orders();
        Clients client = clientCtrl.findClientByEmail(email);
        newOrder.setDateCreated(new Date());
        newOrder.setIsRemoved(false);
        newOrder.setLastUpdated(new Date());
        newOrder.setClient(client);
        newOrder.setClientID(client.getClientID());
        List<OrderItem> newOrderItems = new ArrayList<OrderItem>();
        for (Book book : CartItems) {
            OrderItem oi = new OrderItem();
            oi.setOrderID(newOrder.getOrderID());
            oi.setPriceSold(this.calculateItemTaxPrice(book));
            oi.setLastUpdated(new Date());
            oi.setIsRemoved(false);
            oi.setIsbn(book.getIsbn());
            oi.setBook(book);
            orderItemCtrl.create(oi);
            newOrderItems.add(oi);
        }
        newOrder.setOrderItemsCollection(newOrderItems);
        orderCtrl.create(newOrder);
        sendEmail(email,newOrder.getOrderID());
        CartItems.clear();
        orderPage.setOrder(newOrder);
        FacesContext.getCurrentInstance().getExternalContext().redirect("myOrder.xhtml");
        return "myOrder.xhtml";
    }

    private void sendEmail(String receiver, Integer orderID) {
        MailSender sender = new MailSender();
        mailBean.setSendTo(receiver);
        mailBean.setSubject("ORDER CONFIRMATION #" + orderID);
        mailBean.setPlainOrderTextMsg();
        mailBean.setHtmlOrderTextMsg();
        sender.sendOrderConfirmationEmail(mailBean);
    }
}
