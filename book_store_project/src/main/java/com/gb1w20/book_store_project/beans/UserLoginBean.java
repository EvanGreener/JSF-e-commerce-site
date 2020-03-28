package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.Clients;
import com.gb1w20.book_store_project.entities.CustomerReviews;
import com.gb1w20.book_store_project.jpa_controllers.ClientsJpaController;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author
 */
@Named("UserLoginBean")
@ViewScoped
public class UserLoginBean implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(UserLoginBean.class);

    @Inject
    private ClientsJpaController clientsJpaController;

    private Boolean isSignedIn = false;
    private Boolean isManager = false;
    private String FirstName = "";

    @PostConstruct
    public void init() {
        LOG.debug("Init called!");
        getSignInStatus();
    }

    public void checkIsManager() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        Cookie[] userCookies = request.getCookies();
        LOG.info("checking if manager");

        if (userCookies != null && userCookies.length > 0) {
            for (int i = 0; i < userCookies.length; i++) {
                if (userCookies[i].getName().equals("BOOK_STORE_LOGIN") && !userCookies[i].getValue().equals("")) {
                    LOG.info("cookie info " + userCookies[i].getName() + " : " + userCookies[i].getValue());
                    Object[] clientInformation = clientsJpaController.getInfoByEmail(userCookies[i].getValue());
                    isManager = clientInformation[2] != null ? (Boolean) clientInformation[2] : false;
                    FirstName = (String) clientInformation[3];
                }
            }
        }
    }

    public void getSignInStatus() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        Cookie[] userCookies = request.getCookies();
        LOG.info("checking signin");

        if (userCookies != null && userCookies.length > 0) {
            for (int i = 0; i < userCookies.length; i++) {
                if (userCookies[i].getName().equals("BOOK_STORE_LOGIN") && !userCookies[i].getValue().equals("")) {
                    isSignedIn = true;
                    checkIsManager();
                    break;
                } else {
                    isSignedIn = false;
                }
            }
        }
    }

    public Clients getClient() {
        if (getIfSignedIn()) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
            Cookie[] userCookies = request.getCookies();
            for (int i = 0; i < userCookies.length; i++) {
                if (userCookies[i].getName().equals("BOOK_STORE_LOGIN") && !userCookies[i].getValue().equals("")) {
                    Object[] clientInformation = clientsJpaController.getInfoByEmail(userCookies[i].getValue());
                    return clientsJpaController.findClients((Integer)clientInformation[4]);
                }
            }
        }
        return new Clients();

    }

    public String signOut() throws IOException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        Cookie[] userCookies = request.getCookies();
        String page = "";
        if (userCookies != null && userCookies.length > 0) {
            for (int i = 0; i < userCookies.length; i++) {
                if (userCookies[i].getName().equals("BOOK_STORE_LOGIN") && !userCookies[i].getValue().equals("")) {
                    userCookies[i].setMaxAge(0);
                    userCookies[i].setMaxAge(0);
                    userCookies[i].setValue(""); // it is more elegant to clear the value but not necessary
                    response.addCookie(userCookies[i]);
                    LOG.debug("redirecting to " + request.getContextPath());
                    isSignedIn = false;
                    isManager = false;
                    FirstName = "";
                    response.sendRedirect(request.getContextPath());
                    page = "index.xhtml";
                }
            }
        }
        LOG.info("false");
        return page;
    }

    public Boolean getIfManager() {
        return this.isManager;
    }

    public void setManagerStatus(Boolean status) {
        this.isManager = status;
    }

    public Boolean getIfSignedIn() {
        return this.isSignedIn;
    }

    public void setSignInStatus(Boolean status) {
        this.isSignedIn = status;
    }

    public String getFirstName() {
        return this.FirstName;
    }

    public void setFirstName(String name) {
        this.FirstName = name;
    }

}
