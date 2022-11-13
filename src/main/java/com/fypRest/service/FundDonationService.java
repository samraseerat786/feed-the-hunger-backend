package com.fypRest.service;

import com.fypRest.DAO.FundDonationRepository;
import com.fypRest.enitity.FundDonation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FundDonationService
{
    @Autowired
    private FundDonationRepository fundDonationRepository;

    @Autowired
    public FundDonationService(FundDonationRepository fundDonationRepository)
    {
        this.fundDonationRepository = fundDonationRepository;
    }

    public void save(FundDonation fundDonation)
    {
        fundDonationRepository.save(fundDonation);
    }

    public FundDonation findById(int id)
    {
        FundDonation newFundDonation =null;
        Optional<FundDonation> fundDonation = fundDonationRepository.findById(id);
        if(fundDonation.isPresent())
        {
            newFundDonation = fundDonation.get();
        }
        return newFundDonation;
    }

    public void deleteById(int id)
    {
        FundDonation fundDonation = this.findById(id);
        fundDonationRepository.delete(fundDonation);
        //fundRepository.deleteById(id);
    }

}
