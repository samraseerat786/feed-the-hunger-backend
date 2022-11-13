package com.fypRest.Controller;

import com.fypRest.DAO.FoodDonationDetailsRepository;
import com.fypRest.enitity.FoodDonationDetails;
import com.fypRest.service.FoodDonationDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/foodDonationDetails")
public class FoodDonationDetailsController
{
    @Autowired
    private FoodDonationDetailsService foodDonationDetailsService;

    @Autowired
    private FoodDonationDetailsRepository foodDonationDetailsRepository;

    @GetMapping("/list")
    public Page<FoodDonationDetails> getFoodDonationDetails(@RequestParam Optional<Integer> page)
    {
        return foodDonationDetailsRepository.findAll(PageRequest.of(page.orElse(0) , 5 ));
    }

    @PostMapping("/newFoodDonationDetails")
    public FoodDonationDetails newFoodDonationDetails(@RequestBody FoodDonationDetails theFoodDonationDetails)
    {
        System.out.println(theFoodDonationDetails);
        foodDonationDetailsService.save(theFoodDonationDetails);
        return theFoodDonationDetails;
    }
    @PutMapping("/updateFoodDonationDetails")
    public FoodDonationDetails updateFoodDonationDetails(@RequestBody FoodDonationDetails theFoodDonationDetails)
    {
        System.out.println(theFoodDonationDetails);
        foodDonationDetailsService.save(theFoodDonationDetails);
        System.out.println(theFoodDonationDetails);
        return theFoodDonationDetails;
    }
    @DeleteMapping("/deleteFoodDonationDetails/{foodDonationDetailsId}")
    public String deleteFoodDonationDetails(@PathVariable int foodDonationDetailsId)
    {
        foodDonationDetailsService.deleteById(foodDonationDetailsId);
        return "FoodDonationDetails id - " + foodDonationDetailsId + " is deleted.";
    }
}

