package com.gb1w20.book_store_project.entities;

import com.gb1w20.book_store_project.entities.Authors;
import com.gb1w20.book_store_project.entities.BookFormat;
import com.gb1w20.book_store_project.entities.Clients;
import com.gb1w20.book_store_project.entities.CustomerReviews;
import com.gb1w20.book_store_project.entities.OrderItem;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-04-12T18:39:08", comments="EclipseLink-2.7.6.v20200131-rNA")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-04-12T19:18:42", comments="EclipseLink-2.7.6.v20200131-rNA")
>>>>>>> abb303246aa7c2ebad76bed714efe8bee5117810
@StaticMetamodel(Book.class)
public class Book_ { 

    public static volatile SingularAttribute<Book, Integer> numOfPages;
    public static volatile SingularAttribute<Book, BigDecimal> salePrice;
    public static volatile SingularAttribute<Book, String> isbn;
    public static volatile SingularAttribute<Book, String> description;
    public static volatile SingularAttribute<Book, BookFormat> bookFormat;
    public static volatile SingularAttribute<Book, String> title;
    public static volatile SingularAttribute<Book, Date> dateOfPublication;
    public static volatile ListAttribute<Book, Clients> clientsCollection;
    public static volatile SingularAttribute<Book, Date> dateEntered;
    public static volatile SingularAttribute<Book, Integer> publisherID;
    public static volatile SingularAttribute<Book, Boolean> isRemoved;
    public static volatile ListAttribute<Book, CustomerReviews> reviews;
    public static volatile SingularAttribute<Book, String> genre;
    public static volatile ListAttribute<Book, Authors> authorsCollection;
    public static volatile ListAttribute<Book, OrderItem> orders;
    public static volatile SingularAttribute<Book, Date> lastModified;
    public static volatile SingularAttribute<Book, BigDecimal> wholesalePrice;
    public static volatile SingularAttribute<Book, BigDecimal> listPrice;

}