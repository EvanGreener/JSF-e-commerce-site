package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.entities.Authors;
import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.entities.BookAuthors;
import com.gb1w20.book_store_project.jpa_controllers.AuthorsJpaController;
import com.gb1w20.book_store_project.jpa_controllers.BookAuthorsJpaController;
import com.gb1w20.book_store_project.jpa_controllers.BookJpaController;
import com.gb1w20.book_store_project.jpa_controllers.PublisherJpaController;
import com.gb1w20.book_store_project.util.MessageLoader;
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
 *
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

    @Inject
    private BookAuthorsJpaController bookauthorsJpaController;

    private String selectedPub;
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
     * The book managed by the bean is created if null to avoid a
     * NullPointerException.
     *
     * @return
     */
    public Book getBook() {
        if (book == null) {
            book = new Book();
        }
        return book;
    }
    
    /**
     * By: Giancarlo Biasiucci
     * Returns the names of all publishers every time one is to be selected
     * @return List of publishers
     */

    public List<String> getPubNames() {
        if (pubNames == null) {
            pubNames = pubJpaController.getPublisherNames();
        }
        return pubNames;
    }

    /**
     * By: Giancarlo Biasiucci
     * Returns a list of all authors every time one is to be selected
     * @return List of authors
     */
    public List<String> getAuthorNames() {
        if (authorNames == null) {
            authorNames = authorsJpaController.getAuthorNames();
        }
        return authorNames;
    }

    /**
     * Genres are added manually since referencing the controller at this point 
     * would generate a NullPointerException
     * By: Giancarlo Biasiucci
     * @return List of genres
     */
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

    public String getPageNum() {
        return pageNum;
    }

    public Book getCurrentBook() {
        return currentBook;
    }

    public void setCurrentBook(Book newBook) {
        currentBook = newBook;
    }

    public void setPageNum(String newValue) {
        pageNum = newValue;
    }

    public String getSelectedGenre() {
        LOG.debug("getSelectedGenre: " + selectedGenre);
        return selectedGenre;
    }

    public void setSelectedGenre(String newGenre) {
        LOG.debug("setSelectedGenre: " + newGenre);
        selectedGenre = newGenre;
    }

    public String getLPriceStr() {
        return lPriceStr;
    }

    public void setLPriceStr(String newValue) {
        lPriceStr = newValue;
    }

    public String getSPriceStr() {
        return sPriceStr;
    }

    public void setSPriceStr(String newValue) {
        sPriceStr = newValue;
    }

    public String getWSPriceStr() {
        return wsPriceStr;
    }

    public void setWSPriceStr(String newValue) {
        wsPriceStr = newValue;
    }

    public String getSelectedPub() {
        LOG.debug("getSelectedPub" + selectedPub);
        return selectedPub;
    }

    public void setSelectedPub(String newPub) {
        LOG.debug("setSelectedPub" + newPub);
        selectedPub = newPub;
    }

    public Authors getSelectedAuthor() {
        return selectedAuthor;
    }

    public void setSelectedAuthor(Authors newAuthors) {
        selectedAuthor = newAuthors;
    }

    /**
     * Creates the book and saves it to the database. Data is retrieved from
     * corresponding modal.
     *
     * @author Shruti Pareek, Giancarlo
     * @return
     * @throws Exception
     */
    public String createBook() throws Exception {
        List<Authors> authors = new ArrayList<>();
        authors.add(selectedAuthor);
        book.setGenre(selectedGenre);
        book.setListPrice(BigDecimal.valueOf(Double.parseDouble(lPriceStr)));
        book.setSalePrice(BigDecimal.valueOf(Double.parseDouble(sPriceStr)));
        book.setWholesalePrice(BigDecimal.valueOf(Double.parseDouble(wsPriceStr)));
        book.setNumOfPages(Integer.valueOf(pageNum));
        book.setPublisherID(pubJpaController.getPublisherByName(selectedPub).getPublisherID());
        book.setDateOfPublication(new Date());
        book.setDateEntered(new Date());
        book.setLastModified(new Date());
        book.setIsRemoved(false);
        book.setAuthorsCollection(authors);
        selectedAuthor = authorsJpaController.getAuthorByName(selectedAuthor.getName());
        BookAuthors ba = new BookAuthors();
        ba.setIsbn(book.getIsbn());
        ba.setAuthorID(selectedAuthor.getAuthorID());
        this.bookauthorsJpaController.create(ba);
        bookJpaController.create(book);
        FacesContext.getCurrentInstance().getExternalContext().redirect("managerInventory.xhtml");
        return "managerInventory.xhtml";
    }

    public void onCreate() {
        LOG.debug("onCreate called!");
    }

    /**
     * Marks a book as removed (changes removal status to true)
     * By: Giancarlo Biasiucci
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
     * By: Giancarlo Biasiucci
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
     * Determines whether a book should be added or removed based on its current
     * removal status whenever the corresponding link in the managerial ad page
     * is clicked (changed to other state, if true than changed to false and
     * vice versa)
     * By: Giancarlo Biasiucci
     * @param book
     * @return
     * @throws Exception
     */
    public String addOrRemoveBook(Book book) throws Exception {
        if (book.getIsRemoved()) {
            addBook(book);
        } else {
            removeBook(book);
        }
        FacesContext.getCurrentInstance().getExternalContext().redirect("managerInventory.xhtml");
        return null;
    }

    /**
     * Returns a String indicating what will occur when the corresponding link
     * in the managerial book page is clicked
     * By: Giancarlo Biasiucci
     * @param isRemoved
     * @return String indicating removal status
     * @throws Exception
     */
    public String getRemovalStatus(boolean isRemoved) throws Exception {
        if (isRemoved)
        {
            return MessageLoader.getString("com.gb1w20.bundles.messages", "displayBook", null);
        }
        else
        {
            return MessageLoader.getString("com.gb1w20.bundles.messages", "removeBook", null);
        }
    }

    /**
     * Validation method ensuring that a field in the "Add Book" modal is not
     * left null
     * By: Giancarlo Biasiucci
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

    /**
     * Validation method ensuring that an entered ISBN is entirely numerical, unique, and
     * of a valid length
     * By: Giancarlo Biasiucci
     * @param context
     * @param component
     * @param value
     */
    public void validateISBN(FacesContext context, UIComponent component, Object value)
    {
        String input = (String)value;
        if (input.isBlank() || input.isEmpty() || input == null)
        {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "valueNotNull", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        if (input.length() > 13)
        {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "isbnDigits", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        if (bookJpaController.getAllISBN().contains(input))
        {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "isbnExists", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        try {
            for (char c : input.toCharArray()) {
                Integer.parseInt(Character.toString(c));
            }
        }
        catch(NumberFormatException nfe)
        {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "badIsbn", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }

    /**
     * By: Giancarlo Biasiucci
     * Sets the genre for the new book every time one is selected
     * @param newGenre 
     */
    public void genreChangeMethod(String newGenre) {
        LOG.debug("new genre: " + newGenre);
        selectedGenre = newGenre;
    }

    /**
     * By: Giancarlo Biasiucci
     * Sets the author for the new book every time one is selected
     * @param newAuthName 
     */
    public void authChangeMethod(String newAuthName) {
        LOG.debug("new auth: " + newAuthName);
        selectedAuthor = authorsJpaController.getAuthorByName(newAuthName);
        LOG.debug("new auth: " + selectedAuthor.getAuthorID());
    }

    /**
     * By: Giancarlo Biasiucci
     * Sets the publisher for the new book every time one is selected
     * @param newPubName 
     */
    public void pubChangeMethod(String newPubName) {
        LOG.debug("new pub: " + newPubName);
        selectedPub = newPubName;
    }

    /**
     * Validation method ensuring that the number of pages is entirely numerical
     * By: Giancarlo Biasiucci
     * @param context
     * @param component
     * @param value
     */
    public void validatePages(FacesContext context, UIComponent component, Object value) {
        String input = value.toString() + "";
        if (input.isBlank() || input.isEmpty() || input == null)
        {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "valueNotNull", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        try {
            Integer.parseInt(input);
        }
        catch(NumberFormatException nfe)
        {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "badPages", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }

    /**
     * Validation method ensuring that the entered price is a valid double (so
     * that it may be converted to a BigDecimal at creation time)
     * By: Giancarlo Biasiucci
     * @param context
     * @param component
     * @param value
     */
    public void validatePrice(FacesContext context, UIComponent component, Object value) {
        String input = value + "";
        if (input.isBlank() || input.isEmpty() || input == null)
        {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "valueNotNull", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        try {
            Double.parseDouble(input);
        }
        catch(NumberFormatException nfe)
        {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "badPrice", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
    
}
