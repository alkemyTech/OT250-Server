package com.alkemy.ong.service;

import com.sendgrid.Email;
import com.sendgrid.Mail;

public interface IEmailService {
    void sendEmail(Mail email);
    void getEmailReady(String to, String template, String content, String subject);
    void checkFromRequest(String to, String from);
}
