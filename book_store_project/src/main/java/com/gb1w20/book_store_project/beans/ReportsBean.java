/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.entities.OrderItemTotal;
import com.gb1w20.book_store_project.entities.RankedBook;
import com.gb1w20.book_store_project.jpa_controllers.BookJpaController;
import com.gb1w20.book_store_project.jpa_controllers.OrderItemJpaController;
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
 * @author Cedric Richards
 */
@Named("reports")
@ViewScoped
public class ReportsBean implements Serializable {
    
    private final static Logger LOG = LoggerFactory.getLogger(SearchBean.class);
    
    @Inject
    private BookJpaController bookCtrlr;
    
    @Inject
    private OrderItemJpaController orderItemCtrlr;
    
    private List<RankedBook> topSellers;
    
    private List<Book> zeroSellers;
    
    private List<Book> stockReport;
    
    private List<OrderItemTotal> totalSales;
    
    
    @PostConstruct
    public void init() {
        updateReportsBean();
    }
    private void updateReportsBean()
    {
        topSellers = bookCtrlr.getTopSellingBooks();
        zeroSellers = bookCtrlr.getZeroSellingBooks();
        stockReport = bookCtrlr.findBookEntities();
        totalSales = orderItemCtrlr.getTotalSales();
    }
    public List<RankedBook> getTopBooks()
    {
        return topSellers;
    }
    public List<Book> getZeroSellingBooks()
    {
        return zeroSellers;
    }
    public List<Book> getStockReport()
    {
        return stockReport;
    }
    public List<OrderItemTotal> getTotalSales()
    {
        return totalSales;
    }
}
