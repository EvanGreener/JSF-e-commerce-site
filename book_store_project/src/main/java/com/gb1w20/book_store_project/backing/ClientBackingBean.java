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
import java.util.regex.Pattern;
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
    private String registerPassword;
    private String registerPasswordConfirm;
    private List<SelectItem> provinces = new ArrayList<SelectItem>();
    
    private String loginEmail;
    private String loginPassword;
    private String message = "You are not logged in";

    /**
     * Clients created if it does not exist.
     * registerPassword
     * @return
     */
    public Clients getClient() {
        if (client == null) {
            client = new Clients();
        }
        return client;
    }
    
    public String getRegisterPassword() {
        return registerPassword;
    }

    public void setRegisterPassword(String registerPassword) {
        this.registerPassword = registerPassword;
    }
    
    public String getRegisterPasswordConfirm() {
        return registerPasswordConfirm;
    }

    public void setRegisterPasswordConfirm(String registerPasswordConfirm) {
        this.registerPasswordConfirm = registerPasswordConfirm;
    }
    
    public String getMessage()
    {
        return this.message;
    }
    
    public void setMessage(String message)
    {
        this.message = message;
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
        byte[] hashEmail = md.digest(client.getEmail().getBytes(StandardCharsets.UTF_8));
        byte[] salt = new byte[20];
        for (int i = 0;i < 20;i++)
        {
            salt[i] = hashEmail[i];
        }
        md.update(salt);
        byte[] hashedPassword = md.digest(registerPassword.getBytes(StandardCharsets.UTF_8));
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
    
    public void validateUniqueAndValidEmail(FacesContext context, UIComponent component, Object value) {
        String email = (String)value;
        UIInput emailInput = (UIInput)component.findComponent("email");
        boolean validEmail = Pattern.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)", email);
        if (!validEmail) {
            String message = context.getApplication().evaluateExpressionGet(context, "Invalid email format (example of correct format: alberto@gmail.com)", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            emailInput.resetValue();
            throw new ValidatorException(msg);
        }
        List<String> emailsByQuery = clientsJpaController.getEmailsByEmail(email);
        if (emailsByQuery.size() >= 1) {
            String message = context.getApplication().evaluateExpressionGet(context, "Email already exists in database", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            emailInput.resetValue();
            throw new ValidatorException(msg);
        }
    }
    
    public void validateCorrectPassword(FacesContext context, UIComponent component, Object value) throws Exception {
        String password = (String)value;
        UIInput emailInput = (UIInput)component.findComponent("email");
        String email = (String)emailInput.getLocalValue();
        if (clientsJpaController.getEmailsByEmail(email).isEmpty())
        {
            String message = context.getApplication().evaluateExpressionGet(context, "User with this email does not exist", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
        Object[] userInfo = clientsJpaController.getInfoByEmail(email);
        if (loginTest(email, password) == false) {
            String message = context.getApplication().evaluateExpressionGet(context, "Incorrect password", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(msg);
        }
    }
    
    public void validateEmailExists(FacesContext context, UIComponent component, Object value) throws Exception {
        String email = (String)value;
        UIInput emailInput = (UIInput)component.findComponent("email");
        List<String> emailsByQuery = clientsJpaController.getEmailsByEmail(email);
        if (emailsByQuery.isEmpty()) {
            String message = context.getApplication().evaluateExpressionGet(context, "User with this email does not exist", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            emailInput.resetValue();
            throw new ValidatorException(msg);
        }
    }
    
    public String login() throws Exception
    {
        Object[] info = clientsJpaController.getInfoByEmail(loginEmail);
        String email = (String)info[0];
        String dbPasswordHash = (String)info[1];
        
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashEmail = md.digest(email.getBytes(StandardCharsets.UTF_8));
        byte[] salt = new byte[20];
        for (int i = 0;i < 20;i++)
        {
            salt[i] = hashEmail[i];
        }
        md.update(salt);
        byte[] hashedPassword = md.digest(loginPassword.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashedPassword) {
            sb.append(String.format("%02x", b));
        }
        String loginPasswordHash = sb.toString();

        if (dbPasswordHash.equals(loginPasswordHash))
        {
            this.message = "You are logged in, " + email;
            return "index.xhtml";
        }
        else
        {
            return "signIn.xhtml";
        }
    }
    
    public void validateHomePhone(FacesContext context, UIComponent component, Object value)
    {
        String number = (String)value;
        UIInput homePhoneInput = (UIInput)component.findComponent("homePhone");
        try
        {
            Integer.parseInt(number);
        }
        catch(NumberFormatException nfe)
        {
            String message = context.getApplication().evaluateExpressionGet(context, "Invalid home phone: contains non-numeric characters", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            homePhoneInput.resetValue();
            throw new ValidatorException(msg);
        }
        if (number.toCharArray().length != 10)
        {
            String message = context.getApplication().evaluateExpressionGet(context, "Invalid home phone: not 10 digits long", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            homePhoneInput.resetValue();
            throw new ValidatorException(msg);
        }
    }
    
    public void validateCellPhone(FacesContext context, UIComponent component, Object value)
    {
        String number = (String)value;
        UIInput cellPhoneInput = (UIInput)component.findComponent("cellPhone");
        try
        {
            Integer.parseInt(number);
        }
        catch(NumberFormatException nfe)
        {
            String message = context.getApplication().evaluateExpressionGet(context, "Invalid cell phone: contains non-numeric characters", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            cellPhoneInput.resetValue();
            throw new ValidatorException(msg);
        }
        if (number.toCharArray().length != 10)
        {
            String message = context.getApplication().evaluateExpressionGet(context, "Invalid cell phone: not 10 digits long", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            cellPhoneInput.resetValue();
            throw new ValidatorException(msg);
        }
    }
    
    public void validatePostalCode(FacesContext context, UIComponent component, Object value)
    {
        String postalCode = (String)value;
        UIInput postalCodeInput = (UIInput)component.findComponent("postalCode");
        boolean validPostalCode = Pattern.matches("[a-zA-Z][0-9][a-zA-Z][0-9][a-zA-Z][0-9]", postalCode);
        if (!validPostalCode)
        {
            String message = context.getApplication().evaluateExpressionGet(context, "Incorrect postal code format (correct format: A1A1A1)", String.class);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            postalCodeInput.resetValue();
            throw new ValidatorException(msg);
        }
    }
    
    public boolean loginTest(String loginEmail, String password) throws Exception
    {
        Object[] info = clientsJpaController.getInfoByEmail(loginEmail);
        String email = (String)info[0];
        String dbPasswordHash = (String)info[1];
        
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashEmail = md.digest(email.getBytes(StandardCharsets.UTF_8));
        byte[] salt = new byte[20];
        for (int i = 0;i < 20;i++)
        {
            salt[i] = hashEmail[i];
        }
        md.update(salt);
        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashedPassword) {
            sb.append(String.format("%02x", b));
        }
        String loginPasswordHash = sb.toString();

        if (dbPasswordHash.equals(loginPasswordHash))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
