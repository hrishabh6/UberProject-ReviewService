package com.databases.demo.repositories;

import com.databases.demo.models.Booking;
import com.databases.demo.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findByIdAndLicenceNumber(Long id, String licenceNumber);

    List<Driver> findAllByIdIn(List<Long> driverIds);




}
