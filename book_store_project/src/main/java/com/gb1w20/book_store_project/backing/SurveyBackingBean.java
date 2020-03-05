package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.entities.Surveys;
import com.gb1w20.book_store_project.jpa_controllers.SurveysJpaController;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("surveyBacking")
@RequestScoped
public class SurveyBackingBean implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(SurveyBackingBean.class);

    @Inject
    private SurveysJpaController surveysJpaController;

    private Surveys survey;

    /**
     * Survey created if it does not exist.
     *
     * @return
     */
    public Surveys getSurvey() {
        if (survey == null) {
            survey = new Surveys();
        }
        return survey;
    }

    /**
     * Save the current survey to the db
     *
     * @return
     * @throws Exception
     */
    public String createSurvey() throws Exception {
        surveysJpaController.create(survey);
        return null;
    }
}
