package com.example.uberprojectreviewservice.repositories;

import com.example.uberprojectentityservice.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {



}
