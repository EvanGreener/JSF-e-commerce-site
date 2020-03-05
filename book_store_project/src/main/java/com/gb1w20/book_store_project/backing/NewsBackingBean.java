package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.entities.News;
import com.gb1w20.book_store_project.jpa_controllers.NewsJpaController;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("newsBacking")
@RequestScoped
public class NewsBackingBean implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(NewsBackingBean.class);

    @Inject
    private NewsJpaController newssJpaController;

    private News news;

    /**
     * Newss created if it does not exist.
     *
     * @return
     */
    public News getNews() {
        if (news == null) {
            news = new News();
        }
        return news;
    }

    /**
     * Save the current news to the db
     *
     * @return
     * @throws Exception
     */
    public String createNews() throws Exception {
        newssJpaController.create(news);
        return null;
    }
}
