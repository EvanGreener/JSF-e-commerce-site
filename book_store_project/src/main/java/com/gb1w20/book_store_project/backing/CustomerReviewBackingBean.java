package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.entities.CustomerReviews;
import com.gb1w20.book_store_project.jpa_controllers.CustomerReviewsJpaController;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("customerReviewBacking")
@RequestScoped
public class CustomerReviewBackingBean implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(CustomerReviewBackingBean.class);

    @Inject
    private CustomerReviewsJpaController customerReviewsJpaController;

    private CustomerReviews customerReview;

    /**
     * CustomerReviews created if it does not exist.
     *
     * @return
     */
    public CustomerReviews getCustomerReview() {
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
        customerReviewsJpaController.create(customerReview);
        return null;
    }
}
