package com.gb1w20.book_store_project.entities;

import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.entities.Orders;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-04-12T17:50:07", comments="EclipseLink-2.7.6.v20200131-rNA")
=======
<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-04-12T15:45:54", comments="EclipseLink-2.7.6.v20200131-rNA")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-04-12T17:25:03", comments="EclipseLink-2.7.6.v20200131-rNA")
>>>>>>> 1b1f2db6be9f9dfefe62c6980aec5c1724ed60d0
>>>>>>> 83090cb9d8f2aed7d95fcbc73964f9fe8992adb2
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