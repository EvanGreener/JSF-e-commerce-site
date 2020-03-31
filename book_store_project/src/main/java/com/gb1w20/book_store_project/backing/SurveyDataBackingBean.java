/*
 * This package stores all beans used to access controller classses
 */
package com.gb1w20.book_store_project.backing;

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

@Named("surveyDataBacking")
@RequestScoped
/**
 * bean used to get survey results
 *
 * @author Shruti Pareek
 */
public class SurveyDataBackingBean implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(SurveyDataBackingBean.class);

    @Inject
    private SurveyDataJpaController surveyDatasJpaController;

    private SurveyData surveyData;
    private Integer surveyDataChoice;
    private List<SurveyData> surveyChoices;
    private BarChartModel barChart;

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
     * create bar chart based on survey results
     *
     * @param surveyId
     */
    public void createBarChart(Integer surveyId) {
        LOG.debug("createBarChart");
        ChartSeries rigs = new ChartSeries();

        Map<Object, Number> rigMap = new HashMap<>();
        setSurveyChoices(surveyId);

        for (SurveyData sd : this.surveyChoices) {
            rigMap.put(sd.getChoice().substring(0, Math.min(sd.getChoice().length(), 15 - this.surveyChoices.size())), sd.getVotes());

            barChart = new BarChartModel();
            rigs.setData(rigMap);
            barChart.addSeries(rigs);
        }

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
     * create barchart for index page
     *
     * @param surveyId
     * @return chart
     */
    public BarChartModel getBarChart(Integer surveyId) {
        LOG.debug("getBarChart");
        createBarChart(surveyId);
        return barChart;
    }

    /**
     * set the bar chart results
     *
     * @param surveyId
     */
    public void setBarChart(Integer surveyId) {
        LOG.debug("setBarChart");
        createBarChart(surveyId);
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
