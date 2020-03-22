/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.jpa_controllers.CustomerReviewsJpaController;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author 06spa
 */
@Named("reviewBean")
@SessionScoped
public class ReviewBean implements Serializable {

    @Inject
    private CustomerReviewsJpaController customerReviewCtlr;
    private Integer averageRating;
    private final static Logger LOG = LoggerFactory.getLogger(ReviewBean.class);

    @PostConstruct
    public void init() {
        LOG.debug("Init called!");

    }
    
    public Object[] getRating(Integer size){
        return new Object[size];
    }
    public Integer getAverageRating(String isbn){
        this.averageRating=customerReviewCtlr.getAverageRating(isbn);
        return this.averageRating;
    }
}
