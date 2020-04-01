/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project;

import com.gb1w20.book_store_project.backing.TaxBackingBean;
import com.gb1w20.book_store_project.beans.MailBean;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import jodd.mail.Email;
import jodd.mail.MailServer;
import jodd.mail.SendMailSession;
import jodd.mail.SmtpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Saad
 */
@Named
@SessionScoped
public class MailSender implements Serializable {

    private final static Logger LOG = LoggerFactory.getLogger(TaxBackingBean.class);

    private final String emailSender;
    private final String smtpPassword;
    private final String smtpServerName;

    /**
     * Constructor that retrieves the email credentials from the web.xml
     */
    public MailSender() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        emailSender
                = ctx.getExternalContext().getInitParameter("emailSender");
        smtpPassword
                = ctx.getExternalContext().getInitParameter("smtpPassword");
        smtpServerName
                = ctx.getExternalContext().getInitParameter("smtpServerName");
    }

    public void sendOrderConfirmationEmail(MailBean mailBean) {

        SmtpServer smtpServer = MailServer.create()
                .ssl(true)
                .host(smtpServerName)
                .auth(emailSender, smtpPassword)
                .buildSmtpMailServer();

        Email email = Email.create().from(emailSender)
                .to(mailBean.getSendTo())
                .subject(mailBean.getSubject())
                .textMessage(mailBean.getPlainTextMsg())
                .htmlMessage(mailBean.getHtmlTextMsg());

        try ( SendMailSession session = smtpServer.createSession()) {
            session.open();
            session.sendMail(email);
            LOG.info("Email sent");
        }
    }
}
