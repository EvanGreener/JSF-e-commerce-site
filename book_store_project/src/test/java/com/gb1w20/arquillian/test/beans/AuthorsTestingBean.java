/*
 *All test beans belong to this package
 */
package com.gb1w20.arquillian.test.beans;

import com.gb1w20.book_store_project.entities.Authors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bean used only for the purpose of performing arquillian tests on the authors
 * controller class
 *
 * @author shruti Pareek
 */
public class AuthorsTestingBean {

    private final static Logger LOG = LoggerFactory.getLogger(AuthorsTestingBean.class);
    
    public Authors expectedAuthor;
    public String authorName;

    /**
     * Constructor takes all necessary input needed for testing
     *
     * @param expectedAuthor
     * @param authorName
     */
    public AuthorsTestingBean(Authors expectedAuthor, String authorName) {
         LOG.debug("AuthorsTestingBean");
        this.expectedAuthor = expectedAuthor;
        this.authorName = authorName;
    }

}
