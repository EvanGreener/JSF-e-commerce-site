package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.entities.Ads;
import com.gb1w20.book_store_project.jpa_controllers.AdsJpaController;
import com.gb1w20.book_store_project.util.MessageLoader;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Backing bean for the ad entity
 * @author Giancarlo Biasiucci
 * @version April 4, 2020
 */
@Named("adBacking")
@RequestScoped
public class AdBackingBean implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(AdBackingBean.class);

    @Inject
    private AdsJpaController adsJpaController;

    private Ads ad;

    /**
     * If the ad managed by the bean is null, it will be created from scratch to avoid a NullPointerException.
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
     * Creates the ad based on the data entered in the corresponding modal and saves it to the database.
     *
     * @return
     * @throws Exception
     */
    public String createAd() throws Exception {
        LOG.debug("createAd called");
        LOG.debug(ad == null ? "Ad is null" : "Ad is not null");
        if (ad != null && !ad.getImageName().isBlank() && !ad.getImageName().isEmpty() && !ad.getAdUrl().isBlank() && !ad.getAdUrl().isEmpty() ) {
        ad.setLastModified(new Date());
        ad.setDateCreated(new Date());
        ad.setIsRemoved(true);
        adsJpaController.create(ad);
        }
        FacesContext.getCurrentInstance().getExternalContext().redirect("managerAds.xhtml");
        return "managerAds.xhtml";
    }
    
    /**
     * Marks an ad as removed (changes removal status to true)
     * @param order
     * @return
     * @throws Exception 
     */
    public String removeAd(Ads ad) throws Exception {
        LOG.debug("Reached the remove method");
        ad.setIsRemoved(true);
        LOG.debug("Reached the setRemoved method");
        ad.setLastModified(new Date());
        LOG.debug("Reached the setModified method");
        adsJpaController.edit(ad);
        LOG.debug("Reached the edit method");
        return null;
    }
    
    /**
     * Marks an order as not removed (changes removal status to false)
     * @param order
     * @return
     * @throws Exception 
     */
    public String addAd(Ads ad) throws Exception {
        LOG.debug("Reached the add method");
        ad.setIsRemoved(false);
        LOG.debug("Reached the setRemoved method");
        ad.setLastModified(new Date());
        LOG.debug("Reached the lastModified method");
        adsJpaController.edit(ad);
        LOG.debug("Reached the edit method");
        return null;
    }
    
    /**
     * If 2 ads are already enabled to display on the front page, all other ads will be disabled and be
     * unable to be displayed. Ensures that at least one ad is enabled at all times. In short, this method
     * guarantees that 1 or 2 ads are enabled at all times.
     * @param ad
     * @return 
     */
    public boolean decideDisabled(Ads ad)
    {   
        List<Ads> allEnabled = adsJpaController.getAllEnabledAds();
        LOG.debug(allEnabled.size() + "");
        boolean result = true;
        if (ad.getIsRemoved())
        {
            if (allEnabled.size() < 2)
            {
                result = false;
            }
        }
        else
        {
            if (allEnabled.size() != 1)
            {
                result = false;
            }
        }
        return result;
    }
    
    /**
     * Determines whether an ad should be added or removed based on its current removal status
     * whenever the corresponding link in the managerial ad page is clicked
     * (changed to other state, if true than changed to false and vice versa)
     * @param ad
     * @return
     * @throws Exception 
     */
    public String addOrRemoveAd(Ads ad) throws Exception
    {
        if (ad.getIsRemoved())
        {
            addAd(ad);
        }
        else
        {
            removeAd(ad);
        }
        FacesContext.getCurrentInstance().getExternalContext().redirect("managerAds.xhtml");
        return null;
    }
    
    /**
     * Returns a String indicating what will occur when the corresponding link in the managerial
     * ad page is clicked
     * @param isRemoved
     * @return
     * @throws Exception 
     */
    public String getRemovalStatus(boolean isRemoved) throws Exception {
        if (isRemoved)
        {
            return MessageLoader.getString("com.gb1w20.bundles.messages", "displayAd", null);
        }
        else
        {
            return MessageLoader.getString("com.gb1w20.bundles.messages", "removeAd", null);
        }
    }
    
    /**
     * Validation method ensuring that the fields in the "Add Ad" modal are not left blank or empty
     * @param context
     * @param component
     * @param value 
     */
    public void validateNotNull(FacesContext context, UIComponent component, Object value) {
        String input = (String)value;
        if (input.isBlank() || input.isEmpty() || input == null)
        {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "valueNotNull", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
    
    public void onStatusEdit()
    {
        LOG.debug("Status edit called");
    }
    
    public void onCreate(){
        LOG.debug("onCreate called!");
    }
    
}
