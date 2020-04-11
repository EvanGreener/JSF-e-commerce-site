/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.entities.RankedBook;
import com.gb1w20.book_store_project.jpa_controllers.BookJpaController;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author cawri
 */
@Named("reports")
@ViewScoped
public class ReportsBean implements Serializable {
    
    private final static Logger LOG = LoggerFactory.getLogger(SearchBean.class);
    
    @Inject
    private BookJpaController bookCtrlr;
    
    private List<RankedBook> topSellers;
    
    
    @PostConstruct
    public void init() {
        updateReportsBean();
    }
    private void updateReportsBean()
    {
        topSellers = bookCtrlr.getTopSellingBooks();
    }
    public List<RankedBook> getTopBooks()
    {
        return topSellers;
    }
    
}
