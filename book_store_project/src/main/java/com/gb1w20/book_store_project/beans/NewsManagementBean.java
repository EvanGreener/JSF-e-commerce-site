/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.News;
import com.gb1w20.book_store_project.jpa_controllers.NewsJpaController;
import com.gb1w20.book_store_project.jpa_controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author evan greenstein
 */
@Named("newsManagement")
@SessionScoped
public class NewsManagementBean implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(ClientManagementBean.class);

    @Inject
    private NewsJpaController newsCtrlr;
    private List<News> results;

    @PostConstruct
    public void init() {
        updateBean();
    }

    private void updateBean() {
        results = newsCtrlr.findNewsEntities();
    }

    public List<News> getResults() {
        return results;
    }

    public void onChangedRemoved(int id, boolean isRemoved) throws NonexistentEntityException, Exception {
        LOG.debug("onChangedRemoved called");
        LOG.debug("wasRemoved:   " + !isRemoved);
        News news = newsCtrlr.findNews(id);
        if (isRemoved) {
            news.setIsRemoved(Boolean.TRUE);

        } else {
            news.setIsRemoved(Boolean.FALSE);
        }

        newsCtrlr.edit(news);
    }

}
