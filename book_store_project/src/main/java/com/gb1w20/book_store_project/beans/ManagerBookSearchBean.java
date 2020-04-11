package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.jpa_controllers.BookJpaController;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bean for updating the book search criteria on the manager-side inventory page. Most of this code is taken from the gallery page book search bean designed by my teammate Evan Greenstein
 * @author Giancarlo Biasiucci, Evan Greenstein
 * @version April 4, 2020
 */
@Named("managerSearch")
@SessionScoped
public class ManagerBookSearchBean implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(ManagerBookSearchBean.class);

    @Inject
    private BookJpaController bookCtrlr;

    private String query = "";
    private String[] genreFilters;
    private String searchBy = "title";
    private List<Book> results;
    private int page = 1;
    private String surveyChoice;
    private String isbn;

    /**
     * Method by Evan Greenstein
     */
    @PostConstruct
    public void init() {
        LOG.debug("Init called!");
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        String genre = params.get("genre");
        String query = params.get("query");

        if (genre != null) {
            setGenreFilters(genre);
        }
        if (query != null) {
            setQuery(query);
        }
        try {
            updateSearchBean();
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(SearchBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String[] getGenreFilters() {
        return genreFilters;
    }

    private void resetGenreFilters() {
        this.genreFilters = null;
    }

    private void resetQuery() {
        setQuery("");
    }

    private void resetSearchBy() {
        setSearchBy("title");
    }


    public void setGenreFilters(String[] newValue) {
        genreFilters = newValue;
    }

    public void setGenreFilters(String newValue) {
        genreFilters = new String[]{newValue};
    }

    public String getSearchBy() {
        return searchBy;
    }

    public void setSearchBy(String newValue) {
        searchBy = newValue;
    }

    public String getQuery() {
        LOG.debug("getQuery");
        return query;
    }

    public void setQuery(String newValue) {
        LOG.debug("setQuery");
        query = newValue;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int newValue) {
        page = newValue;
    }

    public List<Book> getResults() {
        return results;
    }

    /**
     * Method by Evan Greenstein, modified by myself to reflect manager side look and feel
     * @author Giancarlo Biasiucci, Evan Greenstein.
     * @throws IOException 
     */
    private void updateSearchBean() throws IOException {
        
        //Since this is a manager-side page, all books are displayed, as opposed to only those
        //which are not "removed"
        List<Book> res = searchBy != null && !query.isBlank() ? bookCtrlr.searchAllBooks(searchBy, query, page) : bookCtrlr.findBookEntities();

        LOG.debug(query);
        LOG.debug(searchBy);

        results = genreFilters == null || genreFilters.length == 0 ? res : res.stream()
                .filter(book -> Arrays.asList(genreFilters).contains(book.getGenre()))
                .collect(Collectors.toList());
        
        //reinitializing query,genrefilters,and search by so it does not affect the next search
        //ideally code should be here once button is added near search bar
        /*
            resetQuery();
            resetGenreFilters();
            resetSearchBy();
        
        */
    }

    public void onKeyUp() throws IOException {
        page = 1;
        updateSearchBean();
    }

    public void onPageSelect(int newPage) throws IOException {
        page = newPage;
        updateSearchBean();
    }

    public void onPrevious() throws IOException {
        page--;
        System.out.println(query);

        updateSearchBean();
    }

    public void onNext() throws IOException {
        page++;
        System.out.println(query);

        updateSearchBean();
    }

    public void onChecked() throws IOException {
        updateSearchBean();
    }

    public String showGenreBooks(String genre) {
        setGenreFilters(genre);
        resetQuery();
        resetSearchBy();
        return "gallery";
    }

    public String showSearch() {
        resetGenreFilters();
        resetSearchBy();
        return "gallery";
    }
}
