/*
 * This package stores all beans used to access controller classses
 */
package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.CustomerReviews;
import com.gb1w20.book_store_project.jpa_controllers.CustomerReviewsJpaController;
import com.gb1w20.book_store_project.util.MessageLoader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
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
 * bean used in the book page that gets all the information necessary for a
 * client review allows creating a new review
 *
 * @author Shruti Pareek
 */
@Named("reviewBean")
@ViewScoped
public class ReviewBean implements Serializable {

    @Inject
    private CustomerReviewsJpaController customerReviewCtlr;
    private int averageRating;
    private int reviewCount;
    private List<CustomerReviews> reviews;
    private List<SelectItem> ratings = new ArrayList<>();
    private String title;
    private String reviewBody;
    private CustomerReviews customerReview;
    private Integer ratingChoice = 0;
    private final static Logger LOG = LoggerFactory.getLogger(ReviewBean.class);

    @PostConstruct
    /**
     * method for initializing when bean called
     *
     * @author Shruti Pareek
     * @return void
     */
    public void init() {
        LOG.debug("Init called!");

    }

    /**
     * CustomerReviews created if it does not exist.
     *
     * @return customerReviews
     */
    public CustomerReviews getCustomerReview() {
        LOG.debug("getCustomerReview");
        if (customerReview == null) {
            customerReview = new CustomerReviews();
        }
        return customerReview;
    }

    /**
     * Get the number of reviews that a client has written on a book Used to
     * validate that customer has written only one review for a book
     *
     * @author Shruti Pareek
     * @param clientId
     * @param isbn
     * @return int
     */
    public int getUserWrittenReviews(Integer clientId, String isbn) {
        LOG.debug("getUserWrittenReviews");
        int size = customerReviewCtlr.findCustomerReviewsByClientId(clientId, isbn).size();
        LOG.debug("client " + clientId + " has " + size + " amount of reviews");
        return size;
    }

    /**
     * Validate that the review body text is less than 750 characters and not
     * empty or null
     *
     * @author Shruti Pareek
     * @param context
     * @param component
     * @param value
     * @throws java.lang.Exception
     */
    public void validateReviewBody(FacesContext context, UIComponent component, Object value) throws Exception {
        String review = (String) value;
        if (review == null || review.isBlank()) {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "addReviewMsg", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        if (review.length() > 750) {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "reviewCharLimit", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
            
        }

    }

    /**
     * Validate that the review title text is less than 150 characters and not
     * empty or null
     *
     * @author Shruti Pareek
     * @param context
     * @param component
     * @param value
     * @throws java.lang.Exception
     */
    public void validateReviewTitle(FacesContext context, UIComponent component, Object value) throws Exception {
        String review = (String) value;
        if (review == null || review.isBlank()) {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "addReviewMsg", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        if (review.length() > 150) {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "titleCharLimit", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

    }

    /**
     * Save the current customerReview to the db
     *
     * @author Shruti Pareek
     * @return String
     * @throws Exception
     */
    public String createCustomerReview() throws Exception {
        LOG.debug("createCustomerReview");
        customerReviewCtlr.create(customerReview);
        return null;
    }

    /**
     * Gets the rating for review default is 0
     *
     * @author Shruti Pareek
     * @return Integer
     */
    public Integer getRatingChoice() {
        LOG.debug("getRatingChoice");
        return this.ratingChoice;
    }

    /**
     * set the rating for review
     *
     * @author Shruti Pareek
     * @param choice
     */
    public void setRatingChoice(Integer choice) {
        LOG.debug("setRatingChoice");
        this.ratingChoice = choice;
    }

    /**
     * Gets current date and time
     *
     * @author Shruti Pareek
     * @return Date
     */
    private Date getCurrentDateTime() {
        Date d = new Date();
        return d;
    }

    /**
     * Creates a customer's review on submission
     *
     * @author Shruti Pareek
     * @param isbn
     * @param clientId
     * @throws java.lang.Exception
     */
    public void setCustomerReview(String isbn, Integer clientId) throws Exception {
        LOG.debug("setCustomerReview");
        customerReview = getCustomerReview();
        customerReview.setClientID(clientId);

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

    /**
     * set the review content
     *
     * @author Shruti Pareek
     * @param review
     */
    public void setReviewBody(String review) {
        LOG.debug("setReviewBody");
        this.reviewBody = review;
    }

    /**
     * get the review content
     *
     * @author Shruti Pareek
     * @return String
     */
    public String getReviewBody() {
        LOG.debug("getReviewBody");
        return this.reviewBody;
    }

    /**
     * set the title for review
     *
     * @author Shruti Pareek
     * @param title
     */
    public void setTitle(String title) {
        LOG.debug("setTitle");
        this.title = title;
    }

    /**
     * get the review title
     *
     * @author Shruti Pareek
     * @return String
     */
    public String getTitle() {
        LOG.debug("getTitle");
        return this.title;
    }

    /**
     * get the rating user had selected from select menu
     *
     * @author Shruti Pareek
     * @return rating
     */
    public List<SelectItem> getRatings() {
        LOG.debug("getRatings");
        if (ratings.isEmpty()) {
            for (int i = 0; i < 6; i++) {
                ratings.add(new SelectItem(i, "" + i));
            }
        }
        return ratings;
    }

    /**
     * set the default rating in select menu to 0
     *
     * @author Shruti Pareek
     * @param ratings
     */
    public void setRatings(List<SelectItem> ratings) {
        LOG.debug("setRatings");
        this.ratings = ratings;
    }

    /**
     * Get all reviews for a book
     *
     * @author Shruti Pareek
     * @param isbn
     * @return
     */
    public List<CustomerReviews> getReviews(String isbn) {
        LOG.debug("getReviews");
        this.reviews = customerReviewCtlr.getReviews(isbn);
        return this.reviews;
    }

    /**
     * Creates an array the same size as rating
     *
     * @author Shruti Pareek
     * @param size
     * @return array
     */
    public Object[] getRating(Integer size) {
        LOG.debug("getRating");
        return new Object[size];
    }

    /**
     * Get the average rating for a book
     *
     * @author Shruti Pareek
     * @param isbn
     * @return int
     */
    public int getAverageRating(String isbn) {
        LOG.debug("getAverageRating");
        this.averageRating = (int) customerReviewCtlr.getAverageRating(isbn);
        return this.averageRating;
    }

    /**
     * Get the amount of reviews for a book
     *
     * @author Shruti Pareek
     * @param isbn
     * @return int
     */
    public int getReviewCount(String isbn) {
        LOG.debug("getReviewCount");
        this.reviewCount = customerReviewCtlr.getCustomerReviewsCount(isbn);
        return this.reviewCount;

    }

}
