package com.gb1w20.book_store_project.entities;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-04-10T22:40:09", comments="EclipseLink-2.7.6.v20200131-rNA")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-04-10T12:13:32", comments="EclipseLink-2.7.6.v20200131-rNA")
>>>>>>> e45bae9a3fba5abe97e954fa25e80e25aedb842b
@StaticMetamodel(Publisher.class)
public class Publisher_ { 

    public static volatile SingularAttribute<Publisher, String> country;
    public static volatile SingularAttribute<Publisher, Integer> publisherID;
    public static volatile SingularAttribute<Publisher, String> address;
    public static volatile SingularAttribute<Publisher, String> phoneNumber;
    public static volatile SingularAttribute<Publisher, Date> dateCreated;
    public static volatile SingularAttribute<Publisher, Boolean> isRemoved;
    public static volatile SingularAttribute<Publisher, String> city;
    public static volatile SingularAttribute<Publisher, String> contactName;
    public static volatile SingularAttribute<Publisher, String> postalCode;
    public static volatile SingularAttribute<Publisher, String> name;
    public static volatile SingularAttribute<Publisher, Date> lastModified;

}