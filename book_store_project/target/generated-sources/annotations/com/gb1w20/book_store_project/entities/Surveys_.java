package com.gb1w20.book_store_project.entities;

import com.gb1w20.book_store_project.entities.SurveyData;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.1.v20171221-rNA", date="2020-03-23T20:30:44")
=======
@Generated(value="EclipseLink-2.7.6.v20200131-rNA", date="2020-03-22T13:20:43")
>>>>>>> 696713a0c5f5cdfa7556dc092b4fa3836edbb6ee
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