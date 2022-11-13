package com.fypRest.DAO;

import com.fypRest.enitity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer>
{
    @Query("select f from Feedback f join f.donner d where d.id = :id")
    List<Feedback> findByDonner(@Param("id") int id);
}
