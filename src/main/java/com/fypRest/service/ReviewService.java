package com.fypRest.service;

import com.fypRest.DAO.ReviewRepository;
import com.fypRest.enitity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService
{
    @Autowired
    private ReviewRepository reviewRepository;

    public void save(Review review)
    {
        reviewRepository.save(review);
    }

    public Review findById(int id)
    {
        Review newReview =null;
        Optional<Review> review = reviewRepository.findById(id);
        if(review.isPresent())
        {
            newReview = review.get();
        }
        return newReview;
    }

    public void deleteById(int id)
    {
        Review review = this.findById(id);
        reviewRepository.delete(review);
        //reviewRepository.deleteById(id);
    }
}
