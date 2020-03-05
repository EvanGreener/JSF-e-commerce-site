package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.entities.Tax;
import com.gb1w20.book_store_project.jpa_controllers.TaxJpaController;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("taxBacking")
@RequestScoped
public class TaxBackingBean implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(TaxBackingBean.class);

    @Inject
    private TaxJpaController taxsJpaController;

    private Tax tax;

    /**
     * Tax created if it does not exist.
     *
     * @return
     */
    public Tax getTax() {
        if (tax == null) {
            tax = new Tax();
        }
        return tax;
    }

    /**
     * Save the current tax to the db
     *
     * @return
     * @throws Exception
     */
    public String createTax() throws Exception {
        taxsJpaController.create(tax);
        return null;
    }
}
