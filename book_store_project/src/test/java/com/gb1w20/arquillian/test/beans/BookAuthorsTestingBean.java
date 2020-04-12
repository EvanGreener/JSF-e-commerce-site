/*
 *All test beans belong to this package
 */
package com.gb1w20.arquillian.test.beans;

import com.gb1w20.book_store_project.entities.BookAuthors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bean used only for the purpose of performing arquillian tests on the
 * bookAuthors controller class
 *
 * @author shruti Pareek
 */
public class BookAuthorsTestingBean {

    private final static Logger LOG = LoggerFactory.getLogger(BookAuthorsTestingBean.class);

    public String isbn;
    public BookAuthors expectedBookAuthor;

    /**
     * Constructor takes all necessary input needed for testing
     *
     * @param isbn
     * @param expectedBookAuthor
     */
    public BookAuthorsTestingBean(String isbn, BookAuthors expectedBookAuthor) {
        LOG.debug("BookAuthorsTestingBean");
        this.isbn = isbn;
        this.expectedBookAuthor = expectedBookAuthor;
    }
}
