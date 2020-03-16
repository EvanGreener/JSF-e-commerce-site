package com.gb1w20.book_store_project.beans;

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
        LOG.error("yoooooooooooooooooooooooooooo 1");
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        Cookie[] userCookies = request.getCookies();

        if (userCookies != null && userCookies.length > 0) {
            for (int i = 0; i < userCookies.length; i++) {
                if (userCookies[i].getName().equals("BOOK_STORE_LOGIN") && !userCookies[i].getValue().equals("")) {
                    LOG.error("cookie info " + userCookies[i].getName() + " : " + userCookies[i].getValue());
                    Object[] clientInformation = clientsJpaController.getInfoByEmail(userCookies[i].getValue());
                    isManager = clientInformation[2] != null;
                    FirstName = (String) clientInformation[3];
                }
            }
        }
        LOG.error("yoooooooooooooooooooooooooooo 4");
    }

    public void getSignInStatus() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        Cookie[] userCookies = request.getCookies();
        LOG.error("checking signin");

        if (userCookies != null && userCookies.length > 0) {
            for (int i = 0; i < userCookies.length; i++) {
                if (userCookies[i].getName().equals("BOOK_STORE_LOGIN") && !userCookies[i].getValue().equals("")) {
                    LOG.error("true");
                    isSignedIn = true;
                    checkIsManager();
                    break;
                } else {
                    isSignedIn = false;
                }
            }
        }
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
                    LOG.error("yooooooooooooooooooo deleting " + userCookies[i].getName());
                    response.sendRedirect(request.getContextPath());
                    page = "index.xhtml";
                }
            }
        }
        LOG.error("false");
        return page;
    }

    public Boolean getIfManager() {
        LOG.error("yo this shit is manager " + this.isManager);
        return this.isManager;
    }

    public void setManagerStatus(Boolean status) {
        this.isManager = status;
    }

    public Boolean getIfSignedIn() {
        LOG.error("yo this shit is signedin " + this.isSignedIn);
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
