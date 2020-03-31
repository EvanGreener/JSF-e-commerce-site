/*
 * This package stores all beans used to access controller classses
 */
package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.SurveyData;
import com.gb1w20.book_store_project.jpa_controllers.SurveyDataJpaController;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("surveyDataBean")
@RequestScoped
/**
 * bean used to get survey results
 *
 * @author Shruti Pareek
 */
public class SurveyDataBean implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(SurveyDataBean.class);

    @Inject
    private SurveyDataJpaController surveyDatasJpaController;

    private SurveyData surveyData;
    private Integer surveyDataChoice;
    private List<SurveyData> surveyChoices;

    @PostConstruct
    /**
     * method that initialize when bean first called
     *
     * @return
     */
    public void init() {
        LOG.debug("Init called!");

    }

    /**
     * SurveyData created if it does not exist.
     *
     * @param dataId
     * @return
     */
    public SurveyData getSurveyData(Integer dataId) {
        if (surveyData == null) {
            surveyData = new SurveyData();
        }
        surveyData = surveyDatasJpaController.findSurveyData(dataId);

        return surveyData;
    }

    /**
     * Save the current surveyData to the db
     *
     * @return
     * @throws Exception
     */
    public String createSurveyData() throws Exception {
        surveyDatasJpaController.create(surveyData);
        return null;
    }

    

    /**
     * store user choice for survey in database
     *
     * @param surveyId
     */
    public void setSurveyChoices(Integer surveyId) {
        LOG.debug("setSurveyChoices");
        this.surveyChoices = surveyDatasJpaController.getSurveyChoices(surveyId);
    }

    /**
     * get the all survey options from a survey id
     *
     * @param surveyId
     * @return list
     */
    public List<SurveyData> getSurveyChoices(Integer surveyId) {
        LOG.debug("getSurveyChoices");
        this.surveyChoices = surveyDatasJpaController.getSurveyChoices(surveyId);
        return this.surveyChoices;
    }

    /**
     * get the survey choice selected
     *
     * @return integer
     */
    public Integer getSurveyDataChoice() {
        LOG.debug("getSurveyDataChoice");
        //sets default to the very first choice of survey
        for (SurveyData sd : this.surveyChoices) {
            this.surveyDataChoice = sd.getDataID();
            break;
        }
        return this.surveyDataChoice;
    }

    /**
     * set the choice selected bu user for survey
     *
     * @param dataId
     * @throws java.lang.Exception
     */
    public void setSurveyDataChoice(Integer dataId) throws Exception {
        LOG.debug("setSurveyDataChoice");
        this.surveyDataChoice = dataId;
        getSurveyData(dataId);
        this.surveyData.setVotes(this.surveyData.getVotes() + 1);
        this.surveyDatasJpaController.edit(surveyData);

    }

}
