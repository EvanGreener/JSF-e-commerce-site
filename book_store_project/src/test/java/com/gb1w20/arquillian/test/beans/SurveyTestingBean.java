/*
 *All test beans belong to this package
 */
package com.gb1w20.arquillian.test.beans;

/**
 * Bean used for the survey parameterized test
 * @author Giancarlo Biasiucci
 * @version April 11, 2020
 */
public class SurveyTestingBean {


    public int surveyID;
    public int expectedChoices;
    public int expectedVotes;
    public String expectedStatus;
    public boolean isActive;
    
    /**
     * Constructor takes all necessary input needed for testing
     * @param surveyID
     * @param expectedChoices
     * @param expectedVotes
     * @param expectedStatus
     * @param isActive 
     */
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
