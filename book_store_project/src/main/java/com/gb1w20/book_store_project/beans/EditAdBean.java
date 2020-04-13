/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.Ads;
import com.gb1w20.book_store_project.jpa_controllers.AdsJpaController;
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
 * Bean for editing an existing ad's information
 * @author Giancarlo Biasiucci & Saad Khan
 * @version April 4, 2020
 */

@Named("editAd")
@SessionScoped
public class EditAdBean implements Serializable {
    
    @Inject
    private AdsJpaController adsCtrl;
    
    private final static Logger LOG = LoggerFactory.getLogger(EditAdBean.class);
    private Ads currentAd;
    private String newImage;
    private String newUrl;
    
    @PostConstruct
    public void init()
    {
        LOG.debug("init called");
    }
    
    public Ads getCurrentAd()
    {
        return currentAd;
    }
    
    public String getNewImage()
    {
        return newImage;
    }
    
    public void setNewImage(String newValue)
    {
        newImage = newValue;
    }
    
    public String getNewUrl()
    {
        return newUrl;
    }
    
    public void setNewUrl(String newValue)
    {
        newUrl = newValue;
    }
    
    /**
     * Saves the current ad information to be displayed in the "Edit Ad" modal
     * when the corresponding button is clicked
     * @param id 
     * By: Giancarlo Biasiucci & Saad Khan
     */
    public void onEdit(int id)
    {
        LOG.debug("onEdit called");
        LOG.debug("ID we are looking for: " + id);
        currentAd = adsCtrl.findAds(id);
        newImage = currentAd.getImageName();
        newUrl = currentAd.getAdUrl();
        LOG.debug("Current ID: " + currentAd.getAdID());
        LOG.debug("Current image: " + currentAd.getImageName());
        LOG.debug("Current URL: " + currentAd.getAdUrl());
        LOG.debug("Current image (var): " + newImage);
        LOG.debug("Current URL (var): " + newUrl);
    }
    
    /**
     * Edits the existing ad information with what is present in the fields in the "Edit Ad" modal
     * and updates the entry in the database
     * @return
     * @throws Exception 
     * By: Giancarlo Biasiucci & Saad Khan
     */
    public String onSubmitEdit() throws Exception
    {
        LOG.debug("onSubmitEdit called");
        currentAd.setImageName(newImage);
        currentAd.setAdUrl(newUrl);
        currentAd.setLastModified(new Date());
        currentAd.setDateCreated(new Date());
        adsCtrl.edit(currentAd);
        FacesContext.getCurrentInstance().getExternalContext().redirect("managerAds.xhtml");
        return null;
    } 
}
