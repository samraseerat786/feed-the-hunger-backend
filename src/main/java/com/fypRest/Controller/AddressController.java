package com.fypRest.Controller;

import com.fypRest.DAO.AddressRepository;
import com.fypRest.enitity.Address;
import com.fypRest.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping("/addresses")
public class AddressController
{
    @Autowired
    private AddressService addressService;
    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/list")
    public Page<Address> getAddresses(@RequestParam Optional<Integer> page)
    {
        return addressRepository.findAll(PageRequest.of(page.orElse(0) , 5 ));
    }

    @PostMapping("/newAddress")
    public Address newAddress(@RequestBody Address theAddress)
    {
        System.out.println(theAddress);
        addressService.save(theAddress);
        System.out.println(theAddress);
        return theAddress;
    }
    @PutMapping("/updateAddress")
    public Address updateAddress(@RequestBody Address theAddress)
    {
        System.out.println(theAddress);
        addressService.save(theAddress);
        System.out.println(theAddress);
        return theAddress;
    }
    @DeleteMapping("/deleteAddress/{addressId}")
    public String deleteAddress(@PathVariable int addressId)
    {
        addressService.deleteById(addressId);
        return "Address id - " + addressId + " is deleted.";
    }
}
