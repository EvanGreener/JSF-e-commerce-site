/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.arquillian.test;

import com.gb1w20.arquillian.test.beans.PublisherTestingBean;
import com.gb1w20.arquillian.test.beans.SurveyDataTestingBean;
import com.gb1w20.arquillian.test.beans.TaxTestingBean;
import com.gb1w20.book_store_project.entities.Publisher;
import com.gb1w20.book_store_project.entities.SurveyData;
import com.gb1w20.book_store_project.jpa_controllers.PublisherJpaController;
import com.gb1w20.book_store_project.jpa_controllers.SurveyDataJpaController;
import com.gb1w20.book_store_project.jpa_controllers.TaxJpaController;
import com.gb1w20.book_store_project.jpa_controllers.exceptions.IllegalOrphanException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.transaction.UserTransaction;
import org.assertj.core.util.Arrays;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author Evan Greenstein
 */
@RunWith(Arquillian.class)
public class SurveryDataParameterizedTest {

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

          // The SQL script to create the database is in src/test/resources
          final WebArchive webArchive = ShrinkWrap.create(WebArchive.class, "test.war")
                  .setWebXML(new File("src/main/webapp/WEB-INF/web.xml"))
                  .addPackage(SurveyDataJpaController.class.getPackage())
                  .addPackage(SurveyData.class.getPackage())
                  .addPackage(ParameterRule.class.getPackage())
                  .addPackage(SurveyDataTestingBean.class.getPackage())
                  .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                  .addAsWebInfResource(new File("src/main/webapp/WEB-INF/payara-resources.xml"), "payara-resources.xml")
                  .addAsResource(new File("src/main/resources/META-INF/persistence.xml"), "META-INF/persistence.xml")
                  .addAsResource(new File("src/main/resources/log4j2.xml"), "log4j2.xml")
                  .addAsResource("createFishTable.sql")
                  .addAsLibraries(dependencies);

          return webArchive;
     }

     @Inject
     private SurveyDataJpaController surveyDataCtrl;

     @Rule
     public ParameterRule rule = new ParameterRule("surveyDataTest",
                  new SurveyDataTestingBean(1, Arrays.asList(new int[] {10, 20, 5, 2, 1}) ),
                  new SurveyDataTestingBean(2, Arrays.asList(new int[] {10, 15, 20, 15, 5, 3}) )
          );

     private SurveyDataTestingBean surveyDataTest;

     @Resource(lookup = "java:app/jdbc/bookstore")
     private DataSource ds;

     @PersistenceContext(unitName = "bookstorePU")
     private EntityManager em;

     @Resource
     private UserTransaction utx;

     /**
      * Verifying that the right survey data gets returned by checking the expected amount of votes per choice
      * @author Evan Greenstein
      */
     @Test
     public void testGetSurveryChoices() {
          List<SurveyData> surveyDataResult = surveyDataCtrl.getSurveyChoices(surveyDataTest.surveyID);
          List<Object> expectedVotes =  surveyDataTest.expectedVotesPerChoice;
          boolean isEqual = true;
          for (int i = 0; i < surveyDataResult.size(); i++ ){
               if (surveyDataResult.get(i).getVotes() != (int) expectedVotes.get(i) ) {
                    isEqual = false; 
                    break;
               }
          }
          
          assertTrue(isEqual );
     }

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
