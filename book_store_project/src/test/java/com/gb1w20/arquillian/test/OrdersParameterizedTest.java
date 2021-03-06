/*
 * All arquillain tests belong to this package
 */
package com.gb1w20.arquillian.test;

import com.gb1w20.arquillian.test.beans.OrdersTestingBean;
import com.gb1w20.book_store_project.entities.OrderItem;
import com.gb1w20.book_store_project.entities.Orders;
import com.gb1w20.book_store_project.jpa_controllers.OrdersJpaController;
import com.gb1w20.book_store_project.jpa_controllers.exceptions.IllegalOrphanException;

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
 * tests orders jpa controller methods
 * @author Shruti Pareek
 */
@RunWith(Arquillian.class)
public class OrdersParameterizedTest {

    private final static Logger LOG = LoggerFactory.getLogger(OrdersParameterizedTest.class);

 
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
                .addPackage(OrdersJpaController.class.getPackage())
                .addPackage(IllegalOrphanException.class.getPackage())
                .addPackage(ParameterRule.class.getPackage())
                .addPackage(Orders.class.getPackage())
                .addPackage(OrderItem.class.getPackage())
                .addPackage(OrdersTestingBean.class.getPackage())
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/payara-resources.xml"), "payara-resources.xml")
                .addAsResource(new File("src/main/resources/META-INF/persistence.xml"), "META-INF/persistence.xml")
                .addAsResource(new File("src/main/resources/log4j2.xml"), "log4j2.xml")
                .addAsResource("Book_Store_DML.sql")
                .addAsLibraries(dependencies);

        return webArchive;
    }
    @Inject
    private OrdersJpaController orderControl;

    /**
     * data to test methods
     */
    @Rule
    public ParameterRule Bookrule = new ParameterRule("orderTest",
            new OrdersTestingBean(1, "cst.send@gmail.com", 1, 1, "Removed", "9780142000670", "isbn", new Orders(1)),
            new OrdersTestingBean(2, "cst.receive@gmail.com", 2, 1, "Removed", "9780439244190", "isbn", new Orders(2)),
            new OrdersTestingBean(3, "dcastaner0@cbslocal.com", 3, 1, "Not Removed", "dcastaner0@cbslocal.com", "email", new Orders(3)),
            new OrdersTestingBean(4, "jhutcheon1@last.fm", 5, 1, "Removed", "5", "id", new Orders(5)),
            new OrdersTestingBean(5, "sdoud2@liveinternet.ru", 6, 1, "Not Removed", "6", "id", new Orders(6))
    );

    private OrdersTestingBean orderTest;

    @Resource(lookup = "java:app/jdbc/bookstore")
    private DataSource ds;

    @PersistenceContext(unitName = "bookstorePU")
    private EntityManager em;

    @Resource
    private UserTransaction utx;

    /**
     * tests if gets correct client through their email
     * @author shruti
     */
    @Test
    public void testGetClientEmailById() {
        LOG.debug("testGetClientEmailById");
        boolean isSuccess = true;
        String resultEmail = orderControl.getClientEmailById(orderTest.testClientId);

        if (!(resultEmail.equals(orderTest.expectedEmail))) {
            isSuccess = false;
        }
        assertTrue("orderTest returned inconsistent results Expected:" + orderTest.expectedEmail + " Actual:" + resultEmail, isSuccess);
    }

    /**
     * tests if get correct orderitem count
     * @author shruti
     */
    @Test
    public void testGetOrderItemsCountByOrderId() {
        LOG.debug("testGetOrderItemsCountByOrderId");
        boolean isSuccess = true;
        int resultOrderItemCount = orderControl.getOrderItemsCountByOrderId(orderTest.testOrderId);

        if (!(resultOrderItemCount == orderTest.expectedOrderItemCount)) {

            isSuccess = false;
        }
        assertTrue("orderTest returned inconsistent results Expected:" + orderTest.expectedOrderItemCount + " Actual:" + resultOrderItemCount, isSuccess);
    }

    /**
     * tests if gets correct status
     * @author shruti
     */
    @Test
    public void testGetStatusByOrderId() {
        LOG.debug("testGetStatusByOrderId");
        boolean isSuccess = true;
        String resultStatus = "Not Removed";
        
        if (orderControl.findOrders(orderTest.testOrderId).getIsRemoved())
        {
            resultStatus = "Removed";
        }

        if (!(resultStatus.equals(orderTest.expectedStatus))) {
            isSuccess = false;
        }
        assertTrue("resultStatus returned inconsistent results Expected:" + orderTest.expectedStatus + " Actual:" + resultStatus, isSuccess);
    }

    /**
     * tests if retrieves correct orders
     * @author shruti
     */
    @Test
    public void testSearchOrders() {
        LOG.debug("testSearchOrders");
        boolean isSuccess = true;
        List<Orders> resultOrder = orderControl.searchOrders(orderTest.testQuery, orderTest.testSearchBy);

        if (!(resultOrder.get(0).toString().equals(orderTest.expectedOrder.toString()))) {
            isSuccess = false;
        }
        assertTrue("orderTest returned inconsistent results Expected:" + orderTest.expectedOrder.toString() + " Actual:" + resultOrder.get(0).toString(), isSuccess);
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
