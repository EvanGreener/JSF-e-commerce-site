package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.jpa_controllers.BookJpaController;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;

@Named("search")
@RequestScoped
public class SearchBean implements Serializable {

    @Inject
    private BookJpaController bookCtrlr;

    private String query;
    private String[] genreFilters;
    private String searchBy;
    private List<Book> results;
    private int page = 1;
    private int numPages;

    @PostConstruct
    public void init() {
        page = 1;
        query = "";
        results = !query.isBlank() ? bookCtrlr.search(query, page) : bookCtrlr.findBookEntities();
        numPages = (int) Math.ceil(results.size() / 8.0);
    }


    public String[] getGenreFilters() {
        return genreFilters;
    }

    public void setGenreFilters(String[] newValue) {
        genreFilters = newValue;
    }

    public String getSearchBy() {
        return searchBy;
    }

    public void setSearchBy(String newValue) {
        searchBy = newValue;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String newValue) {
        query = newValue;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int newValue) {
        page = newValue;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int newValue) {
        numPages = newValue;
    }

    public List<Book> getResults() {
        return results;
    }

    public void onKeyUp(AjaxBehaviorEvent event) {
        results = !query.isBlank() ? bookCtrlr.search(query, page) : bookCtrlr.findBookEntities();
        numPages = (int) Math.ceil(results.size() / 8.0);
    }
}
