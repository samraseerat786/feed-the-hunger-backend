package com.fypRest.service;

import com.fypRest.DAO.FeedbackRepository;
import com.fypRest.enitity.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeedbackService
{
    @Autowired
    private FeedbackRepository feedbackRepository;

    public void save(Feedback feedback)
    {
        feedbackRepository.save(feedback);
    }

    public Feedback findById(int id)
    {
        Feedback newFeedback =null;
        Optional<Feedback> patient = feedbackRepository.findById(id);
        if(patient.isPresent())
        {
            newFeedback = patient.get();
        }
        return newFeedback;
    }

    public void deleteById(int id)
    {
        Feedback feedback = this.findById(id);
        feedbackRepository.delete(feedback);
        //feedbackRepository.deleteById(id);
    }
}
