/*
 * All arquillain tests belong to this package
 */
package com.gb1w20.arquillian.test;

import com.gb1w20.arquillian.test.beans.ClientTestingBean;
import com.gb1w20.book_store_project.beans.NewsBean;
import com.gb1w20.book_store_project.entities.Clients;
import com.gb1w20.book_store_project.jpa_controllers.ClientsJpaController;
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
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * tests client jpa controller methods
 * @author giancarlo,Shruti pareek
 */
@RunWith(Arquillian.class)
public class ClientParameterizedTest {

    private final static Logger LOG = LoggerFactory.getLogger(ClientParameterizedTest.class);


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
                .addPackage(ClientsJpaController.class.getPackage())
                .addPackage(IllegalOrphanException.class.getPackage())
                .addPackage(Clients.class.getPackage())
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
    private ClientsJpaController clientControl;

    /**
     * data to test client controller methods
     */
    @Rule
    public ParameterRule rule = new ParameterRule("dynamic",
            new ClientTestingBean("dcastaner0@cbslocal.com", "dcastaner0@cbslocal.com", false, "Dosi", "1",
                    "dcastaner0@cbslocal.com", "Dosi", "dcastaner0@cbslocal.com", 1,
                    "Dosi", "Castaner", "1875 Artisan Lane", "Empty", "Oberbrunner LLC", "Empty", new Clients(3), "dcastaner0@cbslocal.com", "email"),
            new ClientTestingBean("jhutcheon1@last.fm", "jhutcheon1@last.fm", true, "Jane", "2",
                    "jhutcheon1@last.fm", "Jane", "jhutcheon1@last.fm", 0,
                    "Jane", "Hutcheon", "27173 International Junction", "Empty", "Rogahn, Barrows and Wehner", "Empty", new Clients(4), "jhutcheon1@last.fm", "email"),
            new ClientTestingBean("vgrigoli3@github.com", "vgrigoli3@github.com", false, "Vernice", "4",
                    "vgrigoli3@github.com", "Vernice", "vgrigoli3@github.com", 1,
                    "Vernice", "Grigoli", "1161 Loomis Plaza", "Empty", "Rice, Hegmann and Gorczany", "6445467612", new Clients(6), "vgrigoli3@github.com", "email"),
            new ClientTestingBean("deastesg@networksolutions.com", "deastesg@networksolutions.com", false, "Denys", "17",
                    "deastesg@networksolutions.com", "Denys", "deastesg@networksolutions.com", 1,
                    "Denys", "Eastes", "67423 Pine View Lane", "0", "Gleichner Inc", "2138184727", new Clients(19), "19", "id"),
            new ClientTestingBean("ebeavonl@ycombinator.com", "ebeavonl@ycombinator.com", false, "Elaina", "22",
                    "ebeavonl@ycombinator.com", "Elaina", "ebeavonl@ycombinator.com", 1,
                    "Elaina", "Beavon", "6 Nova Circle", "Empty", "Considine-Mayer", "Empty", new Clients(24), "24", "id")
    );

    private ClientTestingBean dynamic;

    @Resource(lookup = "java:app/jdbc/bookstore")
    private DataSource ds;

    @PersistenceContext(unitName = "bookstorePU")
    private EntityManager em;

    @Resource
    private UserTransaction utx;

    /**
     * Tests if they expected client information is returned based on their email
     * @author Giancarlo Biasiucci
     */
    @Test
    public void testEmailInfo() {
        boolean isSuccess = true;
        Object[] testClientInfo = clientControl.getInfoByEmail(dynamic.email);
        if (!(testClientInfo[0].toString().equals(dynamic.infoEmail))
                || !((Boolean) testClientInfo[2] == dynamic.isManager)
                || !(testClientInfo[3].toString().equals(dynamic.firstName))
                || !(testClientInfo[5].toString().equals(dynamic.provinceAbbr))) {
            isSuccess = false;
        }
        assertTrue("Email info returned inconsistent results", isSuccess);
    }

    /**
     * Tests if the email search returns the correct client, and the correct client information
     * @author Giancarlo Biasiucci
     */
    @Test
    public void testEmailSearch() {
        boolean isSuccess = true;
        List<Object[]> searchResults = clientControl.searchClientsNoSum(dynamic.email);

        if (!searchResults.isEmpty() && dynamic.managerIndicator == 0) {
            isSuccess = false;
        } else if (searchResults.size() == 1) {
            Object[] results = searchResults.get(0);
            for (int i = 0; i < results.length; i++) {
                if (results[i] == null) {
                    results[i] = "Empty";
                }
            }
            if (!results[1].toString().equals(dynamic.searchEmail)
                    || !results[2].toString().equals(dynamic.searchFname)
                    || !results[3].toString().equals(dynamic.searchLname)
                    || !results[4].toString().equals(dynamic.searchAddress1)
                    || !results[5].toString().equals(dynamic.searchAddress2)
                    || !results[6].toString().equals(dynamic.searchCompanyName)
                    || !results[7].toString().equals(dynamic.searchCellPhone)) {
                isSuccess = false;
            }

        } else if (searchResults.isEmpty() && dynamic.managerIndicator == 0) {
            isSuccess = true;
        } else {
            isSuccess = false;
        }
        assertTrue("Email search returned inconsistent results", isSuccess);
    }

    /**
     * tests if gets correct email
     * @author Shruti Pareek
     */
    @Test
    public void testGetEmailsByEmail() {
        LOG.debug("testGetEmailsByEmail");
        boolean isSuccess = true;
        List<String> resultEmail = clientControl.getEmailsByEmail(dynamic.email);
        if (!(resultEmail.get(0).equals(dynamic.email))) {
            isSuccess = false;
        }
        assertTrue("Email info returned inconsistent results Expected:" + dynamic.email + " Actual:" + resultEmail, isSuccess);
    }

    /**
     * tests if gets clients by email
     * @author Shruti Pareek
     */
    @Test
    public void testFindClientByEmail() {
        LOG.debug("testFindClientByEmail");
        boolean isSuccess = true;
        Clients resultClient = clientControl.findClientByEmail(dynamic.email);
        if (!(resultClient.toString().equals(dynamic.expectedClient.toString()))) {
            isSuccess = false;
        }
        assertTrue("Email info returned inconsistent results Expected:" + dynamic.expectedClient.toString() + " Actual:" + resultClient.toString(), isSuccess);
    }

    /**
     * tests if correct client info is returned when searching for clients
     * @author Shruti Pareek
     */
    @Test
    public void testSearchClients() {
        LOG.debug("testSearchClients");
        boolean isSuccess = true;
        try {
            List<Object[]> resultClientInfo = clientControl.searchClients(dynamic.expectedQuery, dynamic.expectedSearchBy);

            if (!(resultClientInfo.get(0)[0].toString().equals(dynamic.expectedClient.getClientID().toString()))) {
                isSuccess = false;
            }

            assertTrue("Email info returned inconsistent results Expected:" + dynamic.expectedClient.getClientID() + " Actual:" + resultClientInfo.get(0)[0].toString(), isSuccess);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertTrue("Email info returned inconsistent results", isSuccess);
        }
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
