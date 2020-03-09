
package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.entities.Clients;
import com.gb1w20.book_store_project.jpa_controllers.ClientsJpaController;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("clientManagement")
@SessionScoped
public class ClientManagementBean implements Serializable  {
     
     private final static Logger LOG = LoggerFactory.getLogger(ClientManagementBean.class);
     
      @Inject
      private ClientsJpaController clientCtrl;
      
      private String query = "";
      private Collection<Object[]> results;
      
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
     
     public Collection<Object[]> getResults(){
          return results;
     }

     private void updateBean() {
          LOG.debug(query);
          results = clientCtrl.searchClients(query);
          LOG.debug(results.toString());
     }
     
     public void onKeyUp() {
          updateBean();
     }
     
}
