package com.gb1w20.book_store_project.entities;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.6.v20200131-rNA", date="2020-03-13T17:44:33")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-03-14T16:59:55", comments="EclipseLink-2.7.5.v20191016-rNA")
>>>>>>> 8d316432bd144393d7fe4b6b5e15ea2cd8b0e60e
@StaticMetamodel(News.class)
public class News_ { 

    public static volatile SingularAttribute<News, Integer> newsID;
    public static volatile SingularAttribute<News, Date> dateCreated;
    public static volatile SingularAttribute<News, Boolean> isRemoved;
    public static volatile SingularAttribute<News, Date> dateEnded;
    public static volatile SingularAttribute<News, String> rSSFeed;
    public static volatile SingularAttribute<News, Date> lastModified;

}