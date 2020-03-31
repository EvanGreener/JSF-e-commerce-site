/*
 * This package stores all beans used to access controller classses
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
 * Review management bean is used for the managerReviews page It allows manager
 * to edit a review and get its status A review has a removal status that can be
 * true or false A review also has a pending status that can be true or false
 *
 * @author Shruti Pareek
 */
@Named("reviewManagmentBean")
@SessionScoped
public class ReviewManagementBean implements Serializable {

    @Inject
    private CustomerReviewsJpaController customerReviewCtlr;

    private CustomerReviews customerReview;

    private final static Logger LOG = LoggerFactory.getLogger(ReviewManagementBean.class);

    @PostConstruct
    /**
     * Bean initialize method
     *
     * @return void
     */
    public void init() {
        LOG.debug("Init called!");

    }

    /**
     * CustomerReviews created if it does not exist.
     *
     * @return CustomerReviews
     */
    public CustomerReviews getCustomerReview() {
        LOG.debug("getCustomerReview");
        if (customerReview == null) {
            customerReview = new CustomerReviews();
        }
        return customerReview;
    }

    /**
     * Get opposite of boolean given to it
     *
     * @return boolean
     */
    private boolean getOpposite(Boolean isRemoved) {
        LOG.debug("getOpposite");
        if (isRemoved) {
            isRemoved = false;
        } else {
            isRemoved = true;
        }
        return isRemoved;
    }

    /**
     * Gets current date and time
     *
     * @return Date
     */
    private Date getCurrentDateTime() {
        LOG.debug("getCurrentDateTime");
        Date d = new Date();
        return d;
    }

    /**
     * Edits a review's fields
     *
     * @return void
     */
    private void editReview(boolean isRemoved, Integer reviewId, boolean pending) throws Exception {
        LOG.debug("editReview");
        LOG.debug(reviewId + "");
        getCustomerReview();
        this.customerReview = customerReviewCtlr.findCustomerReviews(reviewId);
        this.customerReview.setIsRemoved(isRemoved);

        //set removed date if review removed
        if (isRemoved) {
            this.customerReview.setDateRemoved(getCurrentDateTime());
        }

        this.customerReview.setLastModified(getCurrentDateTime());

        //change pending status to no longer pending
        if (pending) {
            pending = getOpposite(pending);
            this.customerReview.setPending(pending);
        }
        customerReviewCtlr.edit(customerReview);
    }

    /**
     * called when approve or unapprove button is clicked edits review and
     *
     *
     * @return void
     */
    public void manageApproval(boolean isRemoved, Integer reviewId, boolean pending) throws Exception {

        LOG.debug("manageApproval");
        LOG.debug(reviewId + "");
        isRemoved = getOpposite(isRemoved);
        //modify a review's values
        editReview(isRemoved, reviewId, pending);

    }

    /**
     * returns string pending if pending true and reviewed if false
     *
     * @return String
     */
    public String getPendingStatus(boolean pending) {
        LOG.debug("getRemovalStatus");
        if (pending) {
            return "Pending";
        } else {
            return "Reviewed";
        }
    }

    /**
     * returns string approve is isRemoved true and unapprove if false
     *
     * @return String
     */
    public String getRemovalStatus(boolean isRemoved) {
        LOG.debug("getRemovalStatus");
        if (isRemoved) {
            return "Approve";
        } else {
            return "Unapprove";
        }
    }

}
