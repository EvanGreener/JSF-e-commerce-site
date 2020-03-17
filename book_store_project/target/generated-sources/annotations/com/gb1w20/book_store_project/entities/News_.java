package com.gb1w20.book_store_project.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.6.v20200131-rNA", date="2020-03-17T10:53:47")
@StaticMetamodel(News.class)
public class News_ { 

    public static volatile SingularAttribute<News, Integer> newsID;
    public static volatile SingularAttribute<News, Date> dateCreated;
    public static volatile SingularAttribute<News, Boolean> isRemoved;
    public static volatile SingularAttribute<News, Date> dateEnded;
    public static volatile SingularAttribute<News, String> rSSFeed;
    public static volatile SingularAttribute<News, Date> lastModified;

}