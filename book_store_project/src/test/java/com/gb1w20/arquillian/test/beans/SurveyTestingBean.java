/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.arquillian.test.beans;

import java.util.List;

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
