package com.gb1w20.book_store_project.beans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
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
@RequestScoped
public class UserLoginBean implements Serializable {
    
        private final static Logger LOG = LoggerFactory.getLogger(UserLoginBean.class);

    
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
}