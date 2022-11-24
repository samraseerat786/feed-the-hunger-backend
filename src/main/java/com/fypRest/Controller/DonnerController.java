package com.fypRest.Controller;

import com.EmailSender.dto.MailRequest;
import com.EmailSender.dto.MailResponse;
import com.EmailSender.newEmailSender.ServiceEmail;
import com.EmailSender.service.EmailService;
import com.fypRest.DAO.DonnerRepository;
import com.fypRest.DAO.UserRepository;
import com.fypRest.enitity.Donner;
import com.fypRest.enitity.User;
import com.fypRest.repository.CustomDonationRepository;
import com.fypRest.service.DonnerService;
import com.fypRest.service.StringService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    @Autowired
    private CustomDonationRepository customDonationRepository;

    @GetMapping("/list")
    public List<JSONObject> getDonners()
    {
        List<Donner> donors = donnerRepository.findAll();
        List<JSONObject> donorJsonObjects = new ArrayList<>();
        for (Donner d: donors) {
            List<Integer> stars = customDonationRepository.getStarRatingByDonorId(d.getId());
            double rating = this.calculateAverage(stars);
            JSONObject response = new JSONObject();
            response.put("donor", d);
            response.put("rating", rating);
            donorJsonObjects.add(response);
        }
        return donorJsonObjects;
    }

    private double calculateAverage(List <Integer> stars) {
        Integer sum = 0;
        if(!stars.isEmpty()) {
            for (Integer mark : stars) {
                sum += mark;
            }
            return sum.doubleValue() / stars.size();
        }
        return sum;
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
        MailRequest request = new MailRequest("Feed the hunger", u.getEmail(), "feed.hunger786@gmail.com", "Confirmation Email");
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
