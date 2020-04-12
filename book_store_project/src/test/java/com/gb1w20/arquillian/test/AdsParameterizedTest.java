/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.arquillian.test;

import com.gb1w20.arquillian.test.beans.AdsTestingBean;
import com.gb1w20.arquillian.test.beans.BookTestingBean;
import com.gb1w20.arquillian.test.beans.ClientTestingBean;
import com.gb1w20.book_store_project.backing.BookFormatBackingBean;
import com.gb1w20.book_store_project.beans.NewsBean;
import com.gb1w20.book_store_project.entities.Ads;
import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.entities.BookFormat;
import com.gb1w20.book_store_project.jpa_controllers.AdsJpaController;
import com.gb1w20.book_store_project.jpa_controllers.BookFormatJpaController;
import com.gb1w20.book_store_project.jpa_controllers.BookJpaController;
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
 * @author giancarlo,shruti pareek
 */
@RunWith(Arquillian.class)
public class AdsParameterizedTest {

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
                
                .addPackage(IllegalOrphanException.class.getPackage())
                .addPackage(AdsJpaController.class.getPackage())
                .addPackage(ParameterRule.class.getPackage())
                .addPackage(AdsTestingBean.class.getPackage())
                .addPackage(Ads.class.getPackage())
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/payara-resources.xml"), "payara-resources.xml")
                .addAsResource(new File("src/main/resources/META-INF/persistence.xml"), "META-INF/persistence.xml")
                .addAsResource(new File("src/main/resources/log4j2.xml"), "log4j2.xml")
                .addAsResource("Book_Store_DML.sql")
                .addAsLibraries(dependencies);

        return webArchive;
    }
    @Inject
    private AdsJpaController adsControl;

    @Rule
    public ParameterRule adsRule = new ParameterRule("adTest",
            new AdsTestingBean(1, "Not Removed", 2),
            new AdsTestingBean(2, "Not Removed", 2),
            new AdsTestingBean(3, "Removed", 2),
            new AdsTestingBean(4, "Removed", 2),
            new AdsTestingBean(5, "Removed", 2),
            new AdsTestingBean(6, "Removed", 2)
    );

    private AdsTestingBean adTest;

    @Resource(lookup = "java:app/jdbc/bookstore")
    private DataSource ds;

    @PersistenceContext(unitName = "bookstorePU")
    private EntityManager em;

    @Resource
    private UserTransaction utx;

    @Test
    public void testExpectedStatus() {
        String removalStatus = adsControl.getStatusByAdId(adsControl.findAds(adTest.adID).getAdID());
        assertEquals("Expected: " + adTest.expectedStatus + ", actual: " + removalStatus,
                adTest.expectedStatus, removalStatus);
    }

    @Test
    public void testRandomAdIsAlwaysReal() {
        Ads ad = adsControl.getRandomAd();
        List<Ads> allAds = adsControl.findAdsEntities();
        assertTrue("Expected: included, actual: not", allAds.contains(ad));
    }

    /**
     * @author shruti pareek
     */
    @Test
    public void testGetAdsCount() {
        LOG.debug("testGetAdsCount");
        boolean isSuccess = true;
        int resultAdCount = adsControl.getAdsCount();
        if (!(resultAdCount == adTest.expectedCount)) {
            isSuccess = false;
        }
        assertTrue("adTest returned inconsistent results Expected:" + adTest.expectedCount + " Actual:" + resultAdCount, isSuccess);
    }

    /**
     * @author shruti pareek
     */
    @Test
    public void testAllEnabledAds() {
        LOG.debug("testAllEnabledAds");
        boolean isSuccess = false;
        List<Ads> resultEnabledAds = adsControl.getAllEnabledAds();
        for (Ads testAd : resultEnabledAds) {
            if (!(testAd.getAdID() == adTest.adID)) {
                isSuccess = true;
            }
        }

        assertTrue("adTest returned inconsistent results", isSuccess);
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
