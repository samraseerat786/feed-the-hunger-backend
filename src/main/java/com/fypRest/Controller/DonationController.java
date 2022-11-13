package com.fypRest.Controller;

import com.fypRest.DAO.DonationRepository;
import com.fypRest.enitity.Donation;
import com.fypRest.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping("/donations")
public class DonationController
{
    @Autowired
    private DonationService donationService;
    @Autowired
    private DonationRepository donationRepository;

    @GetMapping("/list")
    public Page<Donation> getDonations(@RequestParam Optional<Integer> page)
    {
        return donationRepository.findAll(PageRequest.of(page.orElse(0) , 5 ));
    }

    @GetMapping("/findByCharity/{id}")
    public List<Donation> getDonations(@PathVariable("id") int id)
    {
        List<Donation> donationList = null;
        try
        {
            List<Donation> donations = this.donationRepository.findAll();
            donationList = donations.stream()
                    .filter(donation -> donation.getCharityHouse().getId() == (id))
                    .collect(Collectors.toList());
            return donationList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return donationList;
    }
    @PostMapping("/newDonation")
    public Donation newDonation(@RequestBody Donation theDonation)
    {
        System.out.println(theDonation);
        donationService.save(theDonation);
        System.out.println(theDonation);
        return theDonation;
    }
    @PutMapping("/updateDonation")
    public Donation updateDonation(@RequestBody Donation theDonation)
    {
        System.out.println(theDonation);
        donationService.save(theDonation);
        System.out.println(theDonation);
        return theDonation;
    }
    @DeleteMapping("/deleteDonation/{donationId}")
    public String deleteDonation(@PathVariable int donationId)
    {
        donationService.deleteById(donationId);
        return "Donation id - " + donationId + " is deleted.";
    }
}
