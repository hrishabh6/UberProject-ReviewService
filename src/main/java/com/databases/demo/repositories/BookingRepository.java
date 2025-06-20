package com.databases.demo.repositories;

import com.databases.demo.models.Booking;
import com.databases.demo.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepository extends JpaRepository<Booking, Long> {



}
