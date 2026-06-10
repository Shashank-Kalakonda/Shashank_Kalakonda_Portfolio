package com.example.backend.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ResumeController {

    private static final String RESUME_PATH = "uploads/resume.pdf";


    // VIEW (inline for browser embedding)
    @GetMapping("/resume/view")
    public ResponseEntity<Resource> viewResume() {

        File file = new File(RESUME_PATH);

        if (!file.exists()) {
            return ResponseEntity.notFound().build();
        }

        Resource resource = new FileSystemResource(file);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=resume.pdf")
                .body(resource);
    }

    // DOWNLOAD
    @GetMapping("/resume/download")
    public ResponseEntity<Resource> downloadResume() {

        File file = new File(RESUME_PATH);

        if (!file.exists()) {
            return ResponseEntity.notFound().build();
        }

        Resource resource = new FileSystemResource(file);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Shashank_Resume.pdf")
                .body(resource);
    }
}