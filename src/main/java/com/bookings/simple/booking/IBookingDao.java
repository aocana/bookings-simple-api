package com.bookings.simple.booking;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookingDao extends JpaRepository<Booking, Long> {
}
