/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.Ads;
import com.gb1w20.book_store_project.jpa_controllers.AdsJpaController;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Named("adsBean")
@SessionScoped
public class AdsBean implements Serializable {
    
     @Inject
    private AdsJpaController adCtrlr;
    
    private Ads randomAd;
     
     private final static Logger LOG = LoggerFactory.getLogger(AdsBean.class);
     
     @PostConstruct
    public void init() {
        LOG.debug("Init called!");

    }
    public Ads getRandomAd(){
        this.randomAd=adCtrlr.getRandomAd();
        return this.randomAd;
    }
    public void setRandomAd(Ads ad){
        this.randomAd=ad;
    }
}
