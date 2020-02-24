package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.entities.Clients;
import com.gb1w20.book_store_project.jpa_controllers.ClientsJpaController;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("clientBacking")
@RequestScoped
public class ClientBackingBean implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(ClientBackingBean.class);

    @Inject
    private ClientsJpaController clientsJpaController;

    private Clients client;
    private String password;
    private String passwordConfirm;
    private List<SelectItem> provinces = new ArrayList<SelectItem>();
    
    private String loginEmail;
    private String loginPassword;

    /**
     * Clients created if it does not exist.
     *
     * @return
     */
    public Clients getClient() {
        if (client == null) {
            client = new Clients();
        }
        return client;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
    
    public List<SelectItem> getProvinces()
    {
        if (provinces.isEmpty())
        {
            provinces.add(new SelectItem("AB", "Alberta"));
            provinces.add(new SelectItem("BC", "British Colombia"));
            provinces.add(new SelectItem("MB", "Manitoba"));
            provinces.add(new SelectItem("NB", "New Brunswick"));
            provinces.add(new SelectItem("NL", "Newfoundland"));
            provinces.add(new SelectItem("NT", "Northwest Territories"));
            provinces.add(new SelectItem("NS", "Nova Scotia"));
            provinces.add(new SelectItem("NU", "Nunavut"));
            provinces.add(new SelectItem("ON", "Ontario"));
            provinces.add(new SelectItem("PE", "Prince Edward Island"));
            provinces.add(new SelectItem("QC", "Quebec"));
            provinces.add(new SelectItem("SK", "Saskatchewan"));
            provinces.add(new SelectItem("YT", "Yukon"));
        }
        return provinces;
    }
    
    public void setProvinces(List<SelectItem> provinces)
    {
        this.provinces = provinces;
    }
    
    public String getLoginEmail() {
        return loginEmail;
    }

    public void setLoginEmail(String loginEmail) {
        this.loginEmail = loginEmail;
    }
    
    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    /**
     * Save the current client to the db
     *
     * @return
     * @throws Exception
     */
    public String createClient() throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        SecureRandom random = new SecureRandom();
        byte[] hashEmail = md.digest(client.getEmail().getBytes(StandardCharsets.UTF_8));
        byte[] salt = new byte[20];
        for (int i = 0;i < 20;i++)
        {
            salt[i] = hashEmail[i];
        }
        random.nextBytes(salt);
        md.update(salt);
        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashedPassword) {
            sb.append(String.format("%02x", b));
        }
        client.setHashedPassword(sb.toString());
        client.setLastModified(new Date());
        client.setDateEntered(new Date());
        client.setIsRemoved(false);
        client.setIsManager(false);
        clientsJpaController.create(client);
        return "index.xhtml";
    }
    
    public void validatePassword(FacesContext context, UIComponent component, Object value) {
        String confirmPassword = (String)value;
        UIInput passwordInput = (UIInput)component.findComponent("password");
        String password = (String)passwordInput.getLocalValue();
        if (password == null || confirmPassword == null || !password.equals(confirmPassword)) {
            String message = context.getApplication().evaluateExpressionGet(context, "Passwords do not match", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            passwordInput.resetValue();
            throw new ValidatorException(msg);
        }
    }
    
    public String login() throws Exception
    {
        Object[] info = clientsJpaController.getInfoByEmail(loginEmail);
        String email = (String)info[0];
        String dbPasswordHash = (String)info[1];
        
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        SecureRandom random = new SecureRandom();
        byte[] hashEmail = md.digest(email.getBytes(StandardCharsets.UTF_8));
        byte[] salt = new byte[20];
        for (int i = 0;i < 20;i++)
        {
            salt[i] = hashEmail[i];
        }
        random.nextBytes(salt);
        md.update(salt);
        byte[] hashedPassword = md.digest(loginPassword.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashedPassword) {
            sb.append(String.format("%02x", b));
        }
        String loginPasswordHash = sb.toString();

        if (dbPasswordHash.equals(loginPasswordHash))
        {
            return "index.xhtml";
        }
        else
        {
            return null;
        }
    }
}
