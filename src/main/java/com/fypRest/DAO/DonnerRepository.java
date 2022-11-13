package com.fypRest.DAO;

import com.fypRest.enitity.Donner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DonnerRepository extends JpaRepository<Donner, Integer>
{
    @Query("select d from Donner d join d.user u where u.id = :id")
    Donner findByUser(@Param("id") int id);
}
