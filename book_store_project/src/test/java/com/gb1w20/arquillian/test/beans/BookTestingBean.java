/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.arquillian.test.beans;

import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.entities.Clients;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Shruti pareek
 */
public class BookTestingBean {

    private final static Logger LOG = LoggerFactory.getLogger(BookTestingBean.class);
    public Book book;

    public BookTestingBean(Book book) {
        this.book = book;
    }
}
