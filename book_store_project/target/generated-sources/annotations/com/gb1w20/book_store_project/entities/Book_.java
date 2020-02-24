package com.gb1w20.book_store_project.entities;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-02-24T13:28:05", comments="EclipseLink-2.7.6.v20200131-rNA")
@StaticMetamodel(Book.class)
public class Book_ { 

    public static volatile SingularAttribute<Book, Integer> numOfPages;
    public static volatile SingularAttribute<Book, BigDecimal> salePrice;
    public static volatile SingularAttribute<Book, String> isbn;
    public static volatile SingularAttribute<Book, String> description;
    public static volatile SingularAttribute<Book, String> title;
    public static volatile SingularAttribute<Book, Date> dateOfPublication;
    public static volatile SingularAttribute<Book, Date> dateEntered;
    public static volatile SingularAttribute<Book, Integer> publisherID;
    public static volatile SingularAttribute<Book, Boolean> isRemoved;
    public static volatile SingularAttribute<Book, String> genre;
    public static volatile SingularAttribute<Book, Date> lastModified;
    public static volatile SingularAttribute<Book, BigDecimal> wholesalePrice;
    public static volatile SingularAttribute<Book, BigDecimal> listPrice;

}