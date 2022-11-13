package com.fypRest.DAO;

import com.fypRest.enitity.Donner;
import com.fypRest.enitity.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Integer>
{
    @Query("select r from Report r join r.donner d where d.id = :id")
    List<Report> findByDonner(@Param("id") int id);
}
