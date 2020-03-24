/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.CustomerReviews;
import com.gb1w20.book_store_project.jpa_controllers.CustomerReviewsJpaController;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
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
    private Double averageRating;
    private int reviewCount;
    private List<CustomerReviews> reviews;
    private List<SelectItem> ratings = new ArrayList<SelectItem>();
    private String title;
    private String reviewBody;
    private CustomerReviews customerReview;

    private final static Logger LOG = LoggerFactory.getLogger(ReviewBean.class);

    @PostConstruct
    public void init() {
        LOG.debug("Init called!");

    }

    /**
     * CustomerReviews created if it does not exist.
     *
     * @return
     */
    public CustomerReviews getCustomerReview() {
        LOG.debug("getCustomerReview");
        if (customerReview == null) {
            customerReview = new CustomerReviews();
        }
        return customerReview;
    }

    /**
     * Save the current customerReview to the db
     *
     * @return
     * @throws Exception
     */
    public String createCustomerReview() throws Exception {
        LOG.debug("createCustomerReview");
        customerReviewCtlr.create(customerReview);
        return null;
    }

    public void setCustomerReview(String isbn) throws Exception {
        LOG.debug("setCustomerReview");
        customerReview.setReviewBody(reviewBody);
        customerReview.setReviewTitle(title);
        customerReview.setRating(5);
        customerReview.setIsbn(isbn);
        createCustomerReview();
    }

    public void setReviewBody(String review) {
        LOG.debug("setReviewBody");
        this.reviewBody = review;
    }

    public String getReviewBody() {
        LOG.debug("getReviewBody");
        return this.reviewBody;
    }

    public void setTitle(String title) {
        LOG.debug("setTitle");
        this.title = title;
    }

    public String getTitle() {
        LOG.debug("getTitle");
        return this.title;
    }

    public List<SelectItem> getRatings() {
        LOG.debug("getRatings");
        if (ratings.isEmpty()) {
            for (int i = 0; i < 6; i++) {
                ratings.add(new SelectItem("" + i, "" + i));
            }
        }
        return ratings;
    }

    public void setRatings(List<SelectItem> ratings) {
        LOG.debug("setRatings");
        this.ratings = ratings;
    }

    public List<CustomerReviews> getReviews(String isbn) {
        LOG.debug("getReviews");
        this.reviews = customerReviewCtlr.getReviews(isbn);
        return this.reviews;
    }

    public Object[] getRating(Integer size) {
        LOG.debug("getRating");
        return new Object[size];
    }

    public Double getAverageRating(String isbn) {
        LOG.debug("getAverageRating");
        this.averageRating = customerReviewCtlr.getAverageRating(isbn);
        return this.averageRating;
    }

    public int getReviewCount(String isbn) {
        LOG.debug("getReviewCount");
        this.reviewCount = customerReviewCtlr.getCustomerReviewsCount(isbn);
        return this.reviewCount;
    }
}
