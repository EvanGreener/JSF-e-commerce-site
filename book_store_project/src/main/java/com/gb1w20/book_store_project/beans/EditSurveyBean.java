/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.Ads;
import com.gb1w20.book_store_project.entities.Surveys;
import com.gb1w20.book_store_project.jpa_controllers.AdsJpaController;
import com.gb1w20.book_store_project.jpa_controllers.SurveysJpaController;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author giancarlo
 */

@Named("editSurvey")
@SessionScoped
public class EditSurveyBean implements Serializable {
    
    @Inject
    private SurveysJpaController surveyCtrl;
    
    private final static Logger LOG = LoggerFactory.getLogger(EditSurveyBean.class);
    private Surveys currentSurvey;
    private String newSurveyName;
    private String newSurveyDescription;
    
    @PostConstruct
    public void init()
    {
        LOG.debug("init called");
    }
    
    public Surveys getCurrentSurvey()
    {
        return currentSurvey;
    }
    
    public String getNewSurveyName()
    {
        return newSurveyName;
    }
    
    public void setNewSurveyName(String newValue)
    {
        newSurveyName = newValue;
    }
    
    public String getNewSurveyDescription()
    {
        return newSurveyDescription;
    }
    
    public void setNewSurveyDescription(String newValue)
    {
        newSurveyDescription = newValue;
    }

    
    public void onEdit(int id)
    {
        LOG.debug("onEdit called");
        LOG.debug("ID we are looking for: " + id);
        currentSurvey = surveyCtrl.findSurveys(id); //adsCtrl.findAds(id);
        newSurveyName = currentSurvey.getSurveyName();
        newSurveyDescription = currentSurvey.getSurveyDescription();
        LOG.debug("Current ID: " + currentSurvey.getSurveyID());
        LOG.debug("Current image: " + currentSurvey.getSurveyName());
        LOG.debug("Current URL: " + currentSurvey.getSurveyDescription());
        LOG.debug("Current image (var): " + newSurveyName);
        LOG.debug("Current URL (var): " + newSurveyDescription);
    }
    
    public String onSubmitEdit() throws Exception
    {
        LOG.debug("onSubmitEdit called");
        currentSurvey.setSurveyName(newSurveyName);
        currentSurvey.setSurveyDescription(newSurveyDescription);
        currentSurvey.setLastModified(new Date());
        currentSurvey.setDateCreated(new Date());
        surveyCtrl.edit(currentSurvey);
        FacesContext.getCurrentInstance().getExternalContext().redirect("managerSurveys.xhtml");
        return null;
    } 
}
