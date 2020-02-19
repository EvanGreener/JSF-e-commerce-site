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

    public String getQuery() {
        return query;
    }

    public void setQuery(String newValue) {
        query = newValue;
    }
    

    public List<Book> getResults() {
        
        if (!query.isBlank()) {
            List<Book> l = bookCtrlr.search(query);

            System.out.println(l);

            return l;
        }
        return null;
    }
}
