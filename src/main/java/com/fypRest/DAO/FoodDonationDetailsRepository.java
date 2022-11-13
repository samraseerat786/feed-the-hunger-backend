package com.fypRest.DAO;

import com.fypRest.enitity.FoodDonationDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodDonationDetailsRepository extends JpaRepository<FoodDonationDetails, Integer>
{
}
