package com.gb1w20.book_store_project.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.6.v20200131-rNA", date="2020-02-25T16:49:37")
@StaticMetamodel(Authors.class)
public class Authors_ { 

    public static volatile SingularAttribute<Authors, Date> dateEntered;
    public static volatile SingularAttribute<Authors, Boolean> isRemoved;
    public static volatile SingularAttribute<Authors, String> name;
    public static volatile SingularAttribute<Authors, Date> lastModified;
    public static volatile SingularAttribute<Authors, Integer> authorID;

}