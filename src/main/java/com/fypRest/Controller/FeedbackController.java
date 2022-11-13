package com.fypRest.Controller;

import com.fypRest.DAO.FeedbackRepository;
import com.fypRest.enitity.Feedback;
import com.fypRest.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping("/feedbacks")
public class FeedbackController
{
    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private FeedbackRepository feedbackRepository;

    @GetMapping("/list")
    public Page<Feedback> getFeedbacks(@RequestParam Optional<Integer> page)
    {
        return feedbackRepository.findAll(PageRequest.of(page.orElse(0) , 5 ));
    }

    @PostMapping("/newFeedback")
    public Feedback newFeedback(@RequestBody Feedback theFeedback)
    {
        System.out.println(theFeedback);
        feedbackService.save(theFeedback);
        System.out.println(theFeedback);
        return theFeedback;
    }
    @PutMapping("/updateFeedback")
    public Feedback updateFeedback(@RequestBody Feedback theFeedback)
    {
        System.out.println(theFeedback);
        feedbackService.save(theFeedback);
        System.out.println(theFeedback);
        return theFeedback;
    }
    @DeleteMapping("/deleteFeedback/{feedbackId}")
    public String deleteFeedback(@PathVariable int feedbackId)
    {
        feedbackService.deleteById(feedbackId);
        return "Feedback id - " + feedbackId + " is deleted.";
    }

    @GetMapping("/findByDonner/{id}")
    public Page<Feedback> getReports(@PathVariable int id)
    {
        List<Feedback> p =  feedbackRepository.findByDonner(id);
        Page<Feedback> page = new PageImpl<>(p);
        return page;
    }
}
