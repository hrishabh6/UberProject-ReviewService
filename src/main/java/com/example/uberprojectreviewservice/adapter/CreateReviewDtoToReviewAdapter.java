package com.example.uberprojectreviewservice.adapter;

import com.example.uberprojectreviewservice.dto.CreateReviewDTO;
import com.example.uberprojectreviewservice.models.Booking;
import com.example.uberprojectreviewservice.models.Review;
import com.example.uberprojectreviewservice.repositories.BookingRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateReviewDtoToReviewAdapter {

    private final BookingRepository bookingRepository;

    public CreateReviewDtoToReviewAdapter(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Review convertDto(CreateReviewDTO dto) {
        if (dto == null) {
            System.out.println("DTO is null!");
            return null;
        }
        if (dto.getBookingId() == null || dto.getRating() == null || dto.getContent() == null) {
            System.out.println("DTO fields missing: " + dto);
            return null;
        }

        Booking booking = bookingRepository.findById(dto.getBookingId()).orElse(null);
        if (booking == null) {
            System.out.println("Booking not found for ID: " + dto.getBookingId());
            return null;
        }

        Review review = new Review();
        review.setContent(dto.getContent());
        review.setRating(dto.getRating());
        review.setBooking(booking);


        return review;
    }
}
