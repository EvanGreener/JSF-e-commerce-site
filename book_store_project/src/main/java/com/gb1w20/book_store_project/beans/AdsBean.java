/*
 * This package stores all beans used to access controller classses
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

/**
 * Bean that allows retrieval and modification of a randomly generated
 * advertisement used in client frontdoor/ index page
 *
 * @author Shruti Pareek
 */
@Named("adsBean")
@SessionScoped
public class AdsBean implements Serializable {

    @Inject
    private AdsJpaController adCtrlr;

    private Ads randomAd;

    private final static Logger LOG = LoggerFactory.getLogger(AdsBean.class);

    @PostConstruct
    /**
     * method for initializing when bean called
     *
     * @return void
     */
    public void init() {
        LOG.debug("Init called!");

    }

    /**
     * method for getting random ad
     *
     * @return Ads
     */
    public Ads getRandomAd() {
        LOG.debug("getRandomAd");
        this.randomAd = adCtrlr.getRandomAd();
        return this.randomAd;
    }

    /**
     * method setting random ad
     *
     * @param ad
     */
    public void setRandomAd(Ads ad) {
        LOG.debug("setRandomAd");
        this.randomAd = ad;
    }
}
