package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.entities.Authors;
import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.entities.Publisher;
import com.gb1w20.book_store_project.jpa_controllers.AuthorsJpaController;
import com.gb1w20.book_store_project.jpa_controllers.BookJpaController;
import com.gb1w20.book_store_project.jpa_controllers.PublisherJpaController;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Backing bean for the book entity
 * @author Giancarlo Biasiucci
 * @version April 4, 2020
 */
@Named("bookBacking")
@RequestScoped
public class BookBackingBean implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(BookBackingBean.class);

    @Inject
    private BookJpaController bookJpaController;
    
    @Inject
    private PublisherJpaController pubJpaController;
    
    @Inject
    private AuthorsJpaController authorsJpaController;
    
    private Publisher selectedPub = new Publisher();
    private List<String> pubNames;
    private List<String> authorNames;
    private Authors selectedAuthor = new Authors();
    private String selectedGenre;
    private String pageNum;
    private String lPriceStr;
    private String sPriceStr;
    private String wsPriceStr;
    private Book currentBook;
    
    private List<String> genres;

    private Book book;

    /**
     * The book managed by the bean is created if null to avoid a NullPointerException.
     *
     * @return
     */
    public Book getBook() {
        if (book == null) {
            book = new Book();
        }
        return book;
    }
    
    public List<String> getPubNames() {
        if (pubNames == null) {
            pubNames = pubJpaController.getPublisherNames();
        }
        return pubNames;
    }
    
    public List<String> getAuthorNames() {
        if (authorNames == null) {
            authorNames = authorsJpaController.getAuthorNames();
        }
        return authorNames;
    }
    
    //Genres are added manually since referencing the controller at this point would generate a NullPointerException
    public List<String> getGenres() {
        if (genres == null) {
            genres = new ArrayList<String>();
            genres.add("Science Fiction");
            genres.add("Mystery");
            genres.add("Fantasy");
            genres.add("Horror");
            genres.add("Fiction");
        }
        return genres;
    }
    
    public String getPageNum()
    {
        return pageNum;
    }
    
    public Book getCurrentBook()
    {
        return currentBook;
    }
    
    public void setCurrentBook(Book newBook)
    {
        currentBook = newBook;
    }
    
    public void setPageNum(String newValue)
    {
        pageNum = newValue;
    }
    
    public String getSelectedGenre()
    {
        return selectedGenre;
    }
    
    public void setSelectedGenre(String newGenre)
    {
        selectedGenre = newGenre;
    }
    
    public String getLPriceStr()
    {
        return lPriceStr;
    }
    
    public void setLPriceStr(String newValue)
    {
        lPriceStr = newValue;
    }
    
    public String getSPriceStr()
    {
        return sPriceStr;
    }
    
    public void setSPriceStr(String newValue)
    {
        sPriceStr = newValue;
    }
    
    public String getWSPriceStr()
    {
        return wsPriceStr;
    }
    
    public void setWSPriceStr(String newValue)
    {
        wsPriceStr = newValue;
    }
    
    public Publisher getSelectedPub()
    {
        return selectedPub;
    }
    
    public void setSelectedPub(Publisher newPub)
    {
        selectedPub = newPub;
    }
    
    public Authors getSelectedAuthor()
    {
        return selectedAuthor;
    }
    
    public void setSelectedAuthor(Authors newAuthors)
    {
        selectedAuthor = newAuthors;
    }

    /**
     * Creates the book and saves it to the database. Data is retrieved from corresponding modal.
     * @return
     * @throws Exception
     */
    public String createBook() throws Exception {
        List<Authors> authors = new ArrayList<Authors>();
        authors.add(selectedAuthor);
        book.setGenre(selectedGenre);
        book.setListPrice(BigDecimal.valueOf(Double.parseDouble(lPriceStr)));
        book.setSalePrice(BigDecimal.valueOf(Double.parseDouble(sPriceStr)));
        book.setWholesalePrice(BigDecimal.valueOf(Double.parseDouble(wsPriceStr)));
        book.setNumOfPages(Integer.valueOf(pageNum));
        book.setPublisherID(selectedPub.getPublisherID());
        book.setDateOfPublication(new Date());
        book.setDateEntered(new Date());
        book.setLastModified(new Date());
        book.setIsRemoved(false);
        book.setAuthorsCollection(authors);
        bookJpaController.create(book);
        FacesContext.getCurrentInstance().getExternalContext().redirect("managerInventory.xhtml");
        return "managerInventory.xhtml";
    }
    
    public void onCreate(){
        LOG.debug("onCreate called!");
    }
    
    /**
     * Marks a book as removed (changes removal status to true)
     * @param book
     * @return
     * @throws Exception 
     */
    public String removeBook(Book book) throws Exception {
        LOG.debug("Reached the remove method");
        book.setIsRemoved(true);
        LOG.debug("Reached the setRemoved method");
        book.setLastModified(new Date());
        LOG.debug("Reached the setModified method");
        bookJpaController.edit(book);
        LOG.debug("Reached the edit method");
        return null;
    }
    
    /**
     * Marks a book as not removed (changes removal status to false)
     * @param book
     * @return
     * @throws Exception 
     */
    public String addBook(Book book) throws Exception {
        LOG.debug("Reached the add method");
        book.setIsRemoved(false);
        LOG.debug("Reached the setRemoved method");
        book.setLastModified(new Date());
        LOG.debug("Reached the lastModified method");
        bookJpaController.edit(book);
        LOG.debug("Reached the edit method");
        return null;
    }
    
    /**
     * Determines whether a book should be added or removed based on its current removal status
     * whenever the corresponding link in the managerial ad page is clicked
     * (changed to other state, if true than changed to false and vice versa)
     * @param book
     * @return
     * @throws Exception 
     */
    public String addOrRemoveBook(Book book) throws Exception
    {
        if (book.getIsRemoved())
        {
            addBook(book);
        }
        else
        {
            removeBook(book);
        }
        FacesContext.getCurrentInstance().getExternalContext().redirect("managerInventory.xhtml");
        return null;
    }
    
    /**
     * Returns a String indicating what will occur when the corresponding link in the managerial
     * book page is clicked
     * @param isRemoved
     * @return
     * @throws Exception 
     */
    public String getRemovalStatus(boolean isRemoved) throws Exception {
        if (isRemoved)
        {
            return "Display Book";
        }
        else
        {
            return "Remove Book";
        }
    }
    
    /**
     * Validation method ensuring that a field in the "Add Book" modal is not left null
     * @param context
     * @param component
     * @param value 
     */
    public void validateNotNull(FacesContext context, UIComponent component, Object value) {
        String input = (String)value;
        if (input.isBlank() || input.isEmpty() || input == null)
        {
            String message = context.getApplication().evaluateExpressionGet(context, "Value must not be left blank", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
    }
    
    /**
     * Validation method ensuring that an entered ISBN is entirely numerical and of a valid length
     * @param context
     * @param component
     * @param value 
     */
    public void validateISBN(FacesContext context, UIComponent component, Object value)
    {
        String input = (String)value;
        if (input.isBlank() || input.isEmpty() || input == null)
        {
            String message = context.getApplication().evaluateExpressionGet(context, "Value must not be left blank", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
        if (input.length() > 13)
        {
            String message = context.getApplication().evaluateExpressionGet(context, "ISBN must not be more than 13 digits", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
        if (bookJpaController.getAllISBN().contains(input))
        {
            String message = context.getApplication().evaluateExpressionGet(context, "ISBN already exists", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
        try
        {
            for (char c: input.toCharArray())
            {
                Integer.parseInt(Character.toString(c));
            }
        }
        catch(NumberFormatException nfe)
        {
            String message = context.getApplication().evaluateExpressionGet(context, "Invalid ISBN: contains non-numeric characters", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
    }
    
    public void genreChangeMethod(String newGenre){
        LOG.debug("new genre: " + newGenre);
        selectedGenre = newGenre;
    }
    
    public void authChangeMethod(String newAuthName){
        LOG.debug("new auth: " + newAuthName);
        selectedAuthor = authorsJpaController.getAuthorByName(newAuthName);
    }
    
    public void pubChangeMethod(String newPubName){
        LOG.debug("new pub: " + newPubName);
        selectedPub = pubJpaController.getPublisherByName(newPubName);
    }
    
    /**
     * Validation method ensuring that the number of pages is entirely numerical
     * @param context
     * @param component
     * @param value 
     */
    public void validatePages(FacesContext context, UIComponent component, Object value)
    {
        String input = value.toString() + "";
        if (input.isBlank() || input.isEmpty() || input == null)
        {
            String message = context.getApplication().evaluateExpressionGet(context, "Value must not be left blank", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
        try
        {
            Integer.parseInt(input);
        }
        catch(NumberFormatException nfe)
        {
            String message = context.getApplication().evaluateExpressionGet(context, "Invalid number of pages: contains non-numeric characters", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
    }
    
    /**
     * Validation method ensuring that the entered price is a valid double (so that it may be
     * converted to a BigDecimal at creation time)
     * @param context
     * @param component
     * @param value 
     */
    public void validatePrice(FacesContext context, UIComponent component, Object value)
    {
        String input = value + "";
        if (input.isBlank() || input.isEmpty() || input == null)
        {
            String message = context.getApplication().evaluateExpressionGet(context, "Value must not be left blank", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
        try
        {
            Double.parseDouble(input);
        }
        catch(NumberFormatException nfe)
        {
            String message = context.getApplication().evaluateExpressionGet(context, "Invalid price: contains non-numeric characters", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
    }

}
