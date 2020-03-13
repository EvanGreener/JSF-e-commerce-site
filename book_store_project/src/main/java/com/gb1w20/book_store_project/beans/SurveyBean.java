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

    private List<Surveys> survey;
    private int count = 0;
    private BarChartModel cartChart;
    private String surveyChoice;
private String hello;
    private final static Logger LOG = LoggerFactory.getLogger(SurveyBean.class);

    @PostConstruct
    public void init() {
        LOG.debug("Init called!");

        List<Surveys> rList = getSurvey();

        for (Surveys o : rList) {

            List<SurveyData> d = o.getSurveyData();

            for (SurveyData b : d) {
                surveyChoice = b.getDataID() + "";
                break;
            }
            break;

        }
    }
    public String getHello(){
        LOG.debug("jklkljl");
        hello="gallery.xhtml";
        return hello;
    }
    public void setHello(){
             LOG.debug("jklklhjjkhkjhkjhkjhkjhkjhkjhkjhkjhjkhkjl");
        hello="s";
    }
    public String getSurveyChoice() {
        return this.surveyChoice;
    }

    public void setSurveyChoice(String choice) {
        this.surveyChoice = choice;
    }

    public List<Surveys> getSurvey() {
        survey = surveyCtrlr.getfirstSurvey();
        return survey;
    }

    public void createRigTestModel() {
        LOG.debug("createRigTestModel");
        ChartSeries rigs = new ChartSeries();

        List<Surveys> rList = getSurvey();
        Map<Object, Number> rigMap = new HashMap<>();
        for (Surveys o : rList) {

            List<SurveyData> d = o.getSurveyData();

            for (SurveyData b : d) {
                rigMap.put(b.getChoice().substring(0, Math.min(b.getChoice().length(), 15)), b.getVotes());

                cartChart = new BarChartModel();
                rigs.setData(rigMap);
                cartChart.addSeries(rigs);
            }

        }

    }

    public BarChartModel getCartChart() {
        LOG.debug("reached");
        createRigTestModel();
        return cartChart;
    }

    public int getCount() {
        count = 0;
        List<Surveys> rList = getSurvey();

        for (Surveys o : rList) {

            List<SurveyData> d = o.getSurveyData();

            for (SurveyData b : d) {

                count += b.getVotes();
            }
            return count;

        }
        return 0;

    }
}
