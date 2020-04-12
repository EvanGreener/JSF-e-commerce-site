/*
 *All test beans belong to this package
 */
package com.gb1w20.arquillian.test.beans;

/**
 *
 * @author giancarlo
 */
public class SurveyTestingBean {


    public int surveyID;
    public int expectedChoices;
    public int expectedVotes;
    public String expectedStatus;
    public boolean isActive;
    
    public SurveyTestingBean(int surveyID, int expectedChoices, int expectedVotes,String expectedStatus,
            boolean isActive)
    {
        this.surveyID = surveyID;
        this.expectedChoices = expectedChoices;
        this.expectedVotes = expectedVotes;
        this.expectedStatus = expectedStatus;
        this.isActive = isActive;
    }
}
