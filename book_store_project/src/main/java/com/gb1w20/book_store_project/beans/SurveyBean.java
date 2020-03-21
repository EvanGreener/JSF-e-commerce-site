/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.entities.SurveyData;
import com.gb1w20.book_store_project.entities.Surveys;
import com.gb1w20.book_store_project.jpa_controllers.BookJpaController;
import com.gb1w20.book_store_project.jpa_controllers.SurveyDataJpaController;
import com.gb1w20.book_store_project.jpa_controllers.SurveysJpaController;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.component.chart.Chart;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
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

    private Surveys survey;
    private Integer surveyChoice;
    
    private final static Logger LOG = LoggerFactory.getLogger(SurveyBean.class);

    @PostConstruct
    public void init() {
        LOG.debug("Init called!");
      
    }

    public Integer getSurveyChoice() {
          LOG.debug("getSurveyChoice");
        this.survey=getSurvey();
        for(SurveyData s:this.survey.getSurveyData()){
            this.surveyChoice=s.getDataID();
            break;
        }
        
        return this.surveyChoice;
    }

    public void setSurveyChoice(Integer choice) {
            LOG.debug("setSurveyChoice");
        this.surveyChoice = choice;
    }
    public void setSurvey(){
          LOG.debug("setSurvey");
          survey = surveyCtrlr.getRandomSurvey();
    }
    public Surveys getSurvey() {
         LOG.debug("getSurvey");
        return survey;
    }

    
    
    
    
  

}
