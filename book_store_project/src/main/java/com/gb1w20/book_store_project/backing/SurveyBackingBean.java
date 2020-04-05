package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.entities.Surveys;
import com.gb1w20.book_store_project.jpa_controllers.SurveysJpaController;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
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
     * Save the current ad to the db
     *
     * @return
     * @throws Exception
     */
    public String createSurvey() throws Exception {
        LOG.debug("createAd called");
        LOG.debug(survey == null ? "Survey is null" : "Survey is not null");
        if (survey != null && !survey.getSurveyDescription().isBlank() && !survey.getSurveyDescription().isEmpty()) {
            survey.setLastModified(new Date());
            survey.setDateCreated(new Date());
            survey.setIsRemoved(true);
            surveysJpaController.create(survey);
        }
        FacesContext.getCurrentInstance().getExternalContext().redirect("managerSurveys.xhtml");
        return "managerSurveys.xhtml";
    }

    public String removeSurvey(Surveys survey) throws Exception {
        LOG.debug("Reached the remove method");
        survey.setIsRemoved(true);
        LOG.debug("Reached the setRemoved method");
        survey.setLastModified(new Date());
        LOG.debug("Reached the setModified method");
        surveysJpaController.edit(survey);
        LOG.debug("Reached the edit method");
        return null;
    }

    public String addSurvey(Surveys survey) throws Exception {
        LOG.debug("Reached the add method");
        survey.setIsRemoved(false);
        LOG.debug("Reached the setRemoved method");
        survey.setLastModified(new Date());
        LOG.debug("Reached the lastModified method");
        surveysJpaController.edit(survey);
        LOG.debug("Reached the edit method");
        return null;
    }

    public void validateNotNull(FacesContext context, UIComponent component, Object value) {
        String input = (String) value;
        if (input.isBlank() || input.isEmpty() || input == null) {
            String message = context.getApplication().evaluateExpressionGet(context, "Value must not be left blank", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
    }

    public String addOrRemoveSurvey(Surveys survey) throws Exception {
        if (survey.getIsRemoved()) {
            addSurvey(survey);
        } else {
            removeSurvey(survey);
        }
        FacesContext.getCurrentInstance().getExternalContext().redirect("managerSurveys.xhtml");
        return null;
    }

    public String getRemovalStatus(boolean isRemoved) throws Exception {
        if (isRemoved) {
            return "Disabled Survey";
        } else {
            return "Active Survey";
        }
    }
    
        public void onCreate(){
        LOG.debug("onCreate called!");
    }
}
