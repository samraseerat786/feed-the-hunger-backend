package com.fypRest.service;

import com.fypRest.DAO.DonationRepository;
import com.fypRest.DTO.CustomDonation;
import com.fypRest.enitity.Donation;
import com.fypRest.repository.CustomDonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonationService
{
    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private CustomDonationRepository customDonationRepository;


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

    public List<CustomDonation> findDonationById(Integer id, String userType)
    {
        return customDonationRepository.findAllDonationById(id, userType);
    }
    public boolean updateDonation(int id, int ngoId, String status, String time)
    {
        return customDonationRepository.updateDonationByID(id, ngoId, status, time);
    }
}
