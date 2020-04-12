package com.gb1w20.book_store_project.entities;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-04-12T18:39:08", comments="EclipseLink-2.7.6.v20200131-rNA")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-04-12T19:18:42", comments="EclipseLink-2.7.6.v20200131-rNA")
>>>>>>> abb303246aa7c2ebad76bed714efe8bee5117810
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