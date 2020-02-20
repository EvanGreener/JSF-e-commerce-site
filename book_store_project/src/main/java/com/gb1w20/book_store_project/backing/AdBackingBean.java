package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.entities.Ads;
import com.gb1w20.book_store_project.jpa_controllers.AdsJpaController;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("adBacking")
@RequestScoped
public class AdBackingBean implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(AdBackingBean.class);

    @Inject
    private AdsJpaController adsJpaController;

    private Ads ad;

    /**
     * Ads created if it does not exist.
     *
     * @return
     */
    public Ads getAd() {
        if (ad == null) {
            ad = new Ads();
        }
        return ad;
    }

    /**
     * Save the current ad to the db
     *
     * @return
     * @throws Exception
     */
    public String createAd() throws Exception {
        adsJpaController.create(ad);
        return null;
    }
}
