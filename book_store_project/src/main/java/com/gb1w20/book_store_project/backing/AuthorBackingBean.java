package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.entities.Authors;
import com.gb1w20.book_store_project.jpa_controllers.AuthorsJpaController;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("authorBacking")
@RequestScoped
public class AuthorBackingBean implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(AuthorBackingBean.class);

    @Inject
    private AuthorsJpaController authorsJpaController;

    private Authors author;

    /**
     * Authors created if it does not exist.
     *
     * @return
     */
    public Authors getAuthor() {
        if (author == null) {
            author = new Authors();
        }
        return author;
    }

    /**
     * Save the current author to the db
     *
     * @return
     * @throws Exception
     */
    public String createAuthor() throws Exception {
        authorsJpaController.create(author);
        return null;
    }
}
