package com.fypRest.Controller;

import com.fypRest.DAO.ReportRepository;
import com.fypRest.enitity.Report;
import com.fypRest.service.ReportServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping("reports")
public class ReportController
{
    @Autowired
    private ReportServices reportService;
    @Autowired
    private ReportRepository reportRepository;

    @RequestMapping("")
    public List<Report> getReport()
    {
        return reportRepository.findAll();
    }
    @GetMapping("/list")
    public Page<Report> getReports(@RequestParam Optional<Integer> page)
    {
        return reportRepository.findAll(PageRequest.of(page.orElse(0) , 5 ));
    }

    @GetMapping("/findByDonner/{id}")
    public Page<Report> getReports(@PathVariable int id)
    {
        List<Report> p =  reportRepository.findByDonner(id);
        Page<Report> page = new PageImpl<>(p);
        return page;
    }
    @PostMapping("/add")
    public Report newReport(@RequestBody Report theReport)
    {
        System.out.println(theReport);
        reportService.save(theReport);
        System.out.println(theReport);
        return theReport;
    }
    @PutMapping("/update")
    public Report updateReport(@RequestBody Report theReport)
    {
        System.out.println(theReport);
        reportService.save(theReport);
        System.out.println(theReport);
        return theReport;
    }
    @DeleteMapping("/delete/{id}")
    public String deleteReport(@PathVariable int ReportId)
    {
        // reportService.deleteById(reportId);
        return "Report id - " + ReportId + " is deleted.";
    }
}
