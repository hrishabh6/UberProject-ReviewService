package com.databases.demo.services;

import com.databases.demo.models.Review;
import com.databases.demo.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class ReviewService implements CommandLineRunner {

    private ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Review r = Review
                .builder()
                .content("Amazing ride")
                .rating(5.0)
                .build();

        reviewRepository.save(r);

    }

}

