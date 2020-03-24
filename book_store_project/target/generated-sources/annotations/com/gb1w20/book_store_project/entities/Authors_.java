package com.gb1w20.book_store_project.entities;

import com.gb1w20.book_store_project.entities.Book;
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
@StaticMetamodel(Authors.class)
public class Authors_ { 

    public static volatile SingularAttribute<Authors, Date> dateEntered;
    public static volatile SingularAttribute<Authors, Boolean> isRemoved;
    public static volatile ListAttribute<Authors, Book> booksCollection;
    public static volatile SingularAttribute<Authors, String> name;
    public static volatile SingularAttribute<Authors, Date> lastModified;
    public static volatile SingularAttribute<Authors, Integer> authorID;

}