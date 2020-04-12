/*
 * This package stores all beans used to access controller classses
 */
package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.SurveyData;
import com.gb1w20.book_store_project.entities.Surveys;
import com.gb1w20.book_store_project.jpa_controllers.SurveysJpaController;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Gets information for individual surveys used in client front door
 *
 * @author Shruti Pareek
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
    /**
     * method for initializing when bean called
     *
     * @author Shruti Pareek
     * @return void
     */
    public void init() {
        LOG.debug("Init called!");

    }

    /**
     *
     * Gets the id of the first question in the survey used to set the default
     * choice for radio buttons in index page
     *
     * @author Shruti Pareek
     * @return Integer
     */
    public Integer getSurveyChoice() {
        LOG.debug("getSurveyChoice");
        this.survey = getSurvey();
        for (SurveyData s : this.survey.getSurveyData()) {
            this.surveyChoice = s.getDataID();
            break;
        }

        return this.surveyChoice;
    }

    /**
     * Sets the id of the question that has been selected by user
     *
     * @author Shruti Pareek
     * @param choice
     */
    public void setSurveyChoice(Integer choice) {
        LOG.debug("setSurveyChoice");
        this.surveyChoice = choice;
    }

    /**
     * Sets the survey to a randomly generated one
     *
     * @author Shruti Pareek
     */
    public void setSurvey() {
        LOG.debug("setSurvey");
        survey = surveyCtrlr.getActiveSurvey();
    }

    /**
     * Retrieves survey
     *
     * @author Shruti Pareek
     * @return Surveys
     */
    public Surveys getSurvey() {
        LOG.debug("getSurvey");
        return survey;
    }

}
