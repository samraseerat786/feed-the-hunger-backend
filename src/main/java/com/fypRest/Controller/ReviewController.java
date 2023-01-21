package com.fypRest.Controller;

import com.fypRest.DAO.ReviewRepository;
import com.fypRest.DTO.Response;
import com.fypRest.enitity.Review;
import com.fypRest.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping("/reviews")
public class ReviewController
{
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/list")
    public Page<Review> getReviews(@RequestParam Optional<Integer> page)
    {
        return reviewRepository.findAll(PageRequest.of(page.orElse(0) , 5 ));
    }

    @PostMapping("/newReview")
    public Review newReview(@RequestBody Review theReview)
    {
        System.out.println(theReview);
        reviewService.save(theReview);
        System.out.println(theReview);
        return theReview;
    }
    @PutMapping("/updateReview")
    public Review updateReview(@RequestBody Review theReview)
    {
        System.out.println(theReview);
        reviewService.save(theReview);
        System.out.println(theReview);
        return theReview;
    }
    @DeleteMapping("/deleteReview/{reviewId}")
    public Response deleteReview(@PathVariable int reviewId)
    {
        reviewService.deleteById(reviewId);
        return new Response("Review is deleted.", "200");
    }

    @GetMapping("/findByDonner/{id}")
    public Page<Review> getReports(@PathVariable int id)
    {
        List<Review> p =  reviewRepository.findByDonner(id);
        Page<Review> page = new PageImpl<>(p);
        return page;
    }
}
