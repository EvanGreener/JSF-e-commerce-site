package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.jpa_controllers.BookJpaController;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("bookBacking")
@RequestScoped
public class BookBackingBean implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(BookBackingBean.class);

    @Inject
    private BookJpaController bookJpaController;

    private Book book;

    /**
     * Books created if it does not exist.
     *
     * @return
     */
    public Book getBook() {
        if (book == null) {
            book = new Book();
        }
        return book;
    }

    /**
     * Save the current book to the db
     *
     * @return
     * @throws Exception
     */
    public String createBook() throws Exception {
        bookJpaController.create(book);
        return null;
    }
}
