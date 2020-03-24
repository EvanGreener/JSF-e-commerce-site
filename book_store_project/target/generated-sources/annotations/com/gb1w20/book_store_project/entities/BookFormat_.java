package com.gb1w20.book_store_project.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.1.v20171221-rNA", date="2020-03-23T20:30:44")
@StaticMetamodel(BookFormat.class)
public class BookFormat_ { 

    public static volatile SingularAttribute<BookFormat, Integer> formatID;
    public static volatile SingularAttribute<BookFormat, Date> dateCreated;
    public static volatile SingularAttribute<BookFormat, Boolean> isRemoved;
    public static volatile SingularAttribute<BookFormat, String> isbn;
    public static volatile SingularAttribute<BookFormat, String> format;
    public static volatile SingularAttribute<BookFormat, String> fileLocation;
    public static volatile SingularAttribute<BookFormat, Date> lastModified;

}