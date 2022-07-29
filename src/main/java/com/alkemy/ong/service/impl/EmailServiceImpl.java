package com.alkemy.ong.service.impl;

import com.alkemy.ong.service.IEmailService;
import com.alkemy.ong.utils.EmailUtils;
import com.sendgrid.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailServiceImpl implements IEmailService {
    @Value("${alkemy.ong.email.templateid}")
    private String templateId;
    @Value("${alkemy.ong.email.sender}")
    private String organizationId;
    @Value("${alkemy.ong.email.apikey}")
    private String sendGridKey;
    @Value("${alkemy.ong.email.templateidcontact}")
    private String templateContactId;

    public void sendEmail(Mail email) throws IOException {
        SendGrid sendGrid = new SendGrid(sendGridKey);
        Request request = new Request();
        try{
            request.setMethod(Method.POST);
            request.setEndpoint("/mail/send");
            request.setBody(email.build());
            Response response = sendGrid.api(request);
        } catch (IOException ex) {
            throw ex;
        }
    }

    public void getEmailReady(String to, String template, String contentValue, String subject) throws IOException {
        Email fromEmail = new Email(organizationId);
        Email toEmail = new Email(to);
        Content content = new Content("text/html", contentValue);
        Mail mail = new Mail(fromEmail, subject, toEmail, content);
        sendEmail(mail);
    }

    public void checkFromRequest(String to, String from) throws IOException {
        if (from.equalsIgnoreCase("userRegistered"))
            getEmailReady(to, templateId, EmailUtils.content("Bienvenido!", "Gracias por registrarse!"), "ALKEMY ONG");
        else
            getEmailReady(to, templateContactId, EmailUtils.content("Solicitud recibida",
                    "Muchas gracias por \n " + "contactarte con nosotros \n " +
                            "te mandaremos un mensaje a la brevedad"), "Somos mas Ong");
    }
}
