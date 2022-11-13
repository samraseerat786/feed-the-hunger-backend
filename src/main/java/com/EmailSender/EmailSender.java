package com.EmailSender;

import com.EmailSender.dto.MailRequest;
import com.EmailSender.dto.MailResponse;
import com.EmailSender.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(allowedHeaders = "*")
public class EmailSender
{
    @Autowired
    private EmailService service;

    @PostMapping("/sendingEmail")
    public MailResponse sendEmail(@RequestBody MailRequest request)
    {
//        RestTemplate template = new RestTemplate();
//        String result = template.getForObject("http://localhost:8095/getJSPage", String.class);
//        System.out.println(result);
        Map<String, Object> model = new HashMap<>();
        model.put("Name", request.getName());
        model.put("location", "Bangalore,India");
//        return service.sendEmail(request, model);
        return null;
    }
}
