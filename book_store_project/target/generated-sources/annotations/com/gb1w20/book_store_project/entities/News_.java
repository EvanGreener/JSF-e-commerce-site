package com.gb1w20.book_store_project.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.1.v20171221-rNA", date="2020-03-10T23:00:12")
=======
@Generated(value="EclipseLink-2.7.1.v20171221-rNA", date="2020-03-10T20:42:44")
>>>>>>> client_homepage
@StaticMetamodel(News.class)
public class News_ { 

    public static volatile SingularAttribute<News, Integer> newsID;
    public static volatile SingularAttribute<News, Date> dateCreated;
    public static volatile SingularAttribute<News, Boolean> isRemoved;
    public static volatile SingularAttribute<News, Date> dateEnded;
    public static volatile SingularAttribute<News, String> rSSFeed;
    public static volatile SingularAttribute<News, Date> lastModified;

}