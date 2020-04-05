/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.arquillian.test.beans;

import com.gb1w20.book_store_project.entities.Clients;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author giancarlo
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
    
    
    public ClientTestingBean(String email, String infoEmail, boolean isManager, String firstName,
            String provinceAbbr, String clientByEmail_Email, String emailClientFName,
            String searchEmail, int managerIndicator, String searchFname, String searchLname,String searchAddress1,
            String searchAddress2, String searchCompanyName, String searchCellPhone)
    {
        this.email = email;
        this.infoEmail = infoEmail;
        this.isManager = isManager;
        this.firstName = firstName;
        this.provinceAbbr = provinceAbbr;
        this.clientByEmail_Email = clientByEmail_Email;
        this.clientByEmailFirstName = emailClientFName;
        this.managerIndicator = managerIndicator;
        this.searchEmail = searchEmail;
        this.searchFname = searchFname;
        this.searchLname = searchLname;
        this.searchAddress1 = searchAddress1;
        this.searchAddress2 = searchAddress2;
        this.searchCompanyName = searchCompanyName;
        this.searchCellPhone = searchCellPhone;
    }
}
