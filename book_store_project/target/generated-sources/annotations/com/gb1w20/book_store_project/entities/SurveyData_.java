package com.gb1w20.book_store_project.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.6.v20200131-rNA", date="2020-03-05T14:31:20")
@StaticMetamodel(SurveyData.class)
public class SurveyData_ { 

    public static volatile SingularAttribute<SurveyData, Integer> surveyID;
    public static volatile SingularAttribute<SurveyData, Date> dateCreated;
    public static volatile SingularAttribute<SurveyData, Boolean> isRemoved;
    public static volatile SingularAttribute<SurveyData, Integer> dataID;
    public static volatile SingularAttribute<SurveyData, Integer> votes;
    public static volatile SingularAttribute<SurveyData, Date> lastModified;
    public static volatile SingularAttribute<SurveyData, String> choice;

}