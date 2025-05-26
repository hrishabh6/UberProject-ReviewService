package com.databases.demo.services;

import com.databases.demo.models.Booking;
import com.databases.demo.models.Review;
import com.databases.demo.repositories.BookingRepository;
import com.databases.demo.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class ReviewService implements CommandLineRunner {

    private ReviewRepository reviewRepository;

    private BookingRepository bookingRepository;


    public ReviewService(
            ReviewRepository reviewRepository,
            BookingRepository bookingRepository
    ){
        this.bookingRepository = bookingRepository;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Review r = Review
                .builder()
                .content("Amazing ride")
                .rating(5.0)
                .build();

        Booking b = Booking
                .builder()
                .review(r)
                .build();


        bookingRepository.save(b);

    }

}

