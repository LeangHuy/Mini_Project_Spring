package org.example.btb_group_01_spring_mini_project.service;

import jakarta.mail.MessagingException;

public interface EmailService {

    void sendMail(String optCode,String email) throws MessagingException;
}
