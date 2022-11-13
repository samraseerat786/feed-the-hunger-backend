package com.fypRest.service;

import com.fypRest.DAO.ReportRepository;
import com.fypRest.enitity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServices
{
    @Autowired
    ReportRepository reportRepository;

    @Autowired
    public ReportServices()
    {
    }
    public void save(Report report)
    {
        reportRepository.save(report);
    }

    public void delete(int id)
    {
        reportRepository.deleteById(id);
    }

    public Report getById(int id)
    {
        Report report = reportRepository.getOne(id);
        return report;
    }

}
