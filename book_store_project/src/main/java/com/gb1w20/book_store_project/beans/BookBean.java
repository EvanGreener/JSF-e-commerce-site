package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.entities.OrderItem;
import com.gb1w20.book_store_project.jpa_controllers.BookJpaController;
import com.gb1w20.book_store_project.jpa_controllers.OrderItemJpaController;
import java.io.Serializable;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.chart.ChartSeries;
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
    private List<Book> similarGenreBooks;
    private String genre;
    private int bookSlideColor=0;

    @PostConstruct
    public void init() {
        LOG.debug("Init called!");

    }

    public int getBookSlideColor(){
        if(bookSlideColor==0){
            bookSlideColor++;
        }
        else if(bookSlideColor==1){
              bookSlideColor++;
        }
        else if(bookSlideColor==2){
            bookSlideColor++;
        }
        else{
            bookSlideColor=1;
        }
        return bookSlideColor;
    }
    public List<Book> getBestSeller() {
        LOG.debug("getBestSeller");
        bestSeller = bookCtrlr.getBestSeller();
        return bestSeller;
    }

    public List<Object> getPopularGenres() {
        LOG.debug("getPopularGenres");
        popularGenres = bookCtrlr.getPopularGenres();
        return popularGenres;
    }

    public List<Book> getRecentlyAdded() {
        LOG.debug("getRecentlyAdded");
        recentlyAdded = bookCtrlr.getRecentlyAdded();
        return recentlyAdded;
    }

    public String viewGenreBooks(String genre) {
        setGenre(genre);
        return "gallery";
    }

    public String viewBook(Book book) {
        LOG.debug("getSimilarGenresBooks");
        this.book = book;
        return "book.xhtml";
    }
    
    /**
     * Get books with similar genre that user is currently viewing
     * @param book
     * @return similarGenreBooks
     */
    public List<Book> getSimilarGenreBooks(Book book) {
        LOG.debug("getSimilarGenreBooks");
        similarGenreBooks = bookCtrlr.getSimilarGenres(book);
        return similarGenreBooks;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return this.genre;
    }

    public Book getBook() {
        return this.book;
    }
}
