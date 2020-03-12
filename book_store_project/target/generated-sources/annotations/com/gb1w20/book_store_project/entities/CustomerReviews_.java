package com.gb1w20.book_store_project.entities;

import com.gb1w20.book_store_project.entities.Book;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.1.v20171221-rNA", date="2020-03-11T09:31:20")
@StaticMetamodel(CustomerReviews.class)
public class CustomerReviews_ { 

    public static volatile SingularAttribute<CustomerReviews, Integer> clientID;
    public static volatile SingularAttribute<CustomerReviews, Integer> upvotes;
    public static volatile SingularAttribute<CustomerReviews, String> isbn;
    public static volatile SingularAttribute<CustomerReviews, Boolean> pending;
    public static volatile SingularAttribute<CustomerReviews, Book> book;
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