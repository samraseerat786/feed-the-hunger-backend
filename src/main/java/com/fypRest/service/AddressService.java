package com.fypRest.service;

import com.fypRest.DAO.AddressRepository;
import com.fypRest.enitity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service
public class AddressService
{
    @Autowired
    private AddressRepository addressRepository;

    public void save(Address address)
    {
        addressRepository.save(address);
    }

    public Address findById(int id)
    {
        Address newAddress =null;
        Optional<Address> patient = addressRepository.findById(id);
        if(patient.isPresent())
        {
            newAddress = patient.get();
        }
        return newAddress;
    }

    public void deleteById(int id)
    {
        Address address = this.findById(id);
        addressRepository.delete(address);
        //addressRepository.deleteById(id);
    }

}
