/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.arquillian.test.beans;

import java.util.List;

/**
 *
 * @author Evan Greenstein
 */
public class SurveyDataTestingBean {
     public int surveyID;
     public List<Object> expectedVotesPerChoice;

     public SurveyDataTestingBean(int surveyID, List<Object> expectedVotesPerChoice) {
          this.surveyID = surveyID;
          this.expectedVotesPerChoice = expectedVotesPerChoice;
     }

     
     
}
