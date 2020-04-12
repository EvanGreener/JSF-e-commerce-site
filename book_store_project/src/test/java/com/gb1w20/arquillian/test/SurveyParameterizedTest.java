/*
 * All arquillain tests belong to this package
 */
package com.gb1w20.arquillian.test;

import com.gb1w20.arquillian.test.beans.SurveyTestingBean;
import com.gb1w20.book_store_project.backing.SurveyBackingBean;
import com.gb1w20.book_store_project.beans.SurveyBean;
import com.gb1w20.book_store_project.entities.Surveys;
import com.gb1w20.book_store_project.jpa_controllers.SurveyDataJpaController;
import com.gb1w20.book_store_project.jpa_controllers.SurveysJpaController;
import com.gb1w20.book_store_project.jpa_controllers.exceptions.IllegalOrphanException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
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
import static org.junit.Assert.assertTrue;
import org.junit.Before;
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

    private final static Logger LOG = LoggerFactory.getLogger(SurveyParameterizedTest.class);

    /**
     *
     * @return
     */
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
                .addAsResource("Book_Store_DML.sql")
                .addAsLibraries(dependencies);

        return webArchive;
    }
    
    @Inject
    private SurveysJpaController surveyControl;
    
    @Inject
    private SurveyDataJpaController surveyDataControl;
    
    /**
     *
     */
    @Rule
    public ParameterRule surveyRule = new ParameterRule("surveyTest",
            new SurveyTestingBean(1,5,38),
            new SurveyTestingBean(2,6,68),
            new SurveyTestingBean(3,4,37),
            new SurveyTestingBean(4,4,28),
            new SurveyTestingBean(5,4,55),
            new SurveyTestingBean(6,6,43)
    );
    
    private SurveyTestingBean surveyTest;
    
    @Resource(lookup = "java:app/jdbc/bookstore")
    private DataSource ds;

    @PersistenceContext(unitName = "bookstorePU")
    private EntityManager em;

    @Resource
    private UserTransaction utx;
    
    /**
     *
     */
    @Test
    public void testCorrectChoiceAmount()
    {
        Surveys survey = surveyControl.findSurveys(surveyTest.surveyID);
        int choices = surveyDataControl.getSurveyChoices(survey.getSurveyID()).size();
        assertEquals("Expected size " + surveyTest.expectedChoices + " vs. actual size " + choices,
                surveyTest.expectedChoices, choices);
    }
    
    /**
     *
     */
    @Test
    public void testCorrectUserVotes()
    {
        Surveys survey = surveyControl.findSurveys(surveyTest.surveyID);
        int votes = surveyControl.getTotalVotesSingleSurvey(survey.getSurveyID());
        assertEquals("Expected number of  " + surveyTest.expectedVotes + " vs. actual size " + votes,
                surveyTest.expectedVotes, votes);
    }
    
    /**
     *
     */
    @Test
    public void testActiveSurveyIsReal()
    {
        Surveys survey = surveyControl.getActiveSurvey();
        List<Surveys> surveyList = surveyControl.findSurveysEntities();
        assertTrue("Expected: contains, actual: doesn't contain", surveyList.contains(survey));
    }
    
    /**
     * Restore the database to a known state before testing. This is important
     * if the test is destructive. This routine is courtesy of Bartosz Majsak
     * who also solved my Arquillian remote server problem
     */
    @Before
    public void seedDatabase() {
        final String seedDataScript = loadAsString("Book_Store_DML.sql");

        try (Connection connection = ds.getConnection()) {
            for (String statement : splitStatements(new StringReader(
                    seedDataScript), ";")) {
                connection.prepareStatement(statement).execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed seeding database", e);
        }
    }

    /**
     * The following methods support the seedDatabse method
     */
    private String loadAsString(final String path) {
        try (InputStream inputStream = Thread.currentThread()
                .getContextClassLoader().getResourceAsStream(path)) {
            return new Scanner(inputStream).useDelimiter("\\A").next();
        } catch (IOException e) {
            throw new RuntimeException("Unable to close input stream.", e);
        }
    }

    private List<String> splitStatements(Reader reader,
            String statementDelimiter) {
        final BufferedReader bufferedReader = new BufferedReader(reader);
        final StringBuilder sqlStatement = new StringBuilder();
        final List<String> statements = new LinkedList<>();
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || isComment(line)) {
                    continue;
                }
                sqlStatement.append(line);
                if (line.endsWith(statementDelimiter)) {
                    statements.add(sqlStatement.toString());
                    sqlStatement.setLength(0);
                }
            }
            return statements;
        } catch (IOException e) {
            throw new RuntimeException("Failed parsing sql", e);
        }
    }

    private boolean isComment(final String line) {
        return line.startsWith("--") || line.startsWith("//")
                || line.startsWith("/*");
    }
}