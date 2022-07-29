package com.alkemy.ong.service;

import com.sendgrid.Email;

public interface IEmailService {
    void sendEmail(Email email);
    void getEmailReady(String to, String from);
}
