package com.bookings.simple.booking;


import java.util.List;

public interface IBookingService{
    List<Booking> getAll();
    Booking get(Long id);
    List<Booking> getByUser(Long userId);
    Booking save(Booking booking);
    Booking update(Booking booking);
    void delete(Long id);
}
