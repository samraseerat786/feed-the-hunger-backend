package com.fypRest.DAO;

import com.fypRest.enitity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer>
{
    @Query("select r from Review r join r.donner d where d.id = :id")
    List<Review> findByDonner(@Param("id") int id);
}
