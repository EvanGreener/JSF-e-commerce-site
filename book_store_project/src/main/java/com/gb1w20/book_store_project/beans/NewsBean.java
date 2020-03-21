/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

@Named("newsBean")
@RequestScoped
public class NewsBean implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(NewsBean.class);

    @Inject
    private NewsJpaController newsJpaController;
    private News randomNews;
    
     public News getRandomNews(){
        this.randomNews=newsJpaController.getRandomNews();
        return this.randomNews;
    }
    public void setRandomNews(News news){
        this.randomNews=news;
    }
}
