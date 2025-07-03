package com.example.uberprojectreviewservice.repositories;

import com.example.uberprojectreviewservice.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {



}
