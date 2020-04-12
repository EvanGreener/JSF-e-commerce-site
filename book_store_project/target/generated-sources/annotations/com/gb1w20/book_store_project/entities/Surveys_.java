package com.gb1w20.book_store_project.entities;

import com.gb1w20.book_store_project.entities.SurveyData;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
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