/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.arquillian.test;

import com.gb1w20.arquillian.test.beans.AdsTestingBean;
import com.gb1w20.arquillian.test.beans.AuthorsTestingBean;
import com.gb1w20.arquillian.test.beans.BookTestingBean;
import com.gb1w20.arquillian.test.beans.ClientTestingBean;
import com.gb1w20.book_store_project.backing.BookFormatBackingBean;
import com.gb1w20.book_store_project.beans.NewsBean;
import com.gb1w20.book_store_project.entities.Ads;
import com.gb1w20.book_store_project.entities.Authors;
import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.entities.BookFormat;
import com.gb1w20.book_store_project.jpa_controllers.AdsJpaController;
import com.gb1w20.book_store_project.jpa_controllers.AuthorsJpaController;
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
 * @author shruti pareek
 */
@RunWith(Arquillian.class)
public class AuthorsParameterizedTest {

    private final static Logger LOG = LoggerFactory.getLogger(AuthorsParameterizedTest.class);

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
                .addPackage(AuthorsJpaController.class.getPackage())
                .addPackage(ParameterRule.class.getPackage())
                .addPackage(AuthorsTestingBean.class.getPackage())
                .addPackage(Authors.class.getPackage())
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/payara-resources.xml"), "payara-resources.xml")
                .addAsResource(new File("src/main/resources/META-INF/persistence.xml"), "META-INF/persistence.xml")
                .addAsResource(new File("src/main/resources/log4j2.xml"), "log4j2.xml")
                .addAsResource("Book_Store_DML.sql")
                .addAsLibraries(dependencies);

        return webArchive;
    }
    @Inject
    private AuthorsJpaController authorsControl;

    @Rule
    public ParameterRule authorsRule = new ParameterRule("authorsTest",
            new AuthorsTestingBean(new Authors(1), "John Steinbeck"),
            new AuthorsTestingBean(new Authors(2), "Louis Sachar"),
            new AuthorsTestingBean(new Authors(3), "Harper Lee"),
            new AuthorsTestingBean(new Authors(4), "F. Scott Fitzgerald"),
            new AuthorsTestingBean(new Authors(6), "George Orwell, Russell Baker")
    );

    private AuthorsTestingBean authorsTest;

    @Resource(lookup = "java:app/jdbc/bookstore")
    private DataSource ds;

    @PersistenceContext(unitName = "bookstorePU")
    private EntityManager em;

    @Resource
    private UserTransaction utx;

    /**
     * @author shruti pareek
     */
    @Test
    public void testGetAuthorNames() {
        LOG.debug("testGetAuthorNames");
        boolean isSuccess = false;
        List<String> resultAuthor = authorsControl.getAuthorNames();
        for (String names : resultAuthor) {
            if (names.equals(authorsTest.authorName)) {
                isSuccess = true;
            }
        }

        assertTrue("authorsTest returned inconsistent results Expected:" + authorsTest.authorName + " Actual:" + resultAuthor.get(0), isSuccess);
    }

    /**
     * @author shruti pareek
     */
    @Test
    public void testGetAuthorByName() {
        LOG.debug("testGetAuthorByName");
        boolean isSuccess = true;
        Authors resultAuthor = authorsControl.getAuthorByName(authorsTest.authorName);
       
            if (!(authorsTest.expectedAuthor.toString().equals(resultAuthor.toString()))) {
                isSuccess = false;
            }
        

         assertTrue("authorsTest returned inconsistent results Expected:" + authorsTest.expectedAuthor.toString() + " Actual:" + resultAuthor.toString(), isSuccess);
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
