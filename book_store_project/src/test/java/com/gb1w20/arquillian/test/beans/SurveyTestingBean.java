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
    
    public SurveyTestingBean(int surveyID, int expectedChoices)
    {
        this.surveyID = surveyID;
        this.expectedChoices = expectedChoices;
    }
}
