package com.EmailSender;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GetTemplateWithURL
{
    @RequestMapping(value = "/getTemplate/{email}")
    public String getJSP(@PathVariable("email") String mail, Model theModel)
    {
        System.out.println(mail);
        // String url = "https://feed-the-hunger-backend.herokuapp.com/users/applicationStatus/" + mail;
        String url = "http://localhost:8095/users/applicationStatus/" + mail;
        theModel.addAttribute("mailURL", url);
        return "email-template";
    }
}

