package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.jpa_controllers.BookJpaController;
import com.gb1w20.book_store_project.util.MessageLoader;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Bean for managing book sales
 * @author Giancarlo Biasiucci
 * @version April 10, 2020
 */
@Named("salesBean")
@SessionScoped
public class SaleManagementBean implements Serializable {
    @Inject
    private BookJpaController bookControl;
    
    private List<Book> booksDisplayed;
    private BigDecimal newSalePrice;
    private Book currentBook;
    
    @PostConstruct
    public void init()
    {
        booksDisplayed = bookControl.findBookEntities();
    }
    public Book getCurrentBook()
    {
        return currentBook;
    }
    
    public void setCurrentBook(Book newBook)
    {
        currentBook = newBook;
    }
    
    public List<Book> getBooksDisplayed()
    {
        return booksDisplayed;
    }
    
    /**
     * As the list changes, the page is refreshed to reflect any changes that may have been made
     * @param newList - new list of books
     * @return
     * @throws Exception 
     * By: Giancarlo Biasiucci
     */
    public String setBooksDisplayed(List<Book> newList) throws Exception
    {
        booksDisplayed = newList;
        FacesContext.getCurrentInstance().getExternalContext().redirect("managerSales.xhtml");
        return null;
    }
    
    public BigDecimal getNewSalePrice()
    {
        return newSalePrice;
    }
    
    public void setNewSalePrice(BigDecimal newPrice)
    {
        newSalePrice = newPrice;
    }
    
    /**
     * Changes the current book whose sale price is to be edited as it is selected
     * @param isbn - isbn of newly current book
     * By: Giancarlo Biasiucci
     */
    public void onEdit(String isbn)
    {
        currentBook = bookControl.findAnySingleBook(isbn);
        newSalePrice = currentBook.getSalePrice();
    }
    
    /**
     * Edits the sale price of the current book with what has been entered
     * @return
     * @throws Exception 
     * By: Giancarlo Biasiucci
     */
    public String onSubmitEdit() throws Exception
    {
        currentBook.setSalePrice(newSalePrice);
        currentBook.setLastModified(new Date());
        bookControl.edit(currentBook);
        FacesContext.getCurrentInstance().getExternalContext().redirect("managerSales.xhtml");
        return "managerSales.xhtml";
    }
    
    /**
     * Validation method ensuring that the entered price is a valid double (so that it may be
     * converted to a BigDecimal at creation time)
     * @param context
     * @param component
     * @param value 
     * By: Giancarlo Biasiucci
     */
    public void validatePrice(FacesContext context, UIComponent component, Object value)
    {
        String input = value + "";
        if (input.isBlank() || input.isEmpty() || input == null)
        {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "valueNotNull", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        try
        {
            Double.parseDouble(input);
        }
        catch(NumberFormatException nfe)
        {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "badPrice", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
    
    /**
     * Returns a String indicating whether or not the book is on sale
     * @param book - The book whose sale status is to be determined
     * @return - the String indicating the sale status
     * By: Giancarlo Biasiucci
     */
    public String determineOnSale(Book book)
    {
        return book.getSalePrice().doubleValue() < book.getListPrice().doubleValue() ? MessageLoader.getString("com.gb1w20.bundles.messages", "onSale", null) : MessageLoader.getString("com.gb1w20.bundles.messages", "noSale", null);
    }
}
