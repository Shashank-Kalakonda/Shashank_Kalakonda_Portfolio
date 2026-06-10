package com.example.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String fromEmail, String name, String message) {

        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setTo("shashankkalakonda789@gmail.com"); // YOU receive it
        mail.setSubject("New Contact Form Message from " + name);

        mail.setText(
                "Name: " + name + "\n" +
                        "Email: " + fromEmail + "\n\n" +
                        "Message:\n" + message
        );

        mailSender.send(mail);
    }
}