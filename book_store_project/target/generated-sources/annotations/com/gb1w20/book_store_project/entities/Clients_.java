package com.gb1w20.book_store_project.entities;

import com.gb1w20.book_store_project.entities.CustomerReviews;
import com.gb1w20.book_store_project.entities.Orders;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.1.v20171221-rNA", date="2020-03-23T20:30:44")
=======
@Generated(value="EclipseLink-2.7.6.v20200131-rNA", date="2020-03-22T13:20:43")
>>>>>>> 696713a0c5f5cdfa7556dc092b4fa3836edbb6ee
@StaticMetamodel(Clients.class)
public class Clients_ { 

    public static volatile SingularAttribute<Clients, String> lastName;
    public static volatile SingularAttribute<Clients, String> country;
    public static volatile SingularAttribute<Clients, Integer> clientID;
    public static volatile SingularAttribute<Clients, String> address2;
    public static volatile SingularAttribute<Clients, String> city;
    public static volatile SingularAttribute<Clients, String> provinceAbbreviation;
    public static volatile SingularAttribute<Clients, String> hashedPassword;
    public static volatile SingularAttribute<Clients, String> address1;
    public static volatile SingularAttribute<Clients, String> companyName;
    public static volatile SingularAttribute<Clients, String> postalCode;
    public static volatile ListAttribute<Clients, Orders> ordersCollection;
    public static volatile SingularAttribute<Clients, String> firstName;
    public static volatile SingularAttribute<Clients, Date> dateEntered;
    public static volatile SingularAttribute<Clients, Boolean> isRemoved;
    public static volatile ListAttribute<Clients, CustomerReviews> reviews;
    public static volatile SingularAttribute<Clients, Boolean> isManager;
    public static volatile SingularAttribute<Clients, String> cellTelephone;
    public static volatile SingularAttribute<Clients, Date> lastModified;
    public static volatile SingularAttribute<Clients, String> homeTelephone;
    public static volatile SingularAttribute<Clients, String> email;

}