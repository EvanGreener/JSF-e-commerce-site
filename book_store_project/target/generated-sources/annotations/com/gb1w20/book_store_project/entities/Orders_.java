package com.gb1w20.book_store_project.entities;

import com.gb1w20.book_store_project.entities.Clients;
import com.gb1w20.book_store_project.entities.OrderItem;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.1.v20171221-rNA", date="2020-04-07T17:06:40")
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, Date> lastUpdated;
    public static volatile SingularAttribute<Orders, Integer> clientID;
    public static volatile SingularAttribute<Orders, Date> dateCreated;
    public static volatile SingularAttribute<Orders, Boolean> isRemoved;
    public static volatile SingularAttribute<Orders, Integer> orderID;
    public static volatile SingularAttribute<Orders, Clients> client;
    public static volatile ListAttribute<Orders, OrderItem> orderItemsCollection;

}