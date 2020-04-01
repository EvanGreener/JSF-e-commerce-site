package com.gb1w20.book_store_project.backing;

import com.gb1w20.book_store_project.beans.UserLoginBean;
import com.gb1w20.book_store_project.entities.Tax;
import com.gb1w20.book_store_project.jpa_controllers.TaxJpaController;
import java.io.Serializable;
import java.math.BigDecimal;
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

    @Inject
    private UserLoginBean userLoginBean;
    
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

    public Tax getTaxByProvince() {
        Tax info = taxsJpaController.getTaxByProvince(userLoginBean.getProvince());
        return info;
    }

    public double getTotalwithGST(double cartSubtotal) {
        Tax info = taxsJpaController.getTaxByProvince(userLoginBean.getProvince());
        BigDecimal gstBD = info.getGst();
        double gst = gstBD.doubleValue();
        double total = cartSubtotal * gst;
                total = Math.round(total * 100.0) / 100.0;

        return total;
    }

    public double getTotalwithPST(double cartSubtotal) {
        Tax info = taxsJpaController.getTaxByProvince(userLoginBean.getProvince());
        BigDecimal pstBD = info.getPst();
        double pst = pstBD.doubleValue();
        double total = cartSubtotal * pst;
                total = Math.round(total * 100.0) / 100.0;

        return total;
    }

    public double getTotalwithHST(double cartSubtotal) {
        Tax info = taxsJpaController.getTaxByProvince(userLoginBean.getProvince());
        BigDecimal hstBD = info.getHst();
        double hst = hstBD.doubleValue();
        double total = cartSubtotal * hst;
                total = Math.round(total * 100.0) / 100.0;

        return total;
    }

    public double getTotalWithTaxByProvince(double cartSubtotal) {
        Tax info = taxsJpaController.getTaxByProvince(userLoginBean.getProvince());
        BigDecimal gstBD = info.getGst();
        BigDecimal pstBD = info.getPst();
        BigDecimal hstBD = info.getHst();

        double gst = gstBD.doubleValue() + 1;
        double pst = pstBD.doubleValue() + 1;
        double hst = hstBD.doubleValue() + 1;

        double total = cartSubtotal * gst;
        total *= pst;
        total *= hst;
        total = Math.round(total * 100.0) / 100.0;

        return total;
    }
}
