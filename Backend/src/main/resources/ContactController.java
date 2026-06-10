ackage com.example.backend.controller;

import com.example.backend.model.ContactRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin("*")
public class ContactController {

    @PostMapping
    public String sendMessage(@RequestBody ContactRequest request) {
        System.out.println("New message from: " + request.getEmail());
        return "Message received successfully!";
    }
}