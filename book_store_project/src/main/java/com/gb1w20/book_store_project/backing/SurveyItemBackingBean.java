/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.entities.SurveyData;
import com.gb1w20.book_store_project.jpa_controllers.SurveyDataJpaController;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Saad
 */
@Named("surveyItemBacking")
@RequestScoped
public class SurveyItemBackingBean implements Serializable {

     private final static Logger LOG = LoggerFactory.getLogger(SurveyItemBackingBean.class);

    @Inject
    private SurveyDataJpaController surveyItemJpaController;

    private SurveyData surveyItem;

    /**
     * OrderItems created if it does not exist.
     *
     * @return
     */
    public SurveyData getSurveyItem() {
        if (surveyItem == null) {
            surveyItem = new SurveyData();
        }
        return surveyItem;
    }

    /**
     * Save the current orderItem to the db
     *
     * @return
     * @throws Exception
     */
    public String createSurveyItem() throws Exception {
        surveyItemJpaController.create(surveyItem);
        return null;
    }

    public String getRemovalStatus(boolean isRemoved) throws Exception {
        if (isRemoved) {
            return "Add Item";
        } else {
            return "Remove Item";
        }
    }

    public String removeItem(SurveyData item) throws Exception {
        item.setIsRemoved(true);
        item.setLastModified(new Date());
        surveyItemJpaController.edit(item);
        return null;
    }

    public String addItem(SurveyData item) throws Exception {
        item.setIsRemoved(false);
        item.setLastModified(new Date());
        surveyItemJpaController.edit(item);
        return null;
    }

    public String addOrRemoveItem(SurveyData item) throws Exception {
        if (item.getIsRemoved()) {
            addItem(item);
        } else {
            removeItem(item);
        }
        FacesContext.getCurrentInstance().getExternalContext().redirect("managerSurveys.xhtml");
        return null;
    }
 

    
}
