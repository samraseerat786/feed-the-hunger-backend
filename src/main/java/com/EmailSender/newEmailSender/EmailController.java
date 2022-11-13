package com.EmailSender.newEmailSender;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController
{
    @PostMapping("/send/{email}")
    public String sendMail(@PathVariable String email){
        ServiceEmail serviceEmail = new ServiceEmail();
        return serviceEmail.sendEmail(email);
    }
}
