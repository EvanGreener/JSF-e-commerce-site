/*
 * This package stores all beans used to access controller classses
 */
package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.Authors;
import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.entities.OrderItem;
import com.gb1w20.book_store_project.jpa_controllers.BookJpaController;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Gets information for books on client site
 *
 * @author Shruti Pareek
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
    private List<Book> similarGenreBooks;
    private List<Book> similarAuthorBooks;
    private List<Book> saleBooks;
    private String genre;
    private int bookSlideColor = 0;

    @PostConstruct
    /**
     * method for initializing when bean called
     *
     * @return void
     */
    public void init() {
        LOG.debug("Init called!");

    }

    /**
     * Responsible for changing background color of each slide in index page
     *
     * @author Shruti Pareek
     * @return int
     */
    public int getBookSlideColor() {
        LOG.debug("getBookSlideColor");
        if (bookSlideColor == 0) {
            bookSlideColor++;
        } else if (bookSlideColor == 1) {
            bookSlideColor++;
        } else if (bookSlideColor == 2) {
            bookSlideColor++;
        } else {
            bookSlideColor = 1;
        }
        return bookSlideColor;
    }

    /**
     * Gets best seller books based on the amount of purchases for the book
     *
     * @author Shruti Pareek
     * @return int
     */
    public List<Book> getBestSeller() {
        LOG.debug("getBestSeller");
        bestSeller = bookCtrlr.getBestSeller();
        return bestSeller;
    }

    /**
     * Gets the popular genres
     *
     * @author Shruti Pareek
     * @return List of object books
     */
    public List<Object> getPopularGenres() {
        LOG.debug("getPopularGenres");
        popularGenres = bookCtrlr.getPopularGenres();
        return popularGenres;
    }

    /**
     * Gets books that have been recently added to database based on date
     * entered
     *
     * @author Shruti Pareek
     * @return List of object books
     */
    public List<Book> getRecentlyAdded() {
        LOG.debug("getRecentlyAdded");
        recentlyAdded = bookCtrlr.getRecentlyAdded();
        return recentlyAdded;
    }

    /**
     * Get books with similar genre that user is currently viewing except for
     * current one that is being viewed and the ones written by same author as
     * the one being viewed
     *
     * @author Shruti Pareek
     * @param book
     * @param author
     * @return similarGenreBooks
     */
    public List<Book> getSimilarGenreBooks(Book book, List<Authors> author) {
        LOG.debug("getSimilarGenreBooks");
        similarGenreBooks = bookCtrlr.getSimilarGenres(book, author.get(0).getAuthorID());
        return similarGenreBooks;
    }

    /**
     * Get books with similar genre that user had previously viewed for
     * recommendations
     *
     * @author Shruti Pareek
     * @param book
     * @return similarGenreBooks
     */
    public List<Book> getSimilarGenreBooks(String genre) {
        LOG.debug("getSimilarGenreBooks");
        similarGenreBooks = bookCtrlr.getSimilarGenres(genre);
        Collections.shuffle(similarGenreBooks);

        return similarGenreBooks;
    }

    /**
     * Returns only a part of book description that will be visible on book page
     *
     * @author Shruti Pareek
     * @param description
     * @return description - 300 characters
     */
    public String getDisplayBookDescription(String description) {
        LOG.debug("getDisplayBookDescription");
        if (description.length() > (300 + 2)) {
            return description.substring(0, 300 - 1);
        }
        return description;
    }

    /**
     * Returns only a part of book description that is invisible from users
     *
     * @author Shruti Pareek
     * @param description
     * @return description - 300 characters
     */
    public String getHiddenBookDescription(String description) {
        LOG.debug("getHiddenBookDescription");

        return description.substring(300 - 1, description.length());
    }

    /**
     * Get books with similar author that user is currently viewing
     *
     * @author Shruti Pareek
     * @param author
     * @param isbn
     * @return getSimilarAuthorBooks
     */
    public List<Book> getSimilarAuthorBooks(List<Authors> author, String isbn) {
        LOG.debug("getSimilarAuthorBooks");
        similarAuthorBooks = bookCtrlr.getSimilarAuthors(author.get(0).getAuthorID(), isbn);
        return similarAuthorBooks;
    }

    /**
     * Set the genre of a book
     *
     * @author Shruti Pareek
     * @param genre
     */
    public void setGenre(String genre) {
        LOG.debug("setGenre");
        this.genre = genre;
    }

    /**
     * Set the genre of a book
     *
     * @author Shruti Pareek
     * @return
     */
    public String getGenre() {
        LOG.debug("getGenre");
        return this.genre;
    }

    public Book findOrderBook(OrderItem orderItem) {
        return bookCtrlr.findBook(orderItem.getIsbn());
    }

    /**
     * Get all books with sales
     *
     * @author Shruti Pareek
     * @return books
     */
    public List<Book> getSaleBooks() {
        LOG.debug("getSaleBooks");
        this.saleBooks = bookCtrlr.getSaleBooks();
        return this.saleBooks;
    }

    /**
     * Downloads an alice in wonderland pdf
     *
     * @author Shruti Pareek Sources used
     * https://stackoverflow.com/questions/9391838/how-to-provide-a-file-download-from-a-jsf-backing-bean
     * https://itqna.net/questions/15083/how-download-pdf-file-jsf
     * http://www.iana.org/assignments/media-types
     *
     * PDF https://www.adobe.com/be_en/active-use/pdf/Alice_in_Wonderland.pdf
     *
     * @throws java.io.IOException
     */
    public void download() throws IOException {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();

        // Some JSF component library or some Filter might have set some headers in the buffer beforehand. We want to get rid of them, else it may collide.
        ec.responseReset();
        ec.setResponseContentType("application/pdf");
        String filename = "Alice_in_Wonderland.pdf";
        // This header is optional. It will work if it's omitted, but the download progress will be unknown.
        // The Save As popup magic is done here. 
        ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
        OutputStream output = ec.getResponseOutputStream();

        URL url = new URL("https://www.adobe.com/be_en/active-use/pdf/Alice_in_Wonderland.pdf");
        InputStream pdfInputStream = url.openStream();

        byte[] bytesBuffer = new byte[2048];
        int bytesRead;
        while ((bytesRead = pdfInputStream.read(bytesBuffer)) > 0) {
            output.write(bytesBuffer, 0, bytesRead);
        }
        output.flush();

        pdfInputStream.close();
        output.close();

        // Important! Otherwise JSF will attempt to render the response which obviously will fail since it's already written with a file and closed.
        fc.responseComplete();
    }

    /**
     * Find a book with same isbn else redirect to error page
     *
     * @author Shruti Pareek
     * @param isbn
     * @throws java.io.IOException
     */
    public void findBook(String isbn) throws IOException {
        LOG.debug("findBook");

        try {
            this.book = this.bookCtrlr.findBook(isbn);
        } catch (NoResultException e) {
            /*
        TODO: redirect to error page because this book does not exist or is removed once error page is created
             */
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        }

    }

    /**
     * Get book to display book page and set url parameters to isbn
     *
     * @author Shruti Pareek
     * @return Book
     * @throws java.io.IOException
     */
    public Book getBook() throws IOException {
        LOG.debug("getBook");
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        String isbn = params.get("isbn");

        if (isbn != null) {
            LOG.debug("getBook" + isbn);
            findBook(isbn);
        }

        return this.book;
    }
}
