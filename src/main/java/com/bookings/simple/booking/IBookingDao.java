package com.bookings.simple.booking;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBookingDao extends JpaRepository<Booking, Long> {
    List<Booking> findByUserId  (Long userId);
}
