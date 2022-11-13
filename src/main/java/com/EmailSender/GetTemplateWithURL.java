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
        String url = "https://food-distribution-app.herokuapp.com/users/applicationStatus/" + mail;
        theModel.addAttribute("mailURL", url);
        return "email-template";
    }
}

