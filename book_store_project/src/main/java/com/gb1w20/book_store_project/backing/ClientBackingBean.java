package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.entities.Clients;
import com.gb1w20.book_store_project.util.MessageLoader;
import com.gb1w20.book_store_project.jpa_controllers.ClientsJpaController;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
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
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Backing bean for the client entity
 * @author Giancarlo Biasiucci, Saad Khan
 * @version April 4, 2020
 */
@Named("clientBacking")
@RequestScoped
public class ClientBackingBean implements Serializable {

    //Every class should have a logger
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
    
    //The list contains every province registered in our database.
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
     * Save the current client to the database
     * @author Giancarlo Biasiucci
     * @return The URI for the login page, which the user will be redirected to after successful registration
     * & client creation
     * @throws Exception
     */
    public String createClient() throws Exception {
        //Since the manner in which the password is being hashed (and de-hashed) is partially revolved
        //around their email, a client's email cannot be changed
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
        //Users cannot register to be managers, since that is the roles that we (the developers) will play.
        client.setIsManager(false);
        clientsJpaController.create(client);
        //Redirection is necessary to avoid form resubmittal on page reload
        FacesContext.getCurrentInstance().getExternalContext().redirect("signIn.xhtml");
        return "signIn.xhtml";
    }
    
    /**
     * General form validation method to ensure that a field is not left empty or blank (not just whitespace)
     * @author Giancarlo Biasiucci
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
    
    /**
     * Password validation method, makes sure that both entered passwords on the registration form
     * are equal
     * @author Giancarlo Biasiucci
     * @param context
     * @param component
     * @param value 
     */
    public void validatePassword(FacesContext context, UIComponent component, Object value) {
        String confirmPassword = (String)value;
        UIInput passwordInput = (UIInput)component.findComponent("password");
        String password = (String)passwordInput.getLocalValue();
        if (password == null || confirmPassword == null || !password.equals(confirmPassword)) {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "passMatchBad", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
    
    /**
     * Email validation method, validates that a) the email does not exist in the database and also that
     * b) the email is of a correct format (eg. albertofish@gmail.com) - for registration
     * @author Giancarlo Biasiucci
     * @param context
     * @param component
     * @param value 
     */
    public void validateUniqueAndValidEmail(FacesContext context, UIComponent component, Object value) {
        String email = (String)value;
        UIInput emailInput = (UIInput)component.findComponent("email");
        if (email.isBlank() || email.isEmpty() || email == null) {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "valueNotNull", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        boolean validEmail = Pattern.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)", email);
        if (!validEmail) {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "invalidEmail", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        List<String> emailsByQuery = clientsJpaController.getEmailsByEmail(email);
        if (emailsByQuery.size() >= 1) {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "emailExists", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
    
    /**
     * Validates that the password entered in the login form is in fact correct for the entered email
     * @author Giancarlo Biasiucci
     * @param context
     * @param component
     * @param value
     * @throws Exception 
     */
    public void validateCorrectPassword(FacesContext context, UIComponent component, Object value) throws Exception {
        String password = (String)value;
        if (password == null) {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "rePasswordMsg", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        UIInput emailInput = (UIInput)component.findComponent("email");
        String email = (String)emailInput.getLocalValue();
        if (clientsJpaController.getEmailsByEmail(email).isEmpty())
        {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "noUserExists", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        Object[] userInfo = clientsJpaController.getInfoByEmail(email);
        if (loginTest(email, password) == false) {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "badPassword", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
    
    /**
     * Login form email validation - verifies that email (and user) exists in database.
     * @author Giancarlo Biasiucci
     * @param context
     * @param component
     * @param value
     * @throws Exception 
     */
    public void validateEmailExists(FacesContext context, UIComponent component, Object value) throws Exception {
        String email = (String)value;
        if (email == null) {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "valueNotNull", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        List<String> emailsByQuery = clientsJpaController.getEmailsByEmail(email);
        if (emailsByQuery.isEmpty()) {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "noUserExists", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
    
    /**
     * Logs the user in if their credentials are correct, and creates the login cookie.
     * @author Giancarlo Biasiucci, Saad Khan
     * @return
     * @throws Exception 
     */
    public String login() throws Exception
    {
        Object[] info = clientsJpaController.getInfoByEmail(loginEmail);
        String email = (String)info[0];
        String dbPasswordHash = (String)info[1];
        Boolean isManager = (Boolean)info[2];
        
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
            createLoginCookie(email);

            this.message = "You are logged in, " + email;
            return isManager ? "managerFront.xhtml?faces-redirect=true" : "index.xhtml?faces-redirect=true";
        }
        else
        {
            return "signIn.xhtml";
        }
    }
    
    /**
     * Logs the user in, only difference from previous login method is that it redirects the user
     * back to the cart page after login.
     * @author Giancarlo Biasiucci, Saad Khan
     * @return
     * @throws Exception 
     */
    public String loginForCart() throws Exception
    {
        Object[] info = clientsJpaController.getInfoByEmail(loginEmail);
        String email = (String)info[0];
        String dbPasswordHash = (String)info[1];
        Boolean isManager = (Boolean)info[2];
        
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
            createLoginCookie(email);

            this.message = "You are logged in, " + email;
            return "cart.xhtml?faces-redirect=true";
        }
        else
        {
            return "cart.xhtml";
        }
    }
    
    /**
     * Registration form validation method for home phone, same as for cell phone,
     * verify that it is in fact a legitemate 10-digit phone number.
     * @author Giancarlo Biasiucci
     * @param context
     * @param component
     * @param value 
     */
    public void validateHomePhone(FacesContext context, UIComponent component, Object value)
    {
        String number = (String)value;
        try
        {
            for (char c: number.toCharArray())
            {
                Integer.parseInt(Character.toString(c));
            }
        }
        catch(NumberFormatException nfe)
        {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "invalidHomePhone", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        if (number.toCharArray().length != 10)
        {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "invalidHomeDigits", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
    
    /**
     * Registration form validation method for cell phone, same as for home phone,
     * verify that it is in fact a legitemate 10-digit phone number.
     * @author Giancarlo Biasiucci
     * @param context
     * @param component
     * @param value 
     */
    public void validateCellPhone(FacesContext context, UIComponent component, Object value)
    {
        String number = (String)value;
        try
        {
            for (char c: number.toCharArray())
            {
                Integer.parseInt(Character.toString(c));
            }
        }
        catch(NumberFormatException nfe)
        {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "invalidCellPhone", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        if (number.toCharArray().length != 10)
        {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "invalidCellDigits", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
    
    /**
     * Registration form postal code validation method, verifies that the postal code
     * entered is of a valid Canadian format.
     * @author Giancarlo Biasiucci
     * @param context
     * @param component
     * @param value 
     */
    public void validatePostalCode(FacesContext context, UIComponent component, Object value)
    {
        String postalCode = (String)value;
        UIInput postalCodeInput = (UIInput)component.findComponent("postalCode");
        boolean validPostalCode = Pattern.matches("[a-zA-Z][0-9][a-zA-Z][0-9][a-zA-Z][0-9]", postalCode);
        if (!validPostalCode)
        {
            FacesMessage msg = MessageLoader.getMessage("com.gb1w20.bundles.messages", "invalidPostalCode", null);
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
    
    /**
     * Tests login for a pair of credentials (email and password)
     * @author Giancarlo Biasiucci
     * @param loginEmail
     * @param password
     * @return
     * @throws Exception 
     */
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

    /**
     * Creates the login cookie for the user after successful login
     * @author Saad Khan
     * @param email 
     */
    private void createLoginCookie(String email) {
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        Cookie cookie = null;
        
        Cookie[] userCookies = request.getCookies();
        if (userCookies != null && userCookies.length > 0 ) {
            for (int i = 0; i < userCookies.length; i++) {
                if (userCookies[i].getName().equals("BOOK_STORE_LOGIN")) {
                    cookie = userCookies[i];
                    break;
                }
            }
        }

        if (cookie != null) {
            cookie.setValue(email);
        } else {
            cookie = new Cookie("BOOK_STORE_LOGIN", email);
            cookie.setPath(request.getContextPath());
        }
        
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
        response.addCookie(cookie);        
    }
}
