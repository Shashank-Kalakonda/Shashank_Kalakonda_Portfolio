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

    @GetMapping("/test")
    public String test() {
        return "Backend is running on Render";
    }

    @PostMapping
    public String sendMessage(@RequestBody ContactRequest request) {

        try {
            emailService.sendEmail(
                    request.getEmail(),
                    request.getName(),
                    request.getMessage()
            );
            return "Message sent successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: " + e.getMessage();
        }
    }
}