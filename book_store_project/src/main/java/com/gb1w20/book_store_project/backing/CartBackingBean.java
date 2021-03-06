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
import com.gb1w20.book_store_project.entities.ClientInventory;
import com.gb1w20.book_store_project.jpa_controllers.BookJpaController;
import com.gb1w20.book_store_project.jpa_controllers.ClientsJpaController;
import com.gb1w20.book_store_project.jpa_controllers.OrderItemJpaController;
import com.gb1w20.book_store_project.jpa_controllers.OrdersJpaController;
import com.gb1w20.book_store_project.jpa_controllers.ClientInventoryJpaController;
import com.gb1w20.book_store_project.util.MessageLoader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Cart Backing Bean to keep track of all items and totals
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
    private ClientInventoryJpaController clientInventoryCtrl;
    
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

    /**
     * check if the cart is indeed empty
          * @author Saad Khan
     */
    public Boolean isCartEmpty() {
        List<Book> cartList = this.getCartItems();
        return cartList.size() < 1;
    }

    /**
     * get Total amount before taxes from cart
     * @return total amount due
          * @author Saad Khan
     */
    public double getCartTotal() {
        List<Book> cartList = this.getCartItems();
        double cartTotal = 0.00;
        for (Book cartBook : cartList) {
            LOG.info("cart has " + cartBook.getSalePrice());
            cartTotal += cartBook.getSalePrice().doubleValue();
        }
        cartTotal = Math.round(cartTotal * 100.0) / 100.0;
        return cartTotal;
    }

    /**
     * get Total amount after taxes from cart
     * @return total amount due
          * @author Saad Khan
     */
    public double getCartTotalAfterTax() {
        double total = 0;
        for (int i = 0; i < this.getCartItems().size(); i++) {
            total += this.calculateItemTaxPrice(this.getCartItems().get(i));
        }
        return total;
    }

    /**
     * calculate books price with tax
     * @return total amount
     * @author Saad Khan
     */
    public double calculateItemTaxPrice(Book book) {
        return taxbb.getTotalWithTaxByProvince(book.getSalePrice().doubleValue());
    }

    /**
     * add book item to cart
     * @param addingBook 
     * @author Saad Khan
     */
    public void addBookToCart(Book addingBook) {
        LOG.info("adding");
        List<Book> cartList = this.getCartItems();
        if (!cartList.contains(addingBook)) {
            cartList.add(addingBook);
            saveLastGenre(addingBook);
            LOG.info("cart has " + cartList.size());
            this.setCartItems(cartList);
        }
    }

    public void checkSignedIn(boolean signedIn) {
        LOG.debug(signedIn ? "Signed in" : "not signed in");
    }

     /**
     * remove book item to cart
     * @param removingBook 
     * @author Saad Khan
     */
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

    /**
     * Validates that the expiry year is legitimate and a valid year
     * By: Giancarlo Biasiucci
     * @param context
     * @param component
     * @param value 
     */
    public void validateExpiryYear(FacesContext context, UIComponent component, Object value) {
        String year = (String) value;
        try {
            for (char c : year.toCharArray()) {
                Integer.parseInt(Character.toString(c));
            }
        } catch (NumberFormatException nfe) {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "invalidYear", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        int yearInt = Integer.parseInt(year);
        if (!(yearInt >= 2020)) {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "invalidYearNum", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }

    /**
     * Validates that the expiry month is legitimate and a valid month
     * By: Giancarlo Biasiucci
     * @param context
     * @param component
     * @param value 
     */
    public void validateExpiryMonth(FacesContext context, UIComponent component, Object value) {
        String month = (String) value;
        try {
            for (char c : month.toCharArray()) {
                Integer.parseInt(Character.toString(c));
            }
        } catch (NumberFormatException nfe) {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "invalidMonth", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        int monthInt = Integer.parseInt(month);
        if (!(monthInt >= 1 && monthInt <= 12)) {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "invalidMonthNum", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
    
    /**
     * Validates that the credit card number is valid
     * By: Giancarlo Biasiucci & Saad Khan
     * @param context
     * @param component
     * @param value 
     */
    public void validateCardNumber(FacesContext context, UIComponent component, Object value) {
        String number = (String) value;
        try {
            for (char c : number.toCharArray()) {
                Integer.parseInt(Character.toString(c));
            }
        } catch (NumberFormatException nfe) {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "invalidCardFormat", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        if (!luhnCheck(number)) {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "invalidCardChars", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
    
    /**
     * Credit card luhn check. FROM: JSFSample20CustomValidator01 : CreditCardValidator
     * By: Ken Fogel
     * @param cardNumber
     * @return 
     */

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

        /**
     * Redirects user to proper page
     * By: Giancarlo Biasiucci & Saad Khan
     * @param context
     * @param component
     * @param value 
     */
    public String redirectToFinalizePage(Boolean isSignedIn) {
        LOG.info("user is " + isSignedIn);
        return isSignedIn ? "index.xhtml" : "signIn.xhtml";
    }

    /**
     * Finalizes purchase, clears cart, saves order to database
     * By: Giancarlo Biasiucci
     * @param email - Client's email
     * @return
     * @throws Exception 
     */
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
            addToClientInventory(client.getClientID(),book.getIsbn());
        }
        newOrder.setOrderItemsCollection(newOrderItems);
        orderCtrl.create(newOrder);
        sendEmail(email,newOrder.getOrderID());
        CartItems.clear();
        orderPage.setOrder(newOrder);
        FacesContext.getCurrentInstance().getExternalContext().redirect("myOrder.xhtml");
        return "myOrder.xhtml";
    }
    
    /**
     * Add Book Item to Clients Inventory
     * @param clientID
     * @param isbn
     * @throws Exception 
     */
    private void addToClientInventory(Integer clientID, String isbn) throws Exception {
        ClientInventory item = new ClientInventory();
        item.setClientID(clientID);
        item.setDatePurchased(new Date());
        item.setIsRemoved(false);
        item.setIsbn(isbn);
        item.setLastModified(new Date());
        clientInventoryCtrl.create(item);
    }

    /**
     * sends email to clients email address
     * 
     * @author Saad Khan
     * @param receiver
     * @param orderID 
     */
    private void sendEmail(String receiver, Integer orderID) {
        MailSender sender = new MailSender();
        mailBean.setSendTo(receiver);
        mailBean.setSubject("ORDER CONFIRMATION #" + orderID);
        mailBean.setPlainOrderTextMsg();
        mailBean.setHtmlOrderTextMsg();
        sender.sendOrderConfirmationEmail(mailBean);
    }

    /**
     * save last genre added to the cart as a cookie
     * @author Saad Khan
     * @param addingBook 
     */
    public void saveLastGenre(Book addingBook) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        Cookie cookie = null;
        
        LOG.info("saving genre");
        
        Cookie[] userCookies = request.getCookies();
        if (userCookies != null && userCookies.length > 0 ) {
            for (int i = 0; i < userCookies.length; i++) {
                if (userCookies[i].getName().equals("BOOK_STORE_LAST_GENRE")) {
                    cookie = userCookies[i];
                    break;
                }
            }
        }

        if (cookie != null) {
            cookie.setValue(addingBook.getGenre());
        } else {
            cookie = new Cookie("BOOK_STORE_LAST_GENRE", addingBook.getGenre());
            cookie.setPath(request.getContextPath());
        }
        
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
        response.addCookie(cookie);        
    }
    
    /**
     * get the last genre added to the cart
     * 
     * @author Saad Khan
     * @return lastGenre
     */
    public String getLastGenre(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        Cookie[] userCookies = request.getCookies();
        LOG.info("checking genre");

        String lastGenre = "";
        
        if (userCookies != null && userCookies.length > 0) {
            for (int i = 0; i < userCookies.length; i++) {
                if (userCookies[i].getName().equals("BOOK_STORE_LAST_GENRE") && !userCookies[i].getValue().equals("")) {
                    lastGenre = userCookies[i].getValue();
                    break;
                } 
            }
        }
        return lastGenre;
    }
    
    /**
     * Registration form postal code validation method, verifies that the postal code
     * entered is of a valid Canadian format.
     * @author Giancarlo Biasiucci
     * @param context
     * @param component
     * @param value 
     */
    public void validatePostalCode(FacesContext context, UIComponent component, Object value)
    {
        String postalCode = (String)value;
        UIInput postalCodeInput = (UIInput)component.findComponent("postalCode");
        boolean validPostalCode = Pattern.matches("[a-zA-Z][0-9][a-zA-Z][0-9][a-zA-Z][0-9]", postalCode);
        if (!validPostalCode)
        {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "invalidPostalCode", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
    
    /**
     * General form validation method to ensure that a field is not left empty or blank (not just whitespace)
     * @author Giancarlo Biasiucci
     * @param context
     * @param component
     * @param value 
     */
    public void validateNotNull(FacesContext context, UIComponent component, Object value) {
        String input = (String)value;
        if (input.isBlank() || input.isEmpty() || input == null)
        {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "valueNotNull", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
