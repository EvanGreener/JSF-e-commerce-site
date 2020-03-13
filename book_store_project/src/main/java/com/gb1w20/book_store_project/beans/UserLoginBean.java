package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.jpa_controllers.ClientsJpaController;
import java.io.Serializable;
import javax.annotation.PostConstruct;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author
 */
@Named("UserLoginBean")
@SessionScoped
public class UserLoginBean implements Serializable {
    
     private final static Logger LOG = LoggerFactory.getLogger(UserLoginBean.class);
     
    @Inject
    private ClientsJpaController clientsJpaController;     
    
    private Boolean isSignedIn;
    private Boolean isManager;
    private String FirstName;
    
     @PostConstruct
    public void init() {
        LOG.debug("Init called!");
        checkIsManager();
        isSignedIn = getSignInStatus();
    }
    
    public void checkIsManager(){
        String cookieEmail;
                LOG.error("yoooooooooooooooooooooooooooo 1");

        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        Cookie cookie = null;
        
        Cookie[] userCookies = request.getCookies();
        if (userCookies != null && userCookies.length > 0 ) {
            for (int i = 0; i < userCookies.length; i++) {
                if (userCookies[i].getName().equals("BOOK_STORE_LOGIN")) {
                    Object[] clientInformation = clientsJpaController.getInfoByEmail(userCookies[i].getValue());
                    isManager = (Boolean) clientInformation[2];
                    FirstName = (String) clientInformation[3];
                }
            }
        }
        LOG.error("yoooooooooooooooooooooooooooo 4");
    }
    
    public Boolean getSignInStatus(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        Cookie cookie = null;
        
        Cookie[] userCookies = request.getCookies();
        if (userCookies != null && userCookies.length > 0 ) {
            for (int i = 0; i < userCookies.length; i++) {
                if (userCookies[i].getName().equals("BOOK_STORE_LOGIN")) {
                    LOG.error("true");
                    return true;
                }
            }
        }
        LOG.error("false");
        return false;
    }
    
    public Boolean getIfManager() {
        return this.isManager;
    }

    public void setSurveyChoice(Boolean status) {
        this.isManager = status;
    }
        public String getFirstName() {
        return this.FirstName;
    }

    public void setFirstName(String name) {
        this.FirstName = name;
    }

}