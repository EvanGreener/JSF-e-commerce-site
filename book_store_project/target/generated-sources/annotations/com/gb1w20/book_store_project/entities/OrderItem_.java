package com.gb1w20.book_store_project.entities;

import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.entities.Orders;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.6.v20200131-rNA", date="2020-03-26T10:00:11")
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