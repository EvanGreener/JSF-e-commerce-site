package com.gb1w20.arquillian.test;

import com.gb1w20.arquillian.test.beans.NewsTestingBean;
import com.gb1w20.arquillian.test.beans.ClientTestingBean;
import com.gb1w20.book_store_project.backing.BookFormatBackingBean;
import com.gb1w20.book_store_project.beans.NewsBean;
import com.gb1w20.book_store_project.entities.News;
import com.gb1w20.book_store_project.entities.BookFormat;
import com.gb1w20.book_store_project.jpa_controllers.NewsJpaController;
import com.gb1w20.book_store_project.jpa_controllers.BookFormatJpaController;
import com.gb1w20.book_store_project.jpa_controllers.exceptions.IllegalOrphanException;
import com.gb1w20.book_store_project.util.MessageLoader;
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
 * Parameterized testing for the news JPA controller methods
 * @author Giancarlo Biasiucci
 * @version April 10, 2020
 */
@RunWith(Arquillian.class)
public class NewsParameterizedTest {
    
    private final static Logger LOG = LoggerFactory.getLogger(NewsParameterizedTest.class);

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
                .addPackage(BookFormatJpaController.class.getPackage())
                .addPackage(IllegalOrphanException.class.getPackage())
                .addPackage(BookFormat.class.getPackage())
                .addPackage(BookFormatBackingBean.class.getPackage())
                .addPackage(ParameterRule.class.getPackage())
                .addPackage(ClientTestingBean.class.getPackage())
                .addPackage(NewsBean.class.getPackage())
                .addPackage(MessageLoader.class.getPackage())
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/payara-resources.xml"), "payara-resources.xml")
                .addAsResource(new File("src/main/resources/META-INF/persistence.xml"), "META-INF/persistence.xml")
                .addAsResource(new File("src/main/resources/log4j2.xml"), "log4j2.xml")
                .addAsResource("Book_Store_DML.sql")
                .addAsLibraries(dependencies);

        return webArchive;
    }
    @Inject
    private NewsJpaController newsControl;

    @Rule
    public ParameterRule newsRule = new ParameterRule("newsTest",
            new NewsTestingBean(1,"Removed"),
            new NewsTestingBean(2,"Removed"),
            new NewsTestingBean(3,"Removed"),
            new NewsTestingBean(4,"Removed"),
            new NewsTestingBean(5,"Removed"),
            new NewsTestingBean(6,"Not Removed")
            
    );

    private NewsTestingBean newsTest;


    @Resource(lookup = "java:app/jdbc/bookstore")
    private DataSource ds;

    @PersistenceContext(unitName = "bookstorePU")
    private EntityManager em;

    @Resource
    private UserTransaction utx;
    
    /**
     * Tests if a randomly selected news feed is in the list of actual news feeds in the database
     */
    @Test
    public void testRandomNewsIsAlwaysReal()
    {
        News news = newsControl.getRandomNews();
        List<News> allNews = newsControl.findNewsEntities();
        assertTrue("Expected: included, actual: not", allNews.contains(news));
    }
    
    /**
     * Tests if the enabled news feed is in the list of actual news feeds in the database
     */
    @Test
    public void testEnabledNewsIsAlwaysReal()
    {
        News news = newsControl.getEnabledNews();
        List<News> allNews = newsControl.findNewsEntities();
        assertTrue("Expected: included, actual: not", allNews.contains(news));
    }
    
    /**
     * Tests for the expected removal status of a news feed.
     * Replicates the controller query due to testing problems with i18n
     */
    @Test
    public void testExpectedStatus()
    {
        String removalString = "Not Removed";
        boolean removalStatus = newsControl.findNews(newsTest.newsID).getIsRemoved();
        if (removalStatus)
        {
            removalString = "Removed";
        }
        assertEquals("Expected: " + newsTest.expectedStatus + ", actual: " + removalString,
                newsTest.expectedStatus, removalString);
    }
    
    /**
     * Restore the database to a known state before testing. This is important
     * if the test is destructive. This routine is courtesy of Bartosz Majsak
     * who also solved my Arquillian remote server problem
     * From: KFWebStandardProject - ArquillianUnitTest.java
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
     * All of the following are from: KFWebStandardProject - ArquillianUnitTest.java
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
