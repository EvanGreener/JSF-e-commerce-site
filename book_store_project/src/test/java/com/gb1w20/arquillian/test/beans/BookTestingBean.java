/*
 *All test beans belong to this package
 */
package com.gb1w20.arquillian.test.beans;

import com.gb1w20.book_store_project.entities.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bean used only for the purpose of performing arquillian tests on the book
 * controller class
 *
 * @author Shruti pareek
 */
public class BookTestingBean {

    private final static Logger LOG = LoggerFactory.getLogger(BookTestingBean.class);

    public Book book;
    public int expectedSimilar;
    public String expectedStatus;

    /**
     * Constructor takes all necessary input needed for testing
     *
     * @param book
     * @param expectedSimilar
     * @param expectedStatus
     */
    public BookTestingBean(Book book, int expectedSimilar, String expectedStatus) {
        LOG.debug("BookTestingBean");
        this.book = book;
        this.expectedSimilar = expectedSimilar;
        this.expectedStatus = expectedStatus;
    }
}
