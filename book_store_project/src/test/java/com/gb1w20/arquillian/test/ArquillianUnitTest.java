package com.gb1w20.arquillian.test;

import com.gb1w20.arquillian.test.beans.BookTestingBean;
import com.gb1w20.arquillian.test.beans.ClientTestingBean;
import com.gb1w20.book_store_project.backing.BookFormatBackingBean;
import com.gb1w20.book_store_project.beans.NewsBean;
import com.gb1w20.book_store_project.entities.Book;
import com.gb1w20.book_store_project.jpa_controllers.BookFormatJpaController;
import com.gb1w20.book_store_project.entities.BookFormat;
import com.gb1w20.book_store_project.jpa_controllers.BookJpaController;
import com.gb1w20.book_store_project.jpa_controllers.ClientsJpaController;
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
 *
 * @author giancarlo
 */
@RunWith(Arquillian.class)
public class ArquillianUnitTest {

    private final static Logger LOG = LoggerFactory.getLogger(ArquillianUnitTest.class);

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

    @Rule
    public ParameterRule rule = new ParameterRule("dynamic",
            new ClientTestingBean("dcastaner0@cbslocal.com", "dcastaner0@cbslocal.com", false, "Dosi", "1",
                    "dcastaner0@cbslocal.com", "Dosi", "dcastaner0@cbslocal.com",
                    "Dosi", "Castaner", "1875 Artisan Lane", "Empty", "Oberbrunner LLC", "Empty")
    );

    private ClientTestingBean dynamic;

    @Resource(lookup = "java:app/jdbc/bookstore")
    private DataSource ds;

    @PersistenceContext(unitName = "bookstorePU")
    private EntityManager em;

    @Resource
    private UserTransaction utx;

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

    @Test
    public void testEmailSearch() {
        boolean isSuccess = true;
        List<Object[]> searchResults = clientControl.searchClientsNoSum(dynamic.email);
        if (searchResults.size() == 1) {
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
        } else {
            isSuccess = false;
        }
        assertTrue("Email search returned inconsistent results", isSuccess);
    }

