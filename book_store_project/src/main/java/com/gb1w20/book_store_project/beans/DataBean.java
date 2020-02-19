package com.gb1w20.book_store_project.beans;

import java.io.Serializable;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named("data")
@SessionScoped
public class DataBean implements Serializable {
    
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

}
