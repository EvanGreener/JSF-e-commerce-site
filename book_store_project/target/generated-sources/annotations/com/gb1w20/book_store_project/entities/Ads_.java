package com.gb1w20.book_store_project.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.1.v20171221-rNA", date="2020-03-10T23:00:12")
@StaticMetamodel(Ads.class)
public class Ads_ { 

    public static volatile SingularAttribute<Ads, Integer> adID;
    public static volatile SingularAttribute<Ads, String> imageName;
    public static volatile SingularAttribute<Ads, Date> dateCreated;
    public static volatile SingularAttribute<Ads, Boolean> isRemoved;
    public static volatile SingularAttribute<Ads, String> adUrl;
    public static volatile SingularAttribute<Ads, Date> lastModified;

}