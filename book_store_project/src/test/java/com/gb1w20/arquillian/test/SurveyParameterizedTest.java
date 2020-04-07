/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.arquillian.test;

import com.gb1w20.arquillian.test.beans.SurveyTestingBean;
import com.gb1w20.book_store_project.backing.SurveyBackingBean;
import com.gb1w20.book_store_project.beans.SurveyBean;
import com.gb1w20.book_store_project.entities.Surveys;
import com.gb1w20.book_store_project.jpa_controllers.SurveyDataJpaController;
import com.gb1w20.book_store_project.jpa_controllers.SurveysJpaController;
import com.gb1w20.book_store_project.jpa_controllers.exceptions.IllegalOrphanException;
import java.io.File;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author giancarlo
 */
@RunWith(Arquillian.class)
public class SurveyParameterizedTest {

    private final static Logger LOG = LoggerFactory.getLogger(BookParameterizedTest.class);

    @Deployment
    public static WebArchive deploy() {

        // Use an alternative to the JUnit assert library called AssertJ
        // Need to reference MySQL driver as it is not part of either
        // embedded or remote
        final File[] dependencies = Maven
                .resolver()
                .loadPomFromFile("pom.xml")
                .resolve("mysql:mysql-connector-java",
                        "org.assertj:assertj-core",
                        "org.slf4j:slf4j-api",
                        "org.apache.logging.log4j:log4j-slf4j-impl",
                        "org.apache.logging.log4j:log4j-web"
                ).withTransitivity()
                .asFile();

        final WebArchive webArchive;
        webArchive = ShrinkWrap.create(WebArchive.class, "test.war")
                .setWebXML(new File("src/main/webapp/WEB-INF/web.xml"))
                .addPackage(SurveysJpaController.class.getPackage())
                .addPackage(IllegalOrphanException.class.getPackage())
                .addPackage(Surveys.class.getPackage())
                .addPackage(SurveyBackingBean.class.getPackage())
                .addPackage(ParameterRule.class.getPackage())
                .addPackage(SurveyTestingBean.class.getPackage())
                .addPackage(SurveyBean.class.getPackage())
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/payara-resources.xml"), "payara-resources.xml")
                .addAsResource(new File("src/main/resources/META-INF/persistence.xml"), "META-INF/persistence.xml")
                .addAsResource(new File("src/main/resources/log4j2.xml"), "log4j2.xml")
                .addAsResource("Test_DML.sql")
                .addAsLibraries(dependencies);

        return webArchive;
    }
    
    @Inject
    private SurveysJpaController surveyControl;
    
    @Inject
    private SurveyDataJpaController surveyDataControl;
    
    @Rule
    public ParameterRule surveyRule = new ParameterRule("surveyTest",
            new SurveyTestingBean(1,5),
            new SurveyTestingBean(2,6),
            new SurveyTestingBean(3,4),
            new SurveyTestingBean(4,4),
            new SurveyTestingBean(6,6)
    );
    
    private SurveyTestingBean surveyTest;
    
    @Resource(lookup = "java:app/jdbc/bookstore")
    private DataSource ds;

    @PersistenceContext(unitName = "bookstorePU")
    private EntityManager em;

    @Resource
    private UserTransaction utx;
    
    @Test
    public void testCorrectChoiceAmount()
    {
        Surveys survey = surveyControl.findSurveys(surveyTest.surveyID);
        int choices = surveyDataControl.getSurveyChoices(survey.getSurveyID()).size();
        assertEquals("Expected size " + surveyTest.expectedChoices + " vs. actual size " + choices,
                surveyTest.expectedChoices, choices);
    }
}