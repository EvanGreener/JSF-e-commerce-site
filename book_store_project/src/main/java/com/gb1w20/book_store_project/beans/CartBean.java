/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.jpa_controllers.BookJpaController;
import java.io.Serializable;
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
@Named("CartBean")
@SessionScoped
public class CartBean implements Serializable {

     private final static Logger LOG = LoggerFactory.getLogger(CartBean.class);
    
    @Inject
    private BookJpaController bookCtrlr;
    
    private List<Book> CartItems; 
    
    public List<Book> getCartItems(){
        return null;
    }
}
