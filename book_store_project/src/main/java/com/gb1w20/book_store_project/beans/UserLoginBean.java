package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.jpa_controllers.ClientsJpaController;
import java.io.Serializable;
import javax.annotation.PostConstruct;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
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
        getSignInStatus();
    }
    
    public void checkIsManager(){
        LOG.error("yoooooooooooooooooooooooooooo 1");
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
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
    
    public void getSignInStatus(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        Cookie[] userCookies = request.getCookies();
        
        if (userCookies != null && userCookies.length > 0 ) {
            for (int i = 0; i < userCookies.length; i++) {
                if (userCookies[i].getName().equals("BOOK_STORE_LOGIN")) {
                    LOG.error("true");
                    isSignedIn = true;
                    break;
                }else{
                    isSignedIn = false;
                }
            }
        }
        
    }
    
    public void signOut(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        Cookie[] userCookies = request.getCookies();
        
        if (userCookies != null && userCookies.length > 0 ) {
            for (int i = 0; i < userCookies.length; i++) {
                if (userCookies[i].getName().equals("BOOK_STORE_LOGIN")) {
                    userCookies[i].setMaxAge(0);
                    isSignedIn = false;
                    isManager = false;
                    FirstName = "";
                    LOG.error("yooooooooooooooooooo deleting "+userCookies[i].getName());
                }
            }
        }
        LOG.error("false");
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