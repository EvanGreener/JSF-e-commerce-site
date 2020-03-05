package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.entities.SurveyData;
import com.gb1w20.book_store_project.jpa_controllers.SurveyDataJpaController;
import java.io.Serializable;
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

    /**
     * SurveyData created if it does not exist.
     *
     * @return
     */
    public SurveyData getSurveyData() {
        if (surveyData == null) {
            surveyData = new SurveyData();
        }
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
}