    /*
    @Test
    public void testCreateBookFormat() throws IllegalStateException, Exception {
        LOG.info("testCreateBookFormat()");
        
        BookFormat bob = new BookFormat();
        bob.setDateCreated(new Date());
        bob.setFormat("E-Pub");
        bob.setIsRemoved(false);
        bob.setLastModified(new Date());
        bob.setFileLocation("sample.epub");

        formatControl.create(bob);

        BookFormat bob1 = formatControl.findBookFormat(bob.getFormatID());

        LOG.debug("ID " + bob.getFormatID());

        assertEquals("The ads are not the same", bob1, bob);
    }
    
    @Test
    public void findAllBookFormatEntries() throws SQLException {
        LOG.info("findAllBookFormatEntries()");

        List<BookFormat> lfd = formatControl.findBookFormatEntities();
        int totalFormats = formatControl.getBookFormatCount();
        assertEquals("Count and list size are not equal, when they shoyld be", lfd.size(), totalFormats);
    }
    
    @Test
    public void editBookFormatEntry() throws SQLException,Exception {
        LOG.info("editBookFormatEntry()");

        BookFormat bob = formatControl.findBookFormat(1);
        bob.setFileLocation("test");
        formatControl.edit(bob);
        BookFormat bob1 = formatControl.findBookFormat(1);
        assertThat(bob1.getFileLocation().equals("test"));
    }
    
    @Test
    public void deleteBookFormatEntry() throws SQLException,Exception {
        LOG.info("deleteBookFormatEntry()");

        formatControl.destroy(1);
        formatControl.destroy(321);
        List<BookFormat> lfd = formatControl.findBookFormatEntities();
        assertThat(lfd).hasSize(321);
    }
    
    @Test
    public void testCreateAds() throws IllegalStateException, Exception {
        LOG.info("testCreateAds()");
        
        Ads bob = new Ads();
        bob.setDateCreated(new Date());
        bob.setAdUrl("test.com");
        bob.setIsRemoved(false);
        bob.setLastModified(new Date());
        bob.setImageName("test.jpg");

        adsControl.create(bob);

        Ads bob1 = adsControl.findAds(bob.getAdID());

        LOG.debug("ID " + bob.getAdID());

        assertEquals("The ID's are not the same", bob1, bob);
    }
    
    @Test
    public void findAllAdsEntries() throws SQLException {
        LOG.info("findAllAdsEntries()");

        List<Ads> lfd = adsControl.findAdsEntities();
        assertEquals("Count and list size are not equal, when they shoyld be", lfd.size(), 6);
    }
    
    @Test
    public void editAdEntry() throws SQLException,Exception {
        LOG.info("editAdEntry()");

        Ads bob = adsControl.findAds(1);
        bob.setAdUrl("test.com");
        adsControl.edit(bob);
        Ads bob1 = adsControl.findAds(1);
        assertThat(bob1.getAdUrl().equals("test.com"));
    }
    
    @Test
    public void deleteAdEntry() throws SQLException,Exception {
        LOG.info("deleteAdEntry()");

        adsControl.destroy(1);
        List<Ads> lfd = adsControl.findAdsEntities();
        assertThat(lfd).hasSize(5);
    }
    
    @Test
    public void testCreateBook() throws IllegalStateException, Exception {
        LOG.info("testCreateBook()");
        
        Book bob = new Book();
        bob.setIsbn("1234123412341");
        bob.setDateEntered(new Date());
        bob.setDateOfPublication(new Date());
        bob.setDescription("This is a test book");
        bob.setLastModified(new Date());
        bob.setGenre("Fiction");
        bob.setIsRemoved(false);
        bob.setLastModified(new Date());
        bob.setListPrice(BigDecimal.valueOf(20.50));
        bob.setNumOfPages(300);
        bob.setSalePrice(BigDecimal.valueOf(20.75));
        bob.setPublisherID(1);
        bob.setTitle("Test Book");
        bob.setWholesalePrice(BigDecimal.valueOf(21.00));

        bookControl.create(bob);

        Book bob1 = bookControl.findSingleBook(bob.getIsbn());

        LOG.debug("ID " + bob.getIsbn());

        assertEquals("The ID's are not the same", bob1, bob);
    }
    
    @Test
    public void findAllBookEntries() throws SQLException {
        LOG.info("findAllBookEntries()");

        List<Book> lfd = bookControl.findBookEntities();
        assertEquals("Count and list size are not equal, when they shoyld be", lfd.size(), 103);
    }
    
    @Test
    public void editBookEntry() throws SQLException,Exception {
        LOG.info("editBookEntry()");

        Book bob = bookControl.findAnySingleBook("9780142000670");
        bob.setTitle("Test Book");
        bookControl.edit(bob);
        Book bob1 = bookControl.findAnySingleBook("9780142000670");
        assertThat(bob1.getTitle().equals("Test Book"));
    }
    
    @Test
    public void deleteBookEntry() throws SQLException,Exception {
        LOG.info("deleteBookEntry()");
        
        bookControl.destroy("9780142000670");
        List<Book> lfd = bookControl.findBookEntities();
        assertThat(lfd).hasSize(102);
    }
    
    @Test
    public void testCreateAuthors() throws IllegalStateException, Exception {
        LOG.info("testCreateAuthors()");
        
        Authors bob = new Authors();
        bob.setDateEntered(new Date());
        bob.setName("Test Author");
        bob.setLastModified(new Date());
        bob.setIsRemoved(false);
        authorsControl.create(bob);

        Authors bob1 = authorsControl.findAuthors(bob.getAuthorID());

        LOG.debug("ID " + bob.getAuthorID());

        assertEquals("The ID's are not the same", bob1, bob);
    }
    
    @Test
    public void findAllAuthorsEntries() throws SQLException {
        LOG.info("findAllAuthorsEntries()");

        List<Authors> lfd = authorsControl.findAuthorsEntities();
        int totalAuthors = authorsControl.getAuthorsCount();
        assertEquals("Count and list size are not equal, when they shoyld be", lfd.size(), totalAuthors);
    }
    
    @Test
    public void editAuthorsEntry() throws SQLException,Exception {
        LOG.info("editAuthorsEntry()");

        Authors bob = authorsControl.findAuthors(1);
        bob.setName("Test Authors");
        authorsControl.edit(bob);
        Authors bob1 = authorsControl.findAuthors(1);
        assertThat(bob1.getName().equals("Test Authors"));
    }
    
    @Test
    public void deleteAuthorsEntry() throws SQLException,Exception {
        LOG.info("deleteAuthorsEntry()");

        authorsControl.destroy(1);
        List<Authors> lfd = authorsControl.findAuthorsEntities();
        assertThat(lfd).hasSize(67);
    }
    
     */
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
