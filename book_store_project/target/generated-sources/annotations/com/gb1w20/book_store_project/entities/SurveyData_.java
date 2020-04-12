package com.gb1w20.book_store_project.entities;

import com.gb1w20.book_store_project.entities.Surveys;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-04-12T17:50:07", comments="EclipseLink-2.7.6.v20200131-rNA")
=======
<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-04-12T15:45:54", comments="EclipseLink-2.7.6.v20200131-rNA")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-04-12T17:25:03", comments="EclipseLink-2.7.6.v20200131-rNA")
>>>>>>> 1b1f2db6be9f9dfefe62c6980aec5c1724ed60d0
>>>>>>> 83090cb9d8f2aed7d95fcbc73964f9fe8992adb2
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