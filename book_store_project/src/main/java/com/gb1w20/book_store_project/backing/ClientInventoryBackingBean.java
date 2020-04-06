package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.entities.ClientInventory;
import com.gb1w20.book_store_project.jpa_controllers.ClientInventoryJpaController;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("inventoryBacking")
@RequestScoped
public class ClientInventoryBackingBean implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(ClientInventoryBackingBean.class);

    @Inject
    private ClientInventoryJpaController inventoryJpaController;

    private ClientInventory clientInventory;

    /**
     * ClientInventory created if it does not exist.
     *
     * @return
     */
    public ClientInventory getClientInventory() {
        if (clientInventory == null) {
            clientInventory = new ClientInventory();
        }
        return clientInventory;
    }

    /**
     * Save the current client inventory to the db
     *
     * @return
     * @throws Exception
     */
    public String createClientInventory() throws Exception {
        inventoryJpaController.create(clientInventory);
        return null;
    }
}

