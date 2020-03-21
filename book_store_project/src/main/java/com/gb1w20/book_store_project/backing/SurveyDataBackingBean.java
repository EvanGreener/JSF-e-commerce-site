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
public class SurveyDataBackingBean implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(SurveyDataBackingBean.class);

    @Inject
    private SurveyDataJpaController surveyDatasJpaController;

    private SurveyData surveyData;
    private Integer surveyDataChoice;
    private List<SurveyData> surveyChoices;
    private BarChartModel barChart;

    /**
     * SurveyData created if it does not exist.
     *
     * @return
     */
    public SurveyData getSurveyData(Integer dataId) {
        if (surveyData == null) {
            surveyData = new SurveyData();
        }
        surveyData = surveyDatasJpaController.findSurveyData(dataId);

        return surveyData;
    }

    
        @PostConstruct
    public void init() {
        LOG.debug("Init called!");
      
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

    public void createBarChart(Integer surveyId) {
        LOG.debug("createBarChart");
        ChartSeries rigs = new ChartSeries();

        Map<Object, Number> rigMap = new HashMap<>();
        setSurveyChoices(surveyId);

        for (SurveyData sd : this.surveyChoices) {
            rigMap.put(sd.getChoice().substring(0, Math.min(sd.getChoice().length(), 15-this.surveyChoices.size())), sd.getVotes());

            barChart = new BarChartModel();
            rigs.setData(rigMap);
            barChart.addSeries(rigs);
        }

    }

    public void setSurveyChoices(Integer surveyId) {
          LOG.debug("setSurveyChoices");
        this.surveyChoices = surveyDatasJpaController.getSurveyChoices(surveyId);
    }
    public List<SurveyData> getSurveyChoices(Integer surveyId){
          LOG.debug("getSurveyChoices");
          this.surveyChoices = surveyDatasJpaController.getSurveyChoices(surveyId);
        return this.surveyChoices;
    }
    public BarChartModel getBarChart(Integer surveyId) {
        LOG.debug("getBarChart");
        createBarChart(surveyId);
        return barChart;
    }
    public void setBarChart(Integer surveyId){
        LOG.debug("setBarChart");
        createBarChart(surveyId);
    }
    public Integer getSurveyDataChoice() {
        LOG.debug("getSurveyDataChoice");
        //sets default to the very first choice of survey
        for (SurveyData sd : this.surveyChoices) {
            this.surveyDataChoice = sd.getDataID();
            break;
        }
        return this.surveyDataChoice;
    }

    public void setSurveyDataChoice(Integer dataId) throws Exception {
        LOG.debug("setSurveyDataChoice");
        this.surveyDataChoice = dataId;
        getSurveyData(dataId);
        this.surveyData.setVotes(this.surveyData.getVotes() + 1);
        this.surveyDatasJpaController.edit(surveyData);

    }

}
