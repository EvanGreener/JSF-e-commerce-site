package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.util.MessageLoader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This bean manages the locale. If you change the locale it sends a message to
 * redraw the page thus changing the language.
 *
 * @author Ken Fogel, Giancarlo Biasiucci
 */
@Named("locale")
@ViewScoped
public class LocaleBean implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(LocaleBean.class);
    private Locale locale;

    @PostConstruct
    public void init() {
        LOG.debug("updateLocale");
        updateLocale();
    }

    public Locale getLocale() {
        return locale;
    }

    public String getLanguage() {
        return locale.getLanguage();
    }

    /**
     * Updates the current locale, creates or updates a locale cookie containing the set language
     * @author Ken Fogel, Giancarlo Biasiucci
     * @param a
     * @param b
     * @throws IOException 
     */
    public void setLanguage(String a, String b) throws IOException {
        locale = new Locale(a, b);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        Cookie cookie = null;
        
        LOG.debug("Saving locale");
        
        Cookie[] userCookies = request.getCookies();
        if (userCookies != null && userCookies.length > 0 ) {
            for (int i = 0; i < userCookies.length; i++) {
                if (userCookies[i].getName().equals("BOOK_STORE_LOCALE")) {
                    cookie = userCookies[i];
                    break;
                }
            }
        }

        if (cookie != null) {
            cookie.setValue(a + " " + b);
        } else {
            cookie = new Cookie("BOOK_STORE_LOCALE", a + " " + b);
            cookie.setPath(request.getContextPath());
        }
        
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
        response.addCookie(cookie); 
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
    
    /**
     * Updates the locale cookie with the newly set language.
     */
    public void updateLocale(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        Cookie[] userCookies = request.getCookies();
        LOG.debug("Updating locale");

        Locale lastLocale = new Locale("en", "CA");
        
        if (userCookies != null && userCookies.length > 0) {
            for (int i = 0; i < userCookies.length; i++) {
                if (userCookies[i].getName().equals("BOOK_STORE_LOCALE") && !userCookies[i].getValue().equals("")) {
                    String[] theValues = userCookies[i].getValue().split(" ");
                    lastLocale = new Locale(theValues[0], theValues[1]);
                    break;
                } 
            }
        }
        FacesContext.getCurrentInstance().getViewRoot().setLocale(lastLocale);
        locale = lastLocale;
    }
    
    public String getLocaleString()
    {
        if (locale.equals(new Locale("en", "CA")))
        {
            return MessageLoader.getString("com.gb1w20.bundles.messages", "english", null);
        }
        else if (locale.equals(new Locale("fr", "CA")))
        {
            return MessageLoader.getString("com.gb1w20.bundles.messages", "french", null);
        }
        else
        {
            return MessageLoader.getString("com.gb1w20.bundles.messages", "english", null);
        }
    }

}
