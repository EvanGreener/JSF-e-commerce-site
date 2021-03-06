package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.entities.Publisher;
import com.gb1w20.book_store_project.jpa_controllers.PublisherJpaController;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("publisherBacking")
@RequestScoped
public class PublisherBackingBean implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(PublisherBackingBean.class);

    @Inject
    private PublisherJpaController publishersJpaController;

    private Publisher publisher;

    /**
     * Publisher created if it does not exist.
     *
     * @return
     */
    public Publisher getPublisher() {
        if (publisher == null) {
            publisher = new Publisher();
        }
        return publisher;
    }

    /**
     * Save the current publisher to the db
     *
     * @return
     * @throws Exception
     */
    public String createPublisher() throws Exception {
        publishersJpaController.create(publisher);
        return null;
    }
}
