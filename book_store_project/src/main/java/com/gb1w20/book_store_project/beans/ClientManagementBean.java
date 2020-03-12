package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.Clients;
import com.gb1w20.book_store_project.jpa_controllers.ClientsJpaController;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("clientManagement")
@SessionScoped
public class ClientManagementBean implements Serializable {

     private final static Logger LOG = LoggerFactory.getLogger(ClientManagementBean.class);

     @Inject
     private ClientsJpaController clientCtrl;

     private String query = "";
     private List<Object[]> results;
     private Clients currentClient;
     private String newEmail;
     private String newFname;
     private String newLname;

     @PostConstruct
     public void init() {
          LOG.debug("Init called!");
          updateBean();
     }

     public String getQuery() {
          return query;
     }

     public void setQuery(String newValue) {
          query = newValue;
     }

     public List<Object[]> getResults() {
          return results;
     }

     public Clients getCurrentClient() {
          return currentClient;
     }

     public String getNewEmail() {
          return newEmail;
     }

     public void setNewEmail(String newValue) {
          newEmail = newValue;
     }

     public String getNewFname() {
          return newFname;
     }

     public void setNewFname(String newValue) {
          newFname = newValue;
     }

     public String getNewLname() {
          return newLname;
     }

     public void setNewLname(String newValue) {
          newLname = newValue;
     }

     public void updateBean() {
          LOG.debug(query);
          results = clientCtrl.searchClients(query);
     }

     public void onEdit(Object id) {
          System.out.println(id);
          LOG.debug((String) id);
     }

}
