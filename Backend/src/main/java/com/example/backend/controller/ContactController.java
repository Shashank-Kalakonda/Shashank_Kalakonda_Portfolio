package com.example.backend.controller;

import com.example.backend.model.ContactRequest;
import com.example.backend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "*")
public class ContactController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public String sendMessage(@RequestBody ContactRequest request) {

        emailService.sendEmail(
                request.getEmail(),
                request.getName(),
                request.getMessage()
        );

        return "Message sent successfully!";
    }
}