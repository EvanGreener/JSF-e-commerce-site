/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.beans;

import com.gb1w20.book_store_project.backing.CartBackingBean;
import com.gb1w20.book_store_project.backing.TaxBackingBean;
import com.gb1w20.book_store_project.entities.Book;
import java.util.List;
import java.util.Objects;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Saad
 */
@Named
@RequestScoped
public class MailBean {

    private final static Logger LOG = LoggerFactory.getLogger(MailBean.class);

    @Inject
    private CartBackingBean cartbb;
    @Inject
    private TaxBackingBean taxbb;

    private String sendTo;
    private String plainTextMsg;
    private String htmlTextMsg;
    private String subject;

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    public String getPlainTextMsg() {
        return plainTextMsg;
    }

    public void setPlainOrderTextMsg() {
        List<Book> CartItems = cartbb.getCartItems();
        String plainTextMsg = "<h1>TheBookStore"
                + "<h2>"+this.getSubject()+"</h2><ul>\n";
        for (int i = 0; i < CartItems.size(); i++) {
            plainTextMsg = plainTextMsg.concat("<li>" + CartItems.get(i).getTitle() + ": " + CartItems.get(i).getListPrice() + "</li>");
        }
        plainTextMsg = plainTextMsg.concat("</ul><br/><hl/><p>Sub-Total: "
                + cartbb.getCartTotal()
                + "</p><p>GST (" + taxbb.getTaxByProvince().getGst() + "): " + taxbb.getTotalwithGST(cartbb.getCartTotal()) + "</p>"
                + "<p>HST (" + taxbb.getTaxByProvince().getHst() + "): " + taxbb.getTotalwithHST(cartbb.getCartTotal()) + "</p>"
                + "<p>PST (" + taxbb.getTaxByProvince().getPst() + "): " + taxbb.getTotalwithPST(cartbb.getCartTotal()) + "</p>"
                + "<strong>Total: " + cartbb.getCartTotalAfterTax() + "</strong>"
        );
        this.plainTextMsg = plainTextMsg;
    }

    public void setPlainTextMsg(String plainTextMsg) {
        this.plainTextMsg = plainTextMsg;
    }

    public String getHtmlTextMsg() {
        return htmlTextMsg;
    }

    public void setHtmlTextMsg(String htmlTextMsg) {
        this.htmlTextMsg = htmlTextMsg;
    }

    public void setHtmlOrderTextMsg() {
        String htmlTextMsg = "<html><META http-equiv=Content-Type "
                + "content=\"text/html; charset=utf-8\">"
                + "<body> " + this.getPlainTextMsg() + "</body></html>";

        this.htmlTextMsg = htmlTextMsg;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.sendTo);
        hash = 53 * hash + Objects.hashCode(this.plainTextMsg);
        hash = 53 * hash + Objects.hashCode(this.htmlTextMsg);
        hash = 53 * hash + Objects.hashCode(this.subject);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MailBean other = (MailBean) obj;
        if (!Objects.equals(this.sendTo, other.sendTo)) {
            return false;
        }
        if (!Objects.equals(this.plainTextMsg, other.plainTextMsg)) {
            return false;
        }
        if (!Objects.equals(this.htmlTextMsg, other.htmlTextMsg)) {
            return false;
        }
        if (!Objects.equals(this.subject, other.subject)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MailBean{sendTo=").append(sendTo);
        sb.append(", plainTextMsg=").append(plainTextMsg);
        sb.append(", htmlTextMsg=").append(htmlTextMsg);
        sb.append(", subject=").append(subject);
        sb.append('}');
        return sb.toString();
    }
}
