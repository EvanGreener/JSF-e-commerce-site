package com.gb1w20.book_store_project.entities;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-02-13T15:48:41", comments="EclipseLink-2.7.6.v20200131-rNA")
@StaticMetamodel(CustomerReviews.class)
public class CustomerReviews_ { 

    public static volatile SingularAttribute<CustomerReviews, Integer> clientID;
    public static volatile SingularAttribute<CustomerReviews, Integer> upvotes;
    public static volatile SingularAttribute<CustomerReviews, String> isbn;
    public static volatile SingularAttribute<CustomerReviews, Boolean> pending;
    public static volatile SingularAttribute<CustomerReviews, Double> rating;
    public static volatile SingularAttribute<CustomerReviews, String> reviewBody;
    public static volatile SingularAttribute<CustomerReviews, Integer> downvotes;
    public static volatile SingularAttribute<CustomerReviews, String> reviewTitle;
    public static volatile SingularAttribute<CustomerReviews, Date> dateEntered;
    public static volatile SingularAttribute<CustomerReviews, Boolean> isRemoved;
    public static volatile SingularAttribute<CustomerReviews, Date> lastModified;
    public static volatile SingularAttribute<CustomerReviews, Integer> reviewID;
    public static volatile SingularAttribute<CustomerReviews, Date> dateRemoved;

}