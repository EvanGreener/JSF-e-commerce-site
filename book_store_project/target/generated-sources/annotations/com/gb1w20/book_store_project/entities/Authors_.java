package com.gb1w20.book_store_project.entities;

import com.gb1w20.book_store_project.entities.Book;
import java.util.Date;
<<<<<<< HEAD
import javax.annotation.Generated;
=======
import javax.annotation.processing.Generated;
>>>>>>> ae0a3269f74b7348242b90dd3978ceecbdc978ce
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.1.v20171221-rNA", date="2020-03-01T10:26:33")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-03-04T13:58:01", comments="EclipseLink-2.7.6.v20200131-rNA")
>>>>>>> ae0a3269f74b7348242b90dd3978ceecbdc978ce
@StaticMetamodel(Authors.class)
public class Authors_ { 

    public static volatile SingularAttribute<Authors, Date> dateEntered;
    public static volatile SingularAttribute<Authors, Boolean> isRemoved;
    public static volatile ListAttribute<Authors, Book> booksCollection;
    public static volatile SingularAttribute<Authors, String> name;
    public static volatile SingularAttribute<Authors, Date> lastModified;
    public static volatile SingularAttribute<Authors, Integer> authorID;

}