/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.Authors;
import com.gb1w20.book_store_project.jpa_controllers.AuthorsJpaController;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author giancarlo
 */
@Named("editAuthor")
@SessionScoped
public class EditAuthorBean implements Serializable {
    
    @Inject
    private AuthorsJpaController authorControl;
    
    private final static Logger LOG = LoggerFactory.getLogger(EditAuthorBean.class);
    private Authors currentAuthor;
    private String newName;
    
    @PostConstruct
    public void init()
    {
        LOG.debug("init called");
    }
    
    public Authors getCurrentAuthor()
    {
        return currentAuthor;
    }
    
    public String getNewName()
    {
        return newName;
    }
    
    public void setNewName(String newValue)
    {
        newName = newValue;
    }
    
    public void authChangeMethod(String newAuthName) {
        LOG.debug("new auth: " + newAuthName);
        currentAuthor = authorControl.getAuthorByName(newAuthName);
        LOG.debug("new auth: " + currentAuthor.getAuthorID());
    }
    
    public void onEdit()
    {
        LOG.debug("onEdit called: " + currentAuthor.getAuthorID());
        currentAuthor = authorControl.findAuthors(currentAuthor.getAuthorID());
        newName = currentAuthor.getName();
    }
    
    public String onSubmitEdit() throws Exception
    {
        currentAuthor.setName(newName);
        currentAuthor.setLastModified(new Date());
        authorControl.edit(currentAuthor);
        FacesContext.getCurrentInstance().getExternalContext().redirect("managerInventory.xhtml");
        return null;
    }
}
