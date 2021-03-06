package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.Authors;
import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.entities.BookAuthors;
import com.gb1w20.book_store_project.entities.Publisher;
import com.gb1w20.book_store_project.jpa_controllers.AuthorsJpaController;
import com.gb1w20.book_store_project.jpa_controllers.BookAuthorsJpaController;
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
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bean for editing an existing book's information
 *
 * @author Giancarlo Biasiucci
 * @version April 4, 2020
 */
@Named("editBook")
@SessionScoped
public class EditBookBean implements Serializable {

    @Inject
    private AuthorsJpaController authControl;

    @Inject
    private BookJpaController bookControl;

    @Inject
    private PublisherJpaController pubControl;

    @Inject
    private BookAuthorsJpaController bookauthorsJpaController;

    private final static Logger LOG = LoggerFactory.getLogger(EditBookBean.class);
    private Book currentBook;
    private String newTitle;
    private Authors newAuthor = new Authors();
    private String newDescription;
    private Publisher newPublisher = new Publisher();
    private String newGenre;
    private int newPages;
    private BigDecimal newListPrice;
    private BigDecimal newSalePrice;
    private BigDecimal newWholesalePrice;

    @PostConstruct
    public void init() {
        LOG.debug("init called");
    }

    public Book getCurrentBook() {
        return currentBook;
    }

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newValue) {
        newTitle = newValue;
    }

    public String getNewDescription() {
        return newDescription;
    }

    public void setNewDescription(String newValue) {
        newDescription = newValue;
    }

    public Authors getNewAuthor() {
        return newAuthor;
    }

    public void setNewAuthor(Authors newValue) {
        newAuthor = newValue;
    }

    public Publisher getNewPublisher() {
        return newPublisher;
    }

    public void setNewPublisher(Publisher newValue) {
        newPublisher = newValue;
    }

    public String getNewGenre() {
        return newGenre;
    }

    public void setNewGenre(String newValue) {
        newGenre = newValue;
    }

    public int getNewPages() {
        return newPages;
    }

    public void setNewPages(int newValue) {
        newPages = newValue;
    }

    public BigDecimal getNewListPrice() {
        return newListPrice;
    }

    public void setNewListPrice(BigDecimal newValue) {
        newListPrice = newValue;
    }

    public BigDecimal getNewSalePrice() {
        return newSalePrice;
    }

    public void setNewSalePrice(BigDecimal newValue) {
        newSalePrice = newValue;
    }

    public BigDecimal getNewWholesalePrice() {
        return newWholesalePrice;
    }

    public void setNewWholesalePrice(BigDecimal newValue) {
        newWholesalePrice = newValue;
    }

    /**
     * Saves the current book information to be displayed in the "Edit Book" modal
     * when the corresponding button is clicked
     * @param isbn 
     * By: Giancarlo Biasiucci
     */
    public void onEdit(String isbn, Authors author) {
        LOG.debug("onEdit called");
        LOG.debug("ISBN we are looking for: " + isbn);
        currentBook = bookControl.findAnySingleBook(isbn);
        newTitle = currentBook.getTitle();
        newDescription = currentBook.getDescription();
        newAuthor = author;
        newPublisher = pubControl.findPublisher(currentBook.getPublisherID());
        newGenre = currentBook.getGenre();
        newPages = currentBook.getNumOfPages();
        newListPrice = currentBook.getListPrice();
        newSalePrice = currentBook.getSalePrice();
        newWholesalePrice = currentBook.getWholesalePrice();
        LOG.debug("Current ISBN: " + currentBook.getIsbn());
    }
    
    /**
     * Changes the new genre whenever one is selected
     * @param newGenre - The new genre
     * By: Giancarlo Biasiucci
     */
    public void genreChangeMethod(String newGenre){
        LOG.debug("new genre: " + newGenre);
        this.newGenre = newGenre;
    }
    
    /**
     * Changes the new author whenever one is selected
     * @param newAuthName - New author name
     * By: Giancarlo Biasiucci
     */
    public void authChangeMethod(String newAuthName){
        LOG.debug("new auth: " + newAuthName);
        newAuthor = authControl.getAuthorByName(newAuthName);
    }
    
    /**
     * Changes the new publisher whenever one is selected
     * @param newPubName - New publisher name
     * By: Giancarlo Biasiucci
     */
    public void pubChangeMethod(String newPubName){
        LOG.debug("new pub: " + newPubName);
        newPublisher = pubControl.getPublisherByName(newPubName);
    }

    /**
     * Edits the existing book information with what is present in the fields in
     * the "Edit Book" modal and updates the entry in the database
     *
     * @return
     * @throws Exception 
     * By: Giancarlo Biasiucci
     */
    public String onSubmitEdit() throws Exception {
        LOG.debug("onSubmitEdit called");
        List<Authors> authors = new ArrayList<>();
        authors.add(newAuthor);
        currentBook.setTitle(newTitle);
        currentBook.setListPrice(newListPrice);
        currentBook.setSalePrice(newSalePrice);
        currentBook.setGenre(newGenre);
        currentBook.setDescription(newDescription);
        currentBook.setWholesalePrice(newWholesalePrice);
        currentBook.setNumOfPages(newPages);
        currentBook.setPublisherID(newPublisher.getPublisherID());
        currentBook.setLastModified(new Date());
        currentBook.setIsRemoved(false);
        //currentBook.setAuthorsCollection(authors);
        bookControl.edit(currentBook);

        BookAuthors ba = this.bookauthorsJpaController.findBookAuthorsByIsbn(currentBook.getIsbn()).get(0);
        LOG.debug("authorId" + newAuthor.getAuthorID());
        LOG.debug("bookauthorId" + ba.getBookAuthorID());
        this.bookauthorsJpaController.destroy(ba.getBookAuthorID());
        ba.setAuthorID(newAuthor.getAuthorID());
        ba.setBookAuthorID(ba.getBookAuthorID() + 1);
        this.bookauthorsJpaController.create(ba);

        FacesContext.getCurrentInstance().getExternalContext().redirect("managerInventory.xhtml");
        return null;
    }
}
