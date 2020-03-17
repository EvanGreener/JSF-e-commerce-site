package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.entities.SurveyData;
import com.gb1w20.book_store_project.entities.Surveys;
import com.gb1w20.book_store_project.jpa_controllers.SurveyDataJpaController;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
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

    /**
     * SurveyData created if it does not exist.
     *
     * @return
     */
    public SurveyData getSurveyData(Integer choice) {
        if (surveyData == null) {
            surveyData = new SurveyData();
        }
        surveyData=surveyDatasJpaController.findSurveyData(choice);
        
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

  

    public Integer getSurveyDataChoice() {
        LOG.debug("getSurveyChoice");
       
                List<SurveyData> data=this.surveyDatasJpaController.getFirstChoice();
        
         for (SurveyData o : data) {
                this.surveyDataChoice=  o.getDataID();
                break;
        }
        return this.surveyDataChoice;
    }

    public void setSurveyDataChoice(Integer choice) throws Exception {
        LOG.debug("setSurveyChoice");
        this.surveyDataChoice = choice;
        getSurveyData(choice);
        this.surveyData.setVotes(this.surveyData.getVotes()+1);
        this.surveyDatasJpaController.edit(surveyData);

    }

}
