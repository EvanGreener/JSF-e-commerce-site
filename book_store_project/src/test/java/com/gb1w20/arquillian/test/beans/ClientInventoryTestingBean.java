/*
 *All test beans belong to this package
 */
package com.gb1w20.arquillian.test.beans;

import com.gb1w20.book_store_project.entities.ClientInventory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bean used only for the purpose of performing arquillian tests on the client
 * inventory controller class
 *
 * @author shruti Pareek
 */
public class ClientInventoryTestingBean {
    
    private final static Logger LOG = LoggerFactory.getLogger(ClientInventoryTestingBean.class);

    public Integer clientId;
    public ClientInventory expectedClientInventory;

    /**
     * Constructor takes all necessary input needed for testing
     *
     * @param clientId
     * @param expectedClientInventory
     */
    public ClientInventoryTestingBean(Integer clientId, ClientInventory expectedClientInventory) {
        LOG.debug("ClientInventoryTestingBean");
        this.clientId = clientId;
        this.expectedClientInventory = expectedClientInventory;
    }

}
