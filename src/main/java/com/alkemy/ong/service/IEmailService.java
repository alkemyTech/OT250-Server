package com.alkemy.ong.service;

import com.sendgrid.Email;
import com.sendgrid.Mail;

import java.io.IOException;

public interface IEmailService {
    void sendEmail(Mail email) throws IOException;
    void getEmailReady(String to, String template, String content, String subject) throws IOException;
    void checkFromRequest(String to, String from) throws IOException;
}
