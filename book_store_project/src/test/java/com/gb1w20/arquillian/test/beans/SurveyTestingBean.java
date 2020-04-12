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
    
    /**
     *
     * @param surveyID
     * @param expectedChoices
     * @param expectedVotes
     */
    public SurveyTestingBean(int surveyID, int expectedChoices, int expectedVotes)
    {
        this.surveyID = surveyID;
        this.expectedChoices = expectedChoices;
        this.expectedVotes = expectedVotes;
    }
}
