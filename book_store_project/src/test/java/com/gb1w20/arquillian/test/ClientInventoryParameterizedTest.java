/*
 * All arquillain tests belong to this package
 */
package com.gb1w20.arquillian.test;

import com.gb1w20.arquillian.test.beans.ClientInventoryTestingBean;
import com.gb1w20.book_store_project.entities.ClientInventory;
import com.gb1w20.book_store_project.jpa_controllers.ClientInventoryJpaController;
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
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * tests the client inventory jpa methods
 * @author shruti pareek
 */
@RunWith(Arquillian.class)
public class ClientInventoryParameterizedTest {

    private final static Logger LOG = LoggerFactory.getLogger(ClientInventoryParameterizedTest.class);


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
                .addPackage(ClientInventoryJpaController.class.getPackage())
                .addPackage(ParameterRule.class.getPackage())
                .addPackage(ClientInventoryTestingBean.class.getPackage())
                .addPackage(ClientInventory.class.getPackage())
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/payara-resources.xml"), "payara-resources.xml")
                .addAsResource(new File("src/main/resources/META-INF/persistence.xml"), "META-INF/persistence.xml")
                .addAsResource(new File("src/main/resources/log4j2.xml"), "log4j2.xml")
                .addAsResource("Book_Store_DML.sql")
                .addAsLibraries(dependencies);

        return webArchive;
    }
    @Inject
    private ClientInventoryJpaController clientInventoryControl;

    /**
     * data to test methods
     */
    @Rule
    public ParameterRule ClientInventoryRule = new ParameterRule("clientInventoryTest",
            new ClientInventoryTestingBean(1, new ClientInventory(1)),
            new ClientInventoryTestingBean(2, new ClientInventory(2)),
            new ClientInventoryTestingBean(3, new ClientInventory(3)),
            new ClientInventoryTestingBean(5, new ClientInventory(4)),
            new ClientInventoryTestingBean(6, new ClientInventory(5))
    );

    private ClientInventoryTestingBean clientInventoryTest;

    @Resource(lookup = "java:app/jdbc/bookstore")
    private DataSource ds;

    @PersistenceContext(unitName = "bookstorePU")
    private EntityManager em;

    @Resource
    private UserTransaction utx;

    /**
     * tests if finds client's inventory through their id
     * @author shruti pareek
     */
    @Test
    public void testFindClientInventory() {
        LOG.debug("testFindClientInventory");
        boolean isSuccess = false;
        List<ClientInventory> resultClientInventory = clientInventoryControl.findClientInventory(clientInventoryTest.clientId);
        for (ClientInventory c : resultClientInventory) {
            if (c.toString().equals(clientInventoryTest.expectedClientInventory.toString())) {
                isSuccess = true;
            }
        }

        assertTrue("clientInventoryTest returned inconsistent results ", isSuccess);
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
