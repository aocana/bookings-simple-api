package com.bookings.simple.booking;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookingService extends JpaRepository<Booking, Long> {
}
