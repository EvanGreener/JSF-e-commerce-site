package com.gb1w20.book_store_project.entities;

import com.gb1w20.book_store_project.entities.SurveyData;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.6.v20200131-rNA", date="2020-03-13T17:44:34")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-03-14T16:59:55", comments="EclipseLink-2.7.5.v20191016-rNA")
>>>>>>> 8d316432bd144393d7fe4b6b5e15ea2cd8b0e60e
@StaticMetamodel(Surveys.class)
public class Surveys_ { 

    public static volatile SingularAttribute<Surveys, Integer> surveyID;
    public static volatile SingularAttribute<Surveys, String> surveyDescription;
    public static volatile SingularAttribute<Surveys, Date> dateCreated;
    public static volatile SingularAttribute<Surveys, Boolean> isRemoved;
    public static volatile SingularAttribute<Surveys, String> surveyName;
    public static volatile ListAttribute<Surveys, SurveyData> surveyData;
    public static volatile SingularAttribute<Surveys, Date> lastModified;

}