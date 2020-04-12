package com.gb1w20.book_store_project.entities;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-04-12T13:07:43", comments="EclipseLink-2.7.6.v20200131-rNA")
@StaticMetamodel(Ads.class)
public class Ads_ { 

    public static volatile SingularAttribute<Ads, Integer> adID;
    public static volatile SingularAttribute<Ads, String> imageName;
    public static volatile SingularAttribute<Ads, Date> dateCreated;
    public static volatile SingularAttribute<Ads, Boolean> isRemoved;
    public static volatile SingularAttribute<Ads, String> adUrl;
    public static volatile SingularAttribute<Ads, Date> lastModified;

}