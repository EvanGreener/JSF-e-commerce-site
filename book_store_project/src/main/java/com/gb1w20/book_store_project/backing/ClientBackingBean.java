package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.entities.Clients;
import com.gb1w20.book_store_project.jpa_controllers.ClientsJpaController;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
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

    /**
     * Save the current client to the db
     *
     * @return
     * @throws Exception
     */
    public String createClient() throws Exception {
        client.setLastModified(new Date());
        client.setDateEntered(new Date());
        client.setIsRemoved(false);
        client.setIsManager(false);
        clientsJpaController.create(client);
        return "index.xhtml";
    }
}
