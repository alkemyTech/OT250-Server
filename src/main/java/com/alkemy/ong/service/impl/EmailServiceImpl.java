package com.alkemy.ong.service.impl;

import com.alkemy.ong.service.IEmailService;
import com.sendgrid.Email;

public class EmailServiceImpl implements IEmailService {

    private String templateId;
    private String organizationId;
    private String sendGridKey;
    private String templateContactId;


    public void sendEmail(Email email) {

    }

    public void getEmailReady(String to, String template, String content, String subject) {

    }

    public void checkFromRequest(String to, String from) {

    }
}
