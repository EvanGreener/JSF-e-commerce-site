package com.gb1w20.book_store_project.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.6.v20200131-rNA", date="2020-03-22T13:20:43")
@StaticMetamodel(Publisher.class)
public class Publisher_ { 

    public static volatile SingularAttribute<Publisher, String> country;
    public static volatile SingularAttribute<Publisher, Integer> publisherID;
    public static volatile SingularAttribute<Publisher, String> address;
    public static volatile SingularAttribute<Publisher, String> phoneNumber;
    public static volatile SingularAttribute<Publisher, Date> dateCreated;
    public static volatile SingularAttribute<Publisher, Boolean> isRemoved;
    public static volatile SingularAttribute<Publisher, String> city;
    public static volatile SingularAttribute<Publisher, String> contactName;
    public static volatile SingularAttribute<Publisher, String> postalCode;
    public static volatile SingularAttribute<Publisher, String> name;
    public static volatile SingularAttribute<Publisher, Date> lastModified;

}