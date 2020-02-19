package com.gb1w20.book_store_project.entities;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-02-18T22:09:30", comments="EclipseLink-2.7.6.v20200131-rNA")
@StaticMetamodel(Surveys.class)
public class Surveys_ { 

    public static volatile SingularAttribute<Surveys, Integer> surveyID;
    public static volatile SingularAttribute<Surveys, String> surveyDescription;
    public static volatile SingularAttribute<Surveys, Date> dateCreated;
    public static volatile SingularAttribute<Surveys, Boolean> isRemoved;
    public static volatile SingularAttribute<Surveys, Date> lastModified;
    public static volatile SingularAttribute<Surveys, String> surveryName;

}