package com.gb1w20.book_store_project.entities;

import com.gb1w20.book_store_project.entities.Surveys;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.6.v20200131-rNA", date="2020-03-13T17:44:34")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-03-14T16:59:55", comments="EclipseLink-2.7.5.v20191016-rNA")
>>>>>>> 8d316432bd144393d7fe4b6b5e15ea2cd8b0e60e
@StaticMetamodel(SurveyData.class)
public class SurveyData_ { 

    public static volatile SingularAttribute<SurveyData, Integer> surveyID;
    public static volatile SingularAttribute<SurveyData, Date> dateCreated;
    public static volatile SingularAttribute<SurveyData, Boolean> isRemoved;
    public static volatile SingularAttribute<SurveyData, Integer> dataID;
    public static volatile SingularAttribute<SurveyData, Surveys> survey;
    public static volatile SingularAttribute<SurveyData, Integer> votes;
    public static volatile SingularAttribute<SurveyData, Date> lastModified;
    public static volatile SingularAttribute<SurveyData, String> choice;

}