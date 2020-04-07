/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.Ads;
import com.gb1w20.book_store_project.entities.SurveyData;
import com.gb1w20.book_store_project.entities.Surveys;
import com.gb1w20.book_store_project.jpa_controllers.AdsJpaController;
import com.gb1w20.book_store_project.jpa_controllers.SurveyDataJpaController;
import com.gb1w20.book_store_project.jpa_controllers.SurveysJpaController;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
    @Inject
    private SurveyDataJpaController surveyItemCtrl;

    private final static Logger LOG = LoggerFactory.getLogger(EditSurveyBean.class);
    private Surveys currentSurvey;
    private List<SurveyData> currentSurveyItems;

    private SurveyData surveyDataItem1;
    private SurveyData surveyDataItem2;
    private SurveyData surveyDataItem3;
    private SurveyData surveyDataItem4;
    private SurveyData surveyDataItem5;

    private String newSurveyName;
    private String newSurveyDescription;
    private String newSurveyItem1;
    private String newSurveyItem2;
    private String newSurveyItem3;
    private String newSurveyItem4;
    private String newSurveyItem5;

    @PostConstruct
    public void init() {
        LOG.debug("init called");
    }

    public Surveys getCurrentSurvey() {
        return currentSurvey;
    }

    public String getNewSurveyName() {
        return newSurveyName;
    }

    public void setNewSurveyName(String newValue) {
        newSurveyName = newValue;
    }

    public String getNewSurveyDescription() {
        return newSurveyDescription;
    }

    public void setNewSurveyDescription(String newValue) {
        newSurveyDescription = newValue;
    }

    public String getNewSurveyItem1() {
        LOG.debug("called get     "+ newSurveyItem1);
        return newSurveyItem1;
    }

    public void setNewSurveyItem1(String newSurveyItem1) {
        this.newSurveyItem1 = newSurveyItem1;
    }

    public String getNewSurveyItem2() {
        return newSurveyItem2;
    }

    public void setNewSurveyItem2(String newSurveyItem2) {
        this.newSurveyItem2 = newSurveyItem2;
    }

    public String getNewSurveyItem3() {
        return newSurveyItem3;
    }

    public void setNewSurveyItem3(String newSurveyItem3) {
        this.newSurveyItem3 = newSurveyItem3;
    }

    public String getNewSurveyItem4() {
        return newSurveyItem4;
    }

    public void setNewSurveyItem4(String newSurveyItem4) {
        this.newSurveyItem4 = newSurveyItem4;
    }

    public String getNewSurveyItem5() {
        return newSurveyItem5;
    }

    public void setNewSurveyItem5(String newSurveyItem5) {
        this.newSurveyItem5 = newSurveyItem5;
    }

    public List<SurveyData> getCurrentSurveyItems() {
        return currentSurveyItems;
    }

    public void setCurrentSurveyItems(List<SurveyData> currentSurveyItems) {
        this.currentSurveyItems = currentSurveyItems;
    }

    public void onEdit(int id) {
        LOG.debug("onEdit called");
        LOG.debug("ID we are looking for: " + id);
        currentSurvey = surveyCtrl.findSurveys(id);
        newSurveyName = currentSurvey.getSurveyName();
        newSurveyDescription = currentSurvey.getSurveyDescription();
        currentSurveyItems = surveyItemCtrl.getSurveyChoices(currentSurvey.getSurveyID());

        LOG.debug("survey items size " + currentSurveyItems.size());
        newSurveyItem1 = currentSurveyItems.size() > 0 ? currentSurveyItems.get(0).getChoice() : "";
        newSurveyItem2 = currentSurveyItems.size() > 1 ? currentSurveyItems.get(1).getChoice() : "";
        newSurveyItem3 = currentSurveyItems.size() > 2 ? currentSurveyItems.get(2).getChoice() : "";
        newSurveyItem4 = currentSurveyItems.size() > 3 ? currentSurveyItems.get(3).getChoice() : "";
        newSurveyItem5 = currentSurveyItems.size() > 4 ? currentSurveyItems.get(4).getChoice() : "";

        LOG.debug("Current ID: " + currentSurvey.getSurveyID());
        LOG.debug("Current image: " + currentSurvey.getSurveyName());
        LOG.debug("Current URL: " + currentSurvey.getSurveyDescription());
        LOG.debug("Current image (var): " + newSurveyName);
        LOG.debug("Current URL (var): " + newSurveyDescription);
    }

    public String onSubmitEdit() throws Exception {
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
