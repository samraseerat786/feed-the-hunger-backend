package com.fypRest.service;

import com.fypRest.DAO.DonnerRepository;
import com.fypRest.enitity.Donner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonnerService
{
    @Autowired
    private DonnerRepository donnerRepository;

    @Autowired
    public DonnerService(DonnerRepository donnerRepository)
    {
        this.donnerRepository = donnerRepository;
    }

    public DonnerService()
    {

    }

    public void save(Donner donner)
    {
        donnerRepository.save(donner);
    }

    public Donner findById(int id)
    {
        Donner newDonner =null;
        Optional<Donner> donner = donnerRepository.findById(id);
        if(donner.isPresent())
        {
            newDonner = donner.get();
        }
        return newDonner;
    }

    public void deleteById(int id)
    {
        Donner donner = this.findById(id);
        donnerRepository.delete(donner);
        //donnerRepository.deleteById(id);
    }
}
