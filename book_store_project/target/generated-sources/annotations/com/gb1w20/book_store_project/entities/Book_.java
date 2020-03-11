package com.gb1w20.book_store_project.entities;

import com.gb1w20.book_store_project.entities.Authors;
import com.gb1w20.book_store_project.entities.CustomerReviews;
import com.gb1w20.book_store_project.entities.OrderItem;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.1.v20171221-rNA", date="2020-03-10T20:42:44")
@StaticMetamodel(Book.class)
public class Book_ { 

    public static volatile SingularAttribute<Book, Integer> numOfPages;
    public static volatile SingularAttribute<Book, BigDecimal> salePrice;
    public static volatile SingularAttribute<Book, String> isbn;
    public static volatile SingularAttribute<Book, String> description;
    public static volatile SingularAttribute<Book, String> title;
    public static volatile SingularAttribute<Book, Date> dateOfPublication;
    public static volatile SingularAttribute<Book, Date> dateEntered;
    public static volatile SingularAttribute<Book, Integer> publisherID;
    public static volatile SingularAttribute<Book, Boolean> isRemoved;
    public static volatile ListAttribute<Book, CustomerReviews> reviews;
    public static volatile SingularAttribute<Book, String> genre;
    public static volatile ListAttribute<Book, Authors> authorsCollection;
    public static volatile ListAttribute<Book, OrderItem> orders;
    public static volatile SingularAttribute<Book, Date> lastModified;
    public static volatile SingularAttribute<Book, BigDecimal> wholesalePrice;
    public static volatile SingularAttribute<Book, BigDecimal> listPrice;

}