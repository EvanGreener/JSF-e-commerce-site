/*
 * This package stores all beans used to access controller classses
 */
package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.News;
import com.gb1w20.book_store_project.jpa_controllers.NewsJpaController;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bean that get randomly generated news that is used in index/client front door
 * page
 *
 * @author Shruti Pareek
 */
@Named("newsBean")
@RequestScoped
public class NewsBean implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(NewsBean.class);

    @Inject
    private NewsJpaController newsJpaController;
    private News randomNews;

    /**
     * method that get random news
     *
     * @author Shruti Pareek
     * @return News
     */
    public News getRandomNews() {
        LOG.debug("getRandomNews");
        this.randomNews = newsJpaController.getRandomNews();
        return this.randomNews;
    }

    /**
     * method that set the news
     *
     * @author Shruti Pareek
     * @param news
     */
    public void setRandomNews(News news) {
        LOG.debug("setRandomNews");
        this.randomNews = news;
    }
}
