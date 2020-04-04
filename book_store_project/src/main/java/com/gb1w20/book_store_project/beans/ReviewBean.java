/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.entities.CustomerReviews;
import com.gb1w20.book_store_project.jpa_controllers.CustomerReviewsJpaController;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
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
        this.isbn=isbn;
        customerReview.setReviewBody(reviewBody);
        customerReview.setReviewTitle(title);
        customerReview.setRating(5);
        customerReview.setIsbn(isbn);
        createCustomerReview();
    }
    public List<CustomerReviews> getResults() {
        return results;
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
        this.isbn=isbn;
        this.reviews = customerReviewCtlr.getReviews(isbn);
        return this.reviews;
    }

    public Object[] getRating(Integer size) {
        LOG.debug("getRating");
        return new Object[size];
    }

    public void onPageSelect(int newPage) throws IOException {
        page = newPage;
          updateReviewBean(this.isbn);
    }
    public void onNext() throws IOException {
        page++;

        updateReviewBean(this.isbn);
    }
    public int getAverageRating(String isbn) {
        LOG.debug("getAverageRating");
        this.isbn=isbn;
        this.averageRating = (int) customerReviewCtlr.getAverageRating(isbn);
        return this.averageRating;
    }

    public int getReviewCount(String isbn) {
        LOG.debug("getReviewCount");
        
        this.isbn=isbn;
        this.reviewCount = customerReviewCtlr.getCustomerReviewsCount(isbn);
        LOG.debug(this.reviewCount + "amount of reviews");
        return this.reviewCount;
        
    }
    
    public List<CustomerReviews> updateReviewBean(String isbn) throws IOException {

        results = getReviews(isbn);
        numPages = (int) Math.ceil(results.size() / 4.0);
        return results;
       
    }
    
}
