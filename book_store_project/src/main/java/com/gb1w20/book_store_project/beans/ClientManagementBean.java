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

/**
 * 
 * @author Evan Greenstein
 */
@Named("clientManagement")
@SessionScoped
public class ClientManagementBean implements Serializable {

     private final static Logger LOG = LoggerFactory.getLogger(ClientManagementBean.class);

     @Inject
     private ClientsJpaController clientCtrl;

     private String query = "";
     private List<Object[]> results;
     private String searchBy = "email";
     private Clients currentClient;
     private String newFname;
     private String newLname;
     private String newAddress1;
     private String newAddress2;
     private String newCell;
     private String newCompanyName;

     /**
      * Updates the bean immediately once its firtst used.
      */
     @PostConstruct
     public void init() {
          LOG.debug("Init called!");
          updateBean();
     }

     public String getQuery() {
          return query;
     }

     public void setQuery(String query) {
          this.query = query;
     }

     public List<Object[]> getResults() {
          return results;
     }

     public void setResults(List<Object[]> results) {
          this.results = results;
     }

     public String getSearchBy() {
          return searchBy;
     }

     public void setSearchBy(String searchBy) {
          this.searchBy = searchBy;
     }

     public Clients getCurrentClient() {
          return currentClient;
     }

     public void setCurrentClient(Clients currentClient) {
          this.currentClient = currentClient;
     }

     public String getNewFname() {
          return newFname;
     }

     public void setNewFname(String newFname) {
          this.newFname = newFname;
     }

     public String getNewLname() {
          return newLname;
     }

     public void setNewLname(String newLname) {
          this.newLname = newLname;
     }

     public String getNewAddress1() {
          return newAddress1;
     }

     public void setNewAddress1(String newAddress1) {
          this.newAddress1 = newAddress1;
     }

     public String getNewAddress2() {
          return newAddress2;
     }

     public void setNewAddress2(String newAddress2) {
          this.newAddress2 = newAddress2;
     }

     public String getNewCell() {
          return newCell;
     }

     public void setNewCell(String newCell) {
          this.newCell = newCell;
     }

     public String getNewCompanyName() {
          return newCompanyName;
     }

     public void setNewCompanyName(String newCompanyName) {
          this.newCompanyName = newCompanyName;
     }
     
     /**
      * Gets called everytime the search is changed
      */
     public void updateBean() {
          LOG.debug(query);
          results = clientCtrl.searchClients(query, searchBy);
     }

     /**
      * When the client clicks the edit button in any given row
      * @param id the clients id
      */
     public void onClickEdit(int id) {
          LOG.debug(id + "");
          currentClient = clientCtrl.findClients(id);
     }
     
     /**
      * Because of the way our database works, the client's email cannot be changed.
      */
     public void onSubmitEdit() throws Exception{
          if (newFname != null && !newFname.isBlank() ){
               currentClient.setFirstName(newFname);
          }
          if (newLname != null && !newLname.isBlank() ){
               currentClient.setLastName(newLname);
          }
          if (newAddress1 != null && !newAddress1.isBlank() ){
               currentClient.setAddress1(newAddress1);
          }
          if (newAddress2 != null && !newAddress2.isBlank() ){
               currentClient.setAddress2(newAddress2);
          }
          if (newCell != null && !newCell.isBlank() ){
               currentClient.setCellTelephone(newCell);
          }
          if (newCompanyName != null && !newCompanyName.isBlank() ){
               currentClient.setCompanyName(newCompanyName);
          }
          
          LOG.debug("newAddress2:       " + newAddress2);
          LOG.debug("currentClient.getAddress2"+ currentClient.getAddress2());
          
          clientCtrl.edit(currentClient);
     }

}
