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
    
    private String selectedPub;
    private List<String> pubNames;
    private List<String> authorNames;
    private String selectedAuthor;
    private String pageNum;
    private String lPriceStr;
    private String sPriceStr;
    private String wsPriceStr;
    private Book currentBook;
    
    private List<String> genres;

    private Book book;

    /**
     * Books created if it does not exist.
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
    
    public List<String> getGenres() {
        if (genres == null) {
            genres = new ArrayList<String>();
            genres.add("Sci-Fi");
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
    
    public String getSelectedPub()
    {
        return selectedPub;
    }
    
    public void setSelectedPub(String newPub)
    {
        selectedPub = newPub;
    }
    
    public String getSelectedAuthor()
    {
        return selectedAuthor;
    }
    
    public void setSelectedAuthor(String newAuthors)
    {
        selectedAuthor = newAuthors;
    }

    /**
     * Save the current book to the db
     *
     * @return
     * @throws Exception
     */
    public String createBook() throws Exception {
        List<Authors> authors = new ArrayList<Authors>();
        authors.add(authorsJpaController.getAuthorByName(selectedAuthor));
        book.setListPrice(BigDecimal.valueOf(Double.parseDouble(lPriceStr)));
        book.setSalePrice(BigDecimal.valueOf(Double.parseDouble(sPriceStr)));
        book.setWholesalePrice(BigDecimal.valueOf(Double.parseDouble(wsPriceStr)));
        book.setNumOfPages(Integer.valueOf(pageNum));
        book.setPublisherID(pubJpaController.getPublisherIDByName(selectedPub));
        book.setDateOfPublication(new Date());
        book.setDateEntered(new Date());
        book.setLastModified(new Date());
        book.setIsRemoved(false);
        //book.setAuthorsCollection(authors);
        bookJpaController.create(book);
        FacesContext.getCurrentInstance().getExternalContext().redirect("managerInventory.xhtml");
        return "managerInventory.xhtml";
    }
    
    public void onCreate(){
        LOG.debug("onCreate called!");
    }
    
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
    
    public void validateNotNull(FacesContext context, UIComponent component, Object value) {
        String input = (String)value;
        if (input.isBlank() || input.isEmpty() || input == null)
        {
            String message = context.getApplication().evaluateExpressionGet(context, "Value must not be left blank", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
    }
    
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
