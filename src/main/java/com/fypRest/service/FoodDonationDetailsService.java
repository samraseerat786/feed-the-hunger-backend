package com.fypRest.service;

import com.fypRest.DAO.FoodDonationDetailsRepository;
import com.fypRest.enitity.FoodDonationDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FoodDonationDetailsService
{
    @Autowired
    private FoodDonationDetailsRepository foodDontionDetailsRepository;

    public void save(FoodDonationDetails foodDontionDetails)
    {
        foodDontionDetailsRepository.save(foodDontionDetails);
    }

    public FoodDonationDetails findById(int id)
    {
        FoodDonationDetails newFoodDontionDetails =null;
        Optional<FoodDonationDetails> foodDonationDetails = foodDontionDetailsRepository.findById(id);
        if(foodDonationDetails.isPresent())
        {
            newFoodDontionDetails = foodDonationDetails.get();
        }
        return newFoodDontionDetails;
    }

    public void deleteById(int id)
    {
        FoodDonationDetails foodDontionDetails = this.findById(id);
        foodDontionDetailsRepository.delete(foodDontionDetails);
        //foodDontionDetailsRepository.deleteById(id);
    }

}
