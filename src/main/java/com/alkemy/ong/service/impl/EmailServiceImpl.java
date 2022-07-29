package com.alkemy.ong.service.impl;

import com.alkemy.ong.service.IEmailService;
import com.alkemy.ong.utils.EmailUtils;
import com.sendgrid.Content;
import com.sendgrid.Email;

public class EmailServiceImpl implements IEmailService {

    private String templateId;
    private String organizationId;
    private String sendGridKey;
    private String templateContactId;


    public void sendEmail(Email email) {

    }

    public void getEmailReady(String to, String template, String contentValue, String subject) {
        Email fromEmail = new Email(organizationId);
        Email toEmail = new Email(to);
        Content content = new Content("text/html", contentValue);
    }

    public void checkFromRequest(String to, String from) {
        if (from.toLowerCase().equals("userRegistered"))
            getEmailReady(to, templateId, EmailUtils.content("Bienvenido!", "Gracias por registrarse!"), "Organization Name");
        else
            getEmailReady(to, templateContactId, EmailUtils.content("Solicitud recibida",
                    "Muchas gracias por \n " + "contactarte con nosotros \n " +
                            "te mandaremos un mensaje a la brevedad"), "Somos mas Ong");
    }
}
