/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.Authors;
import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.entities.Publisher;
import com.gb1w20.book_store_project.jpa_controllers.BookJpaController;
import com.gb1w20.book_store_project.jpa_controllers.PublisherJpaController;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
 * @author giancarlo
 */

@Named("editBook")
@SessionScoped
public class EditBookBean implements Serializable {
    
    @Inject
    private BookJpaController bookControl;
    
    @Inject
    private PublisherJpaController pubControl;
    
    private final static Logger LOG = LoggerFactory.getLogger(EditAdBean.class);
    private Book currentBook;
    private String newTitle;
    private Authors newAuthor;
    private String newDescription;
    private Publisher newPublisher;
    private String newGenre;
    private int newPages;
    private BigDecimal newListPrice;
    private BigDecimal newSalePrice;
    private BigDecimal newWholesalePrice;
    
    @PostConstruct
    public void init()
    {
        LOG.debug("init called");
    }
    
    public Book getCurrentBook()
    {
        return currentBook;
    }
    
    public String getNewTitle()
    {
        return newTitle;
    }
    
    public void setNewTitle(String newValue)
    {
        newTitle = newValue;
    }
    
    public String getNewDescription()
    {
        return newDescription;
    }
    
    public void setNewDescription(String newValue)
    {
        newDescription = newValue;
    }
    
    public Authors getNewAuthor()
    {
        return newAuthor;
    }
    
    public void setNewAuthor(Authors newValue)
    {
        newAuthor = newValue;
    }
    
    public Publisher getNewPublisher()
    {
        return newPublisher;
    }
    
    public void setNewPublisher(Publisher newValue)
    {
        newPublisher = newValue;
    }
    
    public String getNewGenre()
    {
        return newGenre;
    }
    
    public void setNewGenre(String newValue)
    {
        newGenre = newValue;
    }
    
    public int getNewPages()
    {
        return newPages;
    }
    
    public void setNewPages(int newValue)
    {
        newPages = newValue;
    }
    
    public BigDecimal getNewListPrice()
    {
        return newListPrice;
    }
    
    public void setNewListPrice(BigDecimal newValue)
    {
        newListPrice = newValue;
    }
    
    public BigDecimal getNewSalePrice()
    {
        return newSalePrice;
    }
    
    public void setNewSalePrice(BigDecimal newValue)
    {
        newSalePrice = newValue;
    }
    
    public BigDecimal getNewWholesalePrice()
    {
        return newWholesalePrice;
    }
    
    public void setNewWholesalePrice(BigDecimal newValue)
    {
        newWholesalePrice = newValue;
    }
    
    public void onEdit(String isbn)
    {
        LOG.debug("onEdit called");
        LOG.debug("ISBN we are looking for: " + isbn);
        currentBook = bookControl.findAnySingleBook(isbn);
        newTitle = currentBook.getTitle();
        newDescription = currentBook.getDescription();
        newAuthor = currentBook.getAuthorsCollection().get(0);
        newPublisher = pubControl.findPublisher(currentBook.getPublisherID());
        newGenre = currentBook.getGenre();
        newPages = currentBook.getNumOfPages();
        newListPrice = currentBook.getListPrice();
        newSalePrice = currentBook.getSalePrice();
        newWholesalePrice = currentBook.getWholesalePrice();
        LOG.debug("Current ISBN: " + currentBook.getIsbn());
    }
    
    public String onSubmitEdit() throws Exception
    {
        LOG.debug("onSubmitEdit called");
        List<Authors> authors = new ArrayList<>();
        authors.add(newAuthor);
        currentBook.setListPrice(newListPrice);
        currentBook.setSalePrice(newSalePrice);
        currentBook.setDescription(newDescription);
        currentBook.setWholesalePrice(newWholesalePrice);
        currentBook.setNumOfPages(newPages);
        currentBook.setPublisherID(newPublisher.getPublisherID());
        currentBook.setLastModified(new Date());
        currentBook.setIsRemoved(false);
        currentBook.setAuthorsCollection(authors);
        bookControl.edit(currentBook);
        FacesContext.getCurrentInstance().getExternalContext().redirect("managerInventory.xhtml");
        return null;
    } 
}