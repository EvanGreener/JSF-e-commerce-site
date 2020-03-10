package com.gb1w20.book_store_project.beans;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.ManagedProperty;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author 1733408
 */

@Named("modalBean")
@SessionScoped
public class OrderEditModalBean implements Serializable {
    
    private final static Logger LOG = LoggerFactory.getLogger(OrderEditModalBean.class);
    
    private String email;
    
    public String getEmail()
    {
        LOG.debug(email);
        return email;
    }
    
    public void setEmail(String newValue)
    {
        this.email = newValue;
    }
    
}
