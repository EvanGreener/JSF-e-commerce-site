package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.entities.SurveyData;
import com.gb1w20.book_store_project.entities.Surveys;
import com.gb1w20.book_store_project.jpa_controllers.SurveyDataJpaController;
import com.gb1w20.book_store_project.jpa_controllers.SurveysJpaController;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("surveyBacking")
@SessionScoped
public class SurveyBackingBean implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(SurveyBackingBean.class);

    @Inject
    private SurveysJpaController surveysJpaController;
    
    @Inject
    private SurveyDataJpaController surveyDataJpaController;

    private Surveys survey;
    
    private SurveyData surveyDataItem1;
    private SurveyData surveyDataItem2;
    private SurveyData surveyDataItem3;
    private SurveyData surveyDataItem4;
    private SurveyData surveyDataItem5;
    
    
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
    

    public SurveyData getSurveyDataItem1() {
        if (surveyDataItem1 == null) {
            surveyDataItem1 = new SurveyData();
        }
        return surveyDataItem1;
    }

    public void setSurveyDataItem1(SurveyData surveyDataItem1) {
        this.surveyDataItem1 = surveyDataItem1;
    }

    public SurveyData getSurveyDataItem2() {
        if (surveyDataItem2 == null) {
            surveyDataItem2 = new SurveyData();
        }
        return surveyDataItem2;
    }

    public void setSurveyDataItem2(SurveyData surveyDataItem2) {
        this.surveyDataItem2 = surveyDataItem2;
    }

    public SurveyData getSurveyDataItem3() {
        if (surveyDataItem3 == null) {
            surveyDataItem3 = new SurveyData();
        }
        return surveyDataItem3;
    }

    public void setSurveyDataItem3(SurveyData surveyDataItem3) {
        this.surveyDataItem3 = surveyDataItem3;
    }

    public SurveyData getSurveyDataItem4() {
        if (surveyDataItem4 == null) {
            surveyDataItem4 = new SurveyData();
        }
        return surveyDataItem4;
    }

    public void setSurveyDataItem4(SurveyData surveyDataItem4) {
        this.surveyDataItem4 = surveyDataItem4;
    }

    public SurveyData getSurveyDataItem5() {
        if (surveyDataItem5 == null) {
            surveyDataItem5 = new SurveyData();
        }
        return surveyDataItem5;
    }

    public void setSurveyDataItem5(SurveyData surveyDataItem5) {
        this.surveyDataItem5 = surveyDataItem5;
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
            survey.setSurveyName("");
            survey.setSurveyDescription("");
            createSurveyItems(survey.getSurveyID());
        }
        FacesContext.getCurrentInstance().getExternalContext().redirect("managerSurveys.xhtml");
        return "managerSurveys.xhtml";
    }

    public String deactivateSurvey(Surveys survey) throws Exception {
        LOG.debug("Reached the remove method");
        survey.setIsRemoved(true);
        LOG.debug("Reached the setRemoved method");
        survey.setLastModified(new Date());
        LOG.debug("Reached the setModified method");
        surveysJpaController.edit(survey);
        LOG.debug("Reached the edit method");
        return null;
    }

    public String activateSurvey(Surveys survey) throws Exception {
        List<Surveys> allSurveys = surveysJpaController.findSurveysEntities();
        for(Surveys surveyItem : allSurveys){
            surveyItem.setIsRemoved(true);
            surveyItem.setLastModified(new Date());
            surveysJpaController.edit(surveyItem);
        }
        LOG.debug("Reached the activate method");
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
            activateSurvey(survey);
        } else {
            deactivateSurvey(survey);
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

    private void createSurveyItems(Integer surveyID) throws Exception {
        List<SurveyData> surveyItemList = getListSurveyItems();
        for(SurveyData item : surveyItemList){
            if(item.getChoice() != null){
            LOG.info("this shit needs value "+ item.getChoice());
            item.setSurveyID(surveyID);
            item.setDateCreated(new Date());
            item.setIsRemoved(false);
            item.setLastModified(new Date());
            item.setVotes(0);
            surveyDataJpaController.create(item);
            item.setChoice("");
            }
        }
    }

    private List<SurveyData> getListSurveyItems() {
        return Arrays.asList(getSurveyDataItem1(),getSurveyDataItem2(),getSurveyDataItem3(),getSurveyDataItem4(),getSurveyDataItem5());
    }
}
