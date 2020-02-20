package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.jpa_controllers.BookJpaController;
import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named("search")
@RequestScoped
public class SearchBean implements Serializable {

    @Inject
    private BookJpaController bookCtrlr;

    private String query = "";

    private String[] genreFilters = {"All"};
    private String searchBy = "";
//    private int page = 0;

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

    public List<Book> getResults() {

        if (!query.isBlank()) {
            List<Book> l = bookCtrlr.search(query);
            return l;

        }
        return bookCtrlr.findBookEntities();

    }
}
