package com.databases.demo.repositories;

import com.databases.demo.models.Booking;
import com.databases.demo.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("select r from Booking b inner join Review r on b.review = r where b.id = :bookingId")
    Review findReviewByBookingId(Long bookingId);

}
