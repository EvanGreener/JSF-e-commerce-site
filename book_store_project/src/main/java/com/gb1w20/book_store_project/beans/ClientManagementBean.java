package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.Clients;
import com.gb1w20.book_store_project.jpa_controllers.ClientsJpaController;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
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
     private String newFname;
     private String newLname;
     private String newAddress1;
     private String newAddress2;
     private String newCell;
     private String newCompanyName;

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
     
      public String getNewAddress1() {
          return newAddress1;
     }

     public String getNewAddress2() {
          return newAddress2;
     }

     public String getNewCell() {
          return newCell;
     }

     public String getNewCompanyName() {
          return newCompanyName;
     }

     public void setNewAddress1(String newAddress1) {
          this.newAddress1 = newAddress1;
     }

     public void setNewAddress2(String newAddress2) {
          this.newAddress2 = newAddress2;
     }

     public void setNewCell(String newCell) {
          this.newCell = newCell;
     }

     public void setNewCompanyName(String newCompanyName) {
          this.newCompanyName = newCompanyName;
     }
     
     

     public void updateBean() {
          LOG.debug(query);
          results = clientCtrl.searchClients(query);
     }

     public void onEdit(int id) {
          LOG.debug(id + "");
          currentClient = clientCtrl.findClients(id);

     }

}
