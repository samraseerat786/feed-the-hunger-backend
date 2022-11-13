package com.fypRest.Controller;

import com.fypRest.DAO.FundDonationRepository;
import com.fypRest.enitity.FundDonation;
import com.fypRest.service.FundDonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping("/fundDonations")
public class FundDonationController
{
    @Autowired
    FundDonationService fundDonationService;

    @Autowired
    private FundDonationRepository fundDonationRepository;
    @GetMapping("/list")
    public Page<FundDonation> getFunds(@RequestParam Optional<Integer> page)
    {
        return fundDonationRepository.findAll(PageRequest.of(page.orElse(0) , 5 ));
    }

    @PostMapping("/newFundDonation")
    public FundDonation newFund(@RequestBody FundDonation theFundDonation)
    {
        fundDonationService.save(theFundDonation);
        return theFundDonation;
    }
    @PutMapping("/updateFundDonation")
    public FundDonation updateFund(@RequestBody FundDonation theFundDonation)
    {
        fundDonationService.save(theFundDonation);
        return theFundDonation;
    }
    @DeleteMapping("/deleteFundDonation/{fundDonationId}")
    public String deleteFund(@PathVariable int fundId)
    {
        fundDonationService.deleteById(fundId);
        return "Fund Donation with id - " + fundId + " is deleted.";
    }
}
