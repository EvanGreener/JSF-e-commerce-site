package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.entities.Ads;
import com.gb1w20.book_store_project.jpa_controllers.AdsJpaController;
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
    
    public String getRemovalStatus(boolean isRemoved) throws Exception {
        if (isRemoved)
        {
            return "Display Ad";
        }
        else
        {
            return "Remove Ad";
        }
    }
    
    public void validateNotNull(FacesContext context, UIComponent component, Object value) {
        String input = (String)value;
        if (input.isBlank() || input.isEmpty() || input == null)
        {
            String message = context.getApplication().evaluateExpressionGet(context, "Value must not be left blank", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
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
