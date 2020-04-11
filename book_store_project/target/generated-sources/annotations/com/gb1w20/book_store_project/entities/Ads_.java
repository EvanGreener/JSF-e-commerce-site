package com.gb1w20.book_store_project.entities;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-04-10T22:40:09", comments="EclipseLink-2.7.6.v20200131-rNA")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-04-10T12:13:33", comments="EclipseLink-2.7.6.v20200131-rNA")
>>>>>>> e45bae9a3fba5abe97e954fa25e80e25aedb842b
@StaticMetamodel(Ads.class)
public class Ads_ { 

    public static volatile SingularAttribute<Ads, Integer> adID;
    public static volatile SingularAttribute<Ads, String> imageName;
    public static volatile SingularAttribute<Ads, Date> dateCreated;
    public static volatile SingularAttribute<Ads, Boolean> isRemoved;
    public static volatile SingularAttribute<Ads, String> adUrl;
    public static volatile SingularAttribute<Ads, Date> lastModified;

}