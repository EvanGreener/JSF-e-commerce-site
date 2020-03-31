/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.CustomerReviews;
import com.gb1w20.book_store_project.jpa_controllers.CustomerReviewsJpaController;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author 06spa
 */
@Named("reviewBean")
@ViewScoped
public class ReviewBean implements Serializable {

    @Inject
    private CustomerReviewsJpaController customerReviewCtlr;
    private int averageRating;
    private int reviewCount;
    private List<CustomerReviews> reviews;
    private List<SelectItem> ratings = new ArrayList<SelectItem>();
    private String title;
    private String reviewBody;
    private CustomerReviews customerReview;
    private int page = 1;
    private int numPages;
    private String isbn;
    private List<CustomerReviews> results;
    private Integer ratingChoice = 0;
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

    public int getUserWrittenReviews(Integer clientId, String isbn) {
        LOG.debug("getUserWrittenReviews");
        int size=customerReviewCtlr.findCustomerReviewsByClientId(clientId, isbn).size();
        LOG.debug("client "+ clientId+ " has "+size+ " amount of reviews");
        return size;
    }
    
    
     public void validateReviewBody(FacesContext context, UIComponent component, Object value) throws Exception {
        String review = (String)value;
        if (review == null|| review.isBlank()) {
            String message = context.getApplication().evaluateExpressionGet(context, "Please enter a review", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
        if (review.length()>750) {
            String message = context.getApplication().evaluateExpressionGet(context, "Reviews are limited to 750 characters", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
        
    }
     public void validateReviewTitle(FacesContext context, UIComponent component, Object value) throws Exception {
        String review = (String)value;
        if (review == null || review.isBlank()) {
            String message = context.getApplication().evaluateExpressionGet(context, "Please enter a review", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
        if (review.length()>150) {
            String message = context.getApplication().evaluateExpressionGet(context, "Reviews are limited to 150 characters", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
        
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

    public Integer getRatingChoice() {
        LOG.debug("getRatingChoice");
        return this.ratingChoice;
    }

    public void setRatingChoice(Integer choice) {
        LOG.debug("setRatingChoice");
        this.ratingChoice = choice;
    }

//    public String getIsbn() {
//        LOG.debug("happened");
//        return this.isbn;
//    }
//
//    public void setIsbn(String isbn) {
//        LOG.debug("happened set " + isbn);
//    }
    private Date getCurrentDateTime() {
        Date d = new Date();
        return d;
    }

    public void setCustomerReview(String isbn, Integer clientId) throws Exception {
        LOG.debug("setCustomerReview");
        customerReview = getCustomerReview();
        customerReview.setClientID(clientId);

        //to be removed after
        customerReview.setUpvotes(2);
        customerReview.setDownvotes(2);

        customerReview.setIsRemoved(Boolean.FALSE);
        customerReview.setPending(Boolean.TRUE);
        customerReview.setReviewBody(reviewBody);
        customerReview.setReviewTitle(title);
        customerReview.setRating(ratingChoice);
        customerReview.setIsbn(isbn);

        customerReview.setDateEntered(getCurrentDateTime());
        customerReview.setLastModified(getCurrentDateTime());
        createCustomerReview();
    }

    public int getPage() {
        return page;
    }

    public void setPage(int newValue) {
        page = newValue;
    }

    public void onPrevious() throws IOException {
        page--;

        updateReviewBean(this.isbn);
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int newValue) {
        numPages = newValue;
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
                ratings.add(new SelectItem(i, "" + i));
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

    public void onPageSelect(int newPage) throws IOException {
        LOG.debug("onPageSelect");
        page = newPage;
        updateReviewBean(this.isbn);
    }

    public void onNext() throws IOException {
        LOG.debug("onNext");
        page++;

        updateReviewBean(this.isbn);
    }

    public int getAverageRating(String isbn) {
        LOG.debug("getAverageRating");
        this.isbn = isbn;
        this.averageRating = (int) customerReviewCtlr.getAverageRating(isbn);
        return this.averageRating;
    }

    public int getReviewCount(String isbn) {
        LOG.debug("getReviewCount");
        this.isbn = isbn;
        this.reviewCount = customerReviewCtlr.getCustomerReviewsCount(isbn);
        return this.reviewCount;

    }

    public List<CustomerReviews> updateReviewBean(String isbn) throws IOException {
        LOG.debug("updateReviewBean");
        results = getReviews(isbn);
        numPages = (int) Math.ceil(results.size() / 4.0);
        return results;

    }

}
