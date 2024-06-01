package com.mailSender.Controller;



import com.mailSender.Model.EmailEntity;
import com.mailSender.Repository.EmailRepository;
import com.mailSender.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://localhost:5173")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private EmailRepository emailRepository;

    @PostMapping
    public String sendEmail(@RequestBody EmailEntity emailEntity) {
        emailService.sendEmail(
                "your-email@example.com", // Replace with your email
                emailEntity.getSubject(),
                "Name: " + emailEntity.getName() + "\nEmail: " + emailEntity.getEmail() + "\n\nMessage: " + emailEntity.getMessage()
        );
        emailRepository.save(emailEntity);
        return "Email sent successfully";
    }
}
