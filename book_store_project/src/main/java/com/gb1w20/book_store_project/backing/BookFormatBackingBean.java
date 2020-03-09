package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.entities.BookFormat;
import com.gb1w20.book_store_project.jpa_controllers.BookFormatJpaController;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("bookFormatBacking")
@RequestScoped
public class BookFormatBackingBean implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(BookFormatBackingBean.class);

    @Inject
    private BookFormatJpaController bookFormatJpaController;

    private BookFormat bookFormat;

    /**
     * BookFormats created if it does not exist.
     *
     * @return
     */
    public BookFormat getBookFormat() {
        if (bookFormat == null) {
            bookFormat = new BookFormat();
        }
        return bookFormat;
    }

    /**
     * Save the current bookFormat to the db
     *
     * @return
     * @throws Exception
     */
    public String createBookFormat() throws Exception {
        bookFormatJpaController.create(bookFormat);
        return null;
    }
}
