/*
 *All test beans belong to this package
 */
package com.gb1w20.arquillian.test.beans;

import com.gb1w20.book_store_project.entities.Clients;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bean used only for the purpose of performing arquillian tests on the client
 * controller class
 *
 * @author giancarlo,Shruti pareek
 */
public class ClientTestingBean {

    private final static Logger LOG = LoggerFactory.getLogger(ClientTestingBean.class);

    public String email;
    //getInfoByEmail
    public String infoEmail;
    public boolean isManager;
    public String firstName;
    public String provinceAbbr;
    //findClientByEmail
    public String clientByEmail_Email;
    public String clientByEmailFirstName;
    //searchClients
    public String searchEmail;
    public int managerIndicator;
    public String searchFname;
    public String searchLname;
    public String searchAddress1;
    public String searchAddress2;
    public String searchCompanyName;
    public String searchCellPhone;

    //testFindClientByEmail
    public Clients expectedClient;

    //testSearchClients
    public String expectedQuery;
    public String expectedSearchBy;

    /**
     * Constructor takes all necessary input needed for testing
     *
     * @param email
     * @param infoEmail
     * @param isManager
     * @param firstName
     * @param provinceAbbr
     * @param clientByEmail_Email
     * @param clientByEmailFirstName
     * @param searchEmail
     * @param managerIndicator
     * @param searchFname
     * @param searchLname
     * @param searchAddress1
     * @param searchAddress2
     * @param searchCompanyName
     * @param searchCellPhone
     * @param expectedClient
     * @param expectedQuery
     * @param expectedSearchBy
     */
    public ClientTestingBean(String email, String infoEmail, boolean isManager, String firstName, String provinceAbbr, String clientByEmail_Email, String clientByEmailFirstName, String searchEmail, int managerIndicator, String searchFname, String searchLname, String searchAddress1, String searchAddress2, String searchCompanyName, String searchCellPhone, Clients expectedClient, String expectedQuery, String expectedSearchBy) {
        LOG.debug("ClientTestingBean");
        this.email = email;
        this.infoEmail = infoEmail;
        this.isManager = isManager;
        this.firstName = firstName;
        this.provinceAbbr = provinceAbbr;
        this.clientByEmail_Email = clientByEmail_Email;
        this.clientByEmailFirstName = clientByEmailFirstName;
        this.searchEmail = searchEmail;
        this.managerIndicator = managerIndicator;
        this.searchFname = searchFname;
        this.searchLname = searchLname;
        this.searchAddress1 = searchAddress1;
        this.searchAddress2 = searchAddress2;
        this.searchCompanyName = searchCompanyName;
        this.searchCellPhone = searchCellPhone;
        this.expectedClient = expectedClient;
        this.expectedQuery = expectedQuery;
        this.expectedSearchBy = expectedSearchBy;
    }

}
