package com.fypRest.DAO;

import com.fypRest.enitity.FundDonation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundDonationRepository extends JpaRepository<FundDonation, Integer>
{
}
