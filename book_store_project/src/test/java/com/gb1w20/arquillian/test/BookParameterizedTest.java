/*
 * All arquillain tests belong to this package
 */
package com.gb1w20.arquillian.test;

import com.gb1w20.arquillian.test.beans.BookTestingBean;
import com.gb1w20.arquillian.test.beans.ClientTestingBean;
import com.gb1w20.book_store_project.backing.BookFormatBackingBean;
import com.gb1w20.book_store_project.beans.NewsBean;
import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.jpa_controllers.BookFormatJpaController;
import com.gb1w20.book_store_project.entities.BookFormat;
import com.gb1w20.book_store_project.jpa_controllers.BookJpaController;
import com.gb1w20.book_store_project.jpa_controllers.exceptions.IllegalOrphanException;
import com.gb1w20.book_store_project.util.MessageLoader;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Before;
import org.junit.runner.RunWith;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Arquillian testing for the book entity
 * @author Giancarlo Biasiucci
 * @version April 11, 2020
 */
@RunWith(Arquillian.class)
public class BookParameterizedTest {

    private final static Logger LOG = LoggerFactory.getLogger(BookParameterizedTest.class);


    @Deployment
    public static WebArchive deploy() {

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
    private BookJpaController bookControl;

    /**
     *
     */
    @Rule
    public ParameterRule Bookrule = new ParameterRule("bookTest",
            new BookTestingBean(new Book("9780141439471","Frankenstein"),14, "Not Removed"),
            new BookTestingBean(new Book("9780062024039","Divergent"), 13, "Removed"),
            new BookTestingBean(new Book("9780060584757","Mystic River"), 8, "Not Removed"),
            new BookTestingBean(new Book("9780756404734","The Wise Man's Fear"), 8, "Not Removed"),
            new BookTestingBean(new Book("9780345504968","The Passage"), 14, "Not Removed")
            
    );

    private BookTestingBean bookTest;


    @Resource(lookup = "java:app/jdbc/bookstore")
    private DataSource ds;

    @PersistenceContext(unitName = "bookstorePU")
    private EntityManager em;

    @Resource
    private UserTransaction utx;
    
     /**
<<<<<<< HEAD
     * Tests if a correct book is returned from an ISBN number
     * By: Giancarlo Biasiucci
=======
     * Tests if a correct book is returned from an isbn
     * @author shruti pareek
>>>>>>> 574368e2291f90acd82af0bb499612e9ad6bf485
     */
    @Test
    public void testFindSingleBook() {
        boolean isSuccess = true;
        Book testBookInfo = bookControl.findAnySingleBook(bookTest.book.getIsbn());
        LOG.debug(testBookInfo.toString());
        if (!(testBookInfo.toString().equals(bookTest.book.toString()))) {
            isSuccess = false;
        }
        assertTrue("Book info returned inconsistent results Expected:"+bookTest.book.toString()+" Result:"+testBookInfo.toString(), isSuccess);
    }
    
    /**
     * Tests if the correct number of similar genre books are returned from an isbn
<<<<<<< HEAD
     * By: Giancarlo Biasiucci
=======
     * @author giancarlo
>>>>>>> 574368e2291f90acd82af0bb499612e9ad6bf485
     */
    @Test
    public void testFindSimilarGenres() {
        boolean isSuccess = true;
        Book testBookInfo = bookControl.findAnySingleBook(bookTest.book.getIsbn());
        int similarGenreCount = bookControl.getSimilarGenresBookCount(testBookInfo);
        if (!(similarGenreCount == bookTest.expectedSimilar)) {
            isSuccess = false;
        }
        assertTrue("Similar genres returned inconsistent results Expected:"+bookTest.expectedSimilar+" Result:"+similarGenreCount, isSuccess);
    }
    
    /**
<<<<<<< HEAD
     * Tests if the correct book status is retrieved (identical process to controller method)
     * By: Giancarlo Biasiucci
=======
     * Tests if the correct status of a book is returned
     * @author giancarlo
>>>>>>> 574368e2291f90acd82af0bb499612e9ad6bf485
     */
    @Test
    public void testStatusRetrieval()
    {
        String removalStatus = "Not Removed";
        if (bookControl.findAnySingleBook(bookTest.book.getIsbn()).getIsRemoved())
        {
            removalStatus = "Removed";
        }
        assertEquals("Expected: " + bookTest.expectedStatus + ", actual: " + removalStatus,
                bookTest.expectedStatus, removalStatus);
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
