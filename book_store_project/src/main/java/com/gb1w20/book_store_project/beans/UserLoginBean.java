package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.Clients;
import com.gb1w20.book_store_project.jpa_controllers.ClientsJpaController;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Saad Khan
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
    private String email = "";
    private String province = "QC";

    @PostConstruct
    public void init() {
        LOG.debug("Init called!");
        getSignInStatus();
    }

    /**
     * check status of sign in status of user
     *
     * @author Saad Khan
     */
    public void getSignInStatus() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        Cookie[] userCookies = request.getCookies();
        LOG.info("checking signin");

        if (userCookies != null && userCookies.length > 0) {
            for (int i = 0; i < userCookies.length; i++) {
                try {
                    if (userCookies[i].getName().equals("BOOK_STORE_LOGIN") && !userCookies[i].getValue().equals("")) {
                        LOG.info("cookie info " + userCookies[i].getName() + " : " + userCookies[i].getValue());
                        Object[] clientInformation = clientsJpaController.getInfoByEmail(userCookies[i].getValue());
                        email = (String) clientInformation[0];
                        isManager = clientInformation[2] != null ? (Boolean) clientInformation[2] : false;
                        FirstName = (String) clientInformation[3];
                        province = (String) clientInformation[5];
                        isSignedIn = true;
                        break;
                    } else {
                        isSignedIn = false;
                    }
                } catch (NoResultException ex) {
                    isSignedIn = false;
                }
            }
        }
    }

    /**
     * Gets a client from cookie based on their email
     *
     * @author Shruti Pareek
     * @return
     */
    public Clients getClient() {
        LOG.debug("getClient");
        if (getIfSignedIn()) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
            Cookie[] userCookies = request.getCookies();
            for (int i = 0; i < userCookies.length; i++) {
                if (userCookies[i].getName().equals("BOOK_STORE_LOGIN") && !userCookies[i].getValue().equals("")) {
                    Object[] clientInformation = clientsJpaController.getInfoByEmail(userCookies[i].getValue());
                    return clientsJpaController.findClients((Integer) clientInformation[4]);
                }
            }
        }
        return new Clients();

    }

    /**
     * sign out user by deleting cookie
     *
     * @Saad Khan
     * @return page to send user
     * @throws IOException
     */
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String newValue) {
        this.email = newValue;
    }

    public String getProvince() {
        LOG.info(this.province);
        return this.province;
    }
}
