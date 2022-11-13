package com.fypRest.DAO;

import com.fypRest.enitity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer>
{
}
