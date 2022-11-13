package com.fypRest.service;

import com.fypRest.DAO.DonationRepository;
import com.fypRest.enitity.Donation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DonationService
{
    @Autowired
    private DonationRepository donationRepository;

    public void save(Donation donation)
    {
        donationRepository.save(donation);
    }

    public Donation findById(int id)
    {
        Donation newDonation = null;
        Optional<Donation> patient = donationRepository.findById(id);
        if(patient.isPresent())
        {
            newDonation = patient.get();
        }
        return newDonation;
    }

    public void deleteById(int id)
    {
        Donation donation = this.findById(id);
        donationRepository.delete(donation);
        //donationRepository.deleteById(id);
    }

}
