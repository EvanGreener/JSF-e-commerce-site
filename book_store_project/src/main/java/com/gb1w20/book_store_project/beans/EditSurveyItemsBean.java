/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.SurveyData;
import com.gb1w20.book_store_project.jpa_controllers.SurveyDataJpaController;
import com.gb1w20.book_store_project.jpa_controllers.SurveysJpaController;
import java.beans.*;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Saad
 */
@Named("editSurveyItem")
@SessionScoped
public class EditSurveyItemsBean implements Serializable {
    
    private final static Logger LOG = LoggerFactory.getLogger(EditSurveyItemsBean.class);

    @Inject
    private SurveysJpaController surveyCtrl;
  
    @Inject
    private SurveyDataJpaController surveyItemCtrl;
   
    private SurveyData currentSurveyItem;
    
    
    
}
