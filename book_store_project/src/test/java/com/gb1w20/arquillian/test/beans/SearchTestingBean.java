/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.arquillian.test.beans;

import com.gb1w20.book_store_project.entities.Book;
import java.util.List;

/**
 *
 * @author giancarlo
 */
public class SearchTestingBean {
    public String queryString;
    public String searchByField;
    public List<Book> results;
    public int expectedSize;
    
    public SearchTestingBean(String queryString, String searchByField, 
             int expectedSize)
    {
        this.queryString = queryString;
        this.searchByField = searchByField;
        this.expectedSize = expectedSize;
    }
}
