package com.bookings.simple.booking;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookingServiceImpl implements IBookingService {
    private final IBookingDao bookingDao;

    @Override
    public List<Booking> getAll() {
        return bookingDao.findAll();
    }

    @Override
    public Booking get(Long id) {
        return bookingDao.findById(id).orElseThrow();
    }

    @Override
    public List<Booking> getByUser(Long userId) {
        return bookingDao.findByUserId(userId);
    }

    @Override
    public Booking save(Booking booking) {
        return bookingDao.save(booking);
    }

    @Override
    public Booking update(Booking booking) {
        return null;
    }

    @Override
    public void delete(Long id) {
        bookingDao.deleteById(id);
    }
}
