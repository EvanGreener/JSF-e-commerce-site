package com.gb1w20.book_store_project.entities;

import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.entities.Orders;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.6.v20200131-rNA", date="2020-03-13T17:44:33")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-03-14T16:59:55", comments="EclipseLink-2.7.5.v20191016-rNA")
>>>>>>> 8d316432bd144393d7fe4b6b5e15ea2cd8b0e60e
@StaticMetamodel(OrderItem.class)
public class OrderItem_ { 

    public static volatile SingularAttribute<OrderItem, Integer> itemID;
    public static volatile SingularAttribute<OrderItem, Date> lastUpdated;
    public static volatile SingularAttribute<OrderItem, Boolean> isRemoved;
    public static volatile SingularAttribute<OrderItem, Integer> orderID;
    public static volatile SingularAttribute<OrderItem, Double> priceSold;
    public static volatile SingularAttribute<OrderItem, String> isbn;
    public static volatile SingularAttribute<OrderItem, Book> book;
    public static volatile SingularAttribute<OrderItem, Orders> order;

}