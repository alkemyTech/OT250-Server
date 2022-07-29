package com.alkemy.ong.service;

import com.sendgrid.Email;

public interface IEmailService {
    void sendEmail(Email email);
    void getEmailReady(String to, String template, String content, String subject);
    void checkFromRequest(String to, String from);
}
