/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.entities.OrderItem;
import com.gb1w20.book_store_project.jpa_controllers.BookJpaController;
import com.gb1w20.book_store_project.jpa_controllers.OrderItemJpaController;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author 06spa
 */
@Named("bb")
@SessionScoped
public class BookBean implements Serializable {

    @Inject
    private BookJpaController bookCtrlr;
    private final static Logger LOG = LoggerFactory.getLogger(BookBean.class);
    private List<Book> bestSeller;
    private List<Object> popularGenres;
     private List<Book> recentlyAdded;
     private Book book;

    @PostConstruct
    public void init() {
        LOG.debug("Init called!");

    }

    public List<Book> getBestSeller() {
        LOG.debug("getBestSeller");
         bestSeller=bookCtrlr.getBestSeller();
        return bestSeller;
    }
    public List<Object> getPopularGenres(){
             LOG.debug("getPopularGenres");
                 popularGenres=bookCtrlr.getPopularGenres();
        return popularGenres;
    }

    public List<Book> getRecentlyAdded(){
         LOG.debug("getRecentlyAdded");
                 recentlyAdded=bookCtrlr.getRecentlyAdded();
        return recentlyAdded;
    }
    
    public String viewBook(Book value) {
this.book = value;
        return "book";
 
}
    public Book getBook(){
        return this.book;
    }
}
