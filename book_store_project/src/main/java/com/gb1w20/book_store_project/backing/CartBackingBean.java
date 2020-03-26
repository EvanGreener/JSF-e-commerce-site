/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.jpa_controllers.BookJpaController;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
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

    @Inject
    private BookJpaController bookCtrlr;

    public List<Book> getCartItems() {
        return this.CartItems;
    }

    public void setCartItems(List<Book> CartItems) {
        this.CartItems = CartItems;
    }

    public Boolean isCartEmpty(){
        List<Book> cartList = this.getCartItems();
        return cartList.size() < 1;
    }
    
    public double getCartTotal(){
        List<Book> cartList = this.getCartItems();
        double cartTotal=0.00;
        for(Book cartBook : cartList){
                        LOG.info("cart has " + cartBook.getListPrice());

           cartTotal += cartBook.getListPrice().doubleValue();
        }
        return cartTotal;
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

    public void removeBookFromCart(Book removingBook) {
        List<Book> cartList = this.getCartItems();
        if (cartList.contains(removingBook)) {
            cartList.remove(removingBook);
            LOG.info("cart has " + cartList.size());
            this.setCartItems(cartList);
        }
    }

    public String redirectToFinalizePage(Boolean isSignedIn){
        LOG.info("user is " +isSignedIn);
        return isSignedIn ? "index.xhtml" : "signIn.xhtml";
    }
}
