package com.fypRest.service;

import com.fypRest.DAO.CharityHouseRepository;
import com.fypRest.enitity.CharityHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service
public class CharityHouseService
{
    @Autowired
    private CharityHouseRepository charityHouseRepository;

    @Autowired
    public CharityHouseService(CharityHouseRepository charityHouseRepository)
    {
        this.charityHouseRepository = charityHouseRepository;
    }

//    @GetMapping("/list")
//    public Page<CharityHouse> getAllCharityHouses(@RequestParam Optional<Integer> page)
//    {
//        return charityHouseRepository.findAll(PageRequest.of(page.orElse(0) , 5 ));
//    }

    public void save(CharityHouse charityHouse)
    {
        charityHouseRepository.save(charityHouse);
    }

    public CharityHouse findById(int id)
    {
        CharityHouse newCharityHouse =null;
        Optional<CharityHouse> patient = charityHouseRepository.findById(id);
        if(patient.isPresent())
        {
            newCharityHouse = patient.get();
        }
        return newCharityHouse;
    }

    public void deleteById(int id)
    {
        CharityHouse charityHouse = this.findById(id);
        charityHouseRepository.delete(charityHouse);
        //charityHouseRepository.deleteById(id);
    }

}
