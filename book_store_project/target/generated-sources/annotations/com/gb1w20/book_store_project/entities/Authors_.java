package com.gb1w20.book_store_project.entities;

import com.gb1w20.book_store_project.entities.Book;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.1.v20171221-rNA", date="2020-03-09T09:36:21")
@StaticMetamodel(Authors.class)
public class Authors_ { 

    public static volatile SingularAttribute<Authors, Date> dateEntered;
    public static volatile SingularAttribute<Authors, Boolean> isRemoved;
    public static volatile ListAttribute<Authors, Book> booksCollection;
    public static volatile SingularAttribute<Authors, String> name;
    public static volatile SingularAttribute<Authors, Date> lastModified;
    public static volatile SingularAttribute<Authors, Integer> authorID;

}