package com.gb1w20.book_store_project.entities;

import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.entities.Orders;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-04-12T23:31:25", comments="EclipseLink-2.7.6.v20200131-rNA")
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