package com.databases.demo;

import com.databases.demo.adapter.CreateReviewDtoToReviewAdapter;
import com.databases.demo.controllers.ReviewController;
import com.databases.demo.dto.CreateReviewDTO;
import com.databases.demo.models.Booking;
import com.databases.demo.models.Review;
import com.databases.demo.services.ReviewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.awt.print.Book;
import java.net.http.HttpResponse;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ReviewControllerTest {

    @InjectMocks
    private ReviewController reviewController;

    @Mock
    private ReviewService reviewService;

    @Mock
    private CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindReviewById_Success() {
        long reviewId = 1L;
        Review mockReview = Review.builder().build();
        mockReview.setId(reviewId);

        //Mocking
        when(reviewService.findReviewById(reviewId)).thenReturn(Optional.of(mockReview));

        //Running the test
        ResponseEntity<?>  response = this.reviewController.findReviewById(reviewId);

        //Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    public void testPublishReview_Success() {
        CreateReviewDTO requestDto = new CreateReviewDTO();
        Booking booking = new Booking();
        booking.setId(1L);
        requestDto.setBookingId(booking.getId());


        Review incomingReview = Review.builder()
                .content("Testing content")
                .rating(4.5)
                .booking(booking)
                .build();

        when(createReviewDtoToReviewAdapter.convertDto(requestDto)).thenReturn(incomingReview);

        Review savedReview = Review
                .builder()
                .content(incomingReview.getContent())
                .rating(incomingReview.getRating())
                .booking(incomingReview.getBooking())
                .build();

        when(reviewService.publishReview(incomingReview)).thenReturn(savedReview);

        ResponseEntity<?> response = reviewController.publishReview(requestDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());

    }


}
