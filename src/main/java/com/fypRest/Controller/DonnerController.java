package com.fypRest.Controller;

import com.EmailSender.dto.MailRequest;
import com.EmailSender.dto.MailResponse;
import com.EmailSender.newEmailSender.ServiceEmail;
import com.EmailSender.service.EmailService;
import com.fypRest.DAO.DonnerRepository;
import com.fypRest.DAO.UserRepository;
import com.fypRest.enitity.Donner;
import com.fypRest.enitity.User;
import com.fypRest.service.DonnerService;
import com.fypRest.service.StringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping("/donners")
public class DonnerController
{
    @Autowired
    private EmailService service;

    @Autowired
    StringService stringService;

    @Autowired
    private DonnerService donnerService;
    @Autowired
    private DonnerRepository donnerRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/list")
    public Page<Donner> getDonners(@RequestParam Optional<Integer> page)
    {
        return donnerRepository.findAll(PageRequest.of(page.orElse(0), 5));
    }

    @RequestMapping()
    public Donner getDonner(@PathVariable int id){
        return donnerService.findById(id);
    }
    @PostMapping("/newDonner")
    public Donner newDonner(@RequestBody Donner theDonner)
    {
        System.out.println(theDonner);
        User u = theDonner.getUser();
        System.out.println(u);
        MailRequest request = new MailRequest("Charity App", u.getEmail(), "charity.application501@gmail.com", "Confirmation Email");
        Map<String, Object> model = new HashMap<>();
        model.put("Name", request.getName());
        model.put("location", "Islamabad, Pakistan");
        MailResponse response = service.sendEmail(request, model);
//        ServiceEmail serviceEmail = new ServiceEmail();
//        String responce = serviceEmail.sendEmail(theDonner.getUser().getEmail());
        String responce =  response.getMessage();
        System.out.println(responce);
        donnerService.save(theDonner);
        System.out.println(theDonner);
        return theDonner;
    }

    @PutMapping("/updateDonner")
    public Donner updateDonner(@RequestBody Donner theDonner)
    {
        System.out.println(theDonner);
        donnerService.save(theDonner);
        System.out.println(theDonner);
        return theDonner;
    }

    @DeleteMapping("/deleteDonner/{donnerId}")
    public String deleteDonner(@PathVariable int donnerId)
    {
        donnerService.deleteById(donnerId);
        return "Donner id - " + donnerId + " is deleted.";
    }

    @GetMapping("findById/{id}")
    public Donner findByID(@PathVariable int id)
    {
        return donnerService.findById(id);
    }

    @GetMapping("/stringReverse/{s}")
    public String reverseString(@PathVariable String s)
    {
        if(s==null){
            return "Invalid input. You must enter a string containing something.";
        } else{
            return stringService.reverseString(s);
        }
    }
}
