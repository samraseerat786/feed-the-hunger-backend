package com.fypRest.DAO;

import com.fypRest.enitity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DonationRepository extends JpaRepository<Donation, Integer>
{
    @Query("select donation from Donation donation join donation.donner d where d.id = :id")
    Donation findByDonner(@Param("id") int id);
}
