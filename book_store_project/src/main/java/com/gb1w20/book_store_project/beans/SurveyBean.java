/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.SurveyData;
import com.gb1w20.book_store_project.entities.Surveys;
import com.gb1w20.book_store_project.jpa_controllers.BookJpaController;
import com.gb1w20.book_store_project.jpa_controllers.SurveyDataJpaController;
import com.gb1w20.book_store_project.jpa_controllers.SurveysJpaController;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author 06spa
 */
@Named("ss")
@SessionScoped
public class SurveyBean implements Serializable {
     @Inject
    private SurveysJpaController surveyCtrlr;
     
     
     private List<Surveys> survey;
     private List<Integer> votes;
     
    private final static Logger LOG = LoggerFactory.getLogger(SurveyBean.class);
    
    
    @PostConstruct
    public void init() {
        LOG.debug("Init called!");

    }
    
    public List<Surveys> getSurvey(){
        survey=surveyCtrlr.getfirstSurvey();
        return survey;
    }
    
     public List<Integer> getVotes(int id){
        votes= surveyCtrlr.getTotalVotes(id);
        return votes;
    }
}
