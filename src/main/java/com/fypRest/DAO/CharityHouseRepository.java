package com.fypRest.DAO;

import com.fypRest.enitity.CharityHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CharityHouseRepository extends JpaRepository<CharityHouse, Integer>
{
    @Query("select ch from CharityHouse ch join ch.user u where u.id = :id")
    CharityHouse findByUser(@Param("id") int id);
}
