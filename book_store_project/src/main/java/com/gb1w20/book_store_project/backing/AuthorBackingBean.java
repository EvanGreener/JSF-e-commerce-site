package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.entities.Authors;
import com.gb1w20.book_store_project.jpa_controllers.AuthorsJpaController;
import com.gb1w20.book_store_project.util.MessageLoader;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("authorBacking")
@RequestScoped
public class AuthorBackingBean implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(AuthorBackingBean.class);

    @Inject
    private AuthorsJpaController authorsJpaController;

    private String name;
    private Authors author;
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String newName)
    {
        name = newName;
    }

    /**
     * Authors created if it does not exist.
     *
     * @return
     */
    public Authors getAuthor() {
        if (author == null) {
            author = new Authors();
        }
        return author;
    }

    /**
     * Save the current author to the db
     * 
     * @return
     * @throws Exception
     */
    public String createAuthor() throws Exception {
        author.setDateEntered(new Date());
        author.setIsRemoved(false);
        author.setLastModified(new Date());
        authorsJpaController.create(author);
        FacesContext.getCurrentInstance().getExternalContext().redirect("managerInventory.xhtml");
        return null;
    }
    
    /**
     * Validation method ensuring that the field in the "Add Author" modal is not
     * left null, nor that it contains the name of an existing author
     *
     * @param context
     * @param component
     * @param value
     * By: Giancarlo Biasiucci
     */
    public void validateUniqueAndValidAuthor(FacesContext context, UIComponent component, Object value) {
        String input = (String)value;
        if (input.isBlank() || input.isEmpty() || input == null)
        {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "valueNotNull", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        if (authorsJpaController.getAuthorNames().contains(input))
        {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "authorExists", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
